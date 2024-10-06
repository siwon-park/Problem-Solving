// 절연 구간 최소화 (32197번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static ArrayList<int[]>[] graph;
	
	static int bfs(int a, int b) {
		int[] visited = new int[N + 1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[a] = 0;
		Deque<int[]> deque = new LinkedList<>();
		for (int i = 0; i < graph[a].size(); i++) {
			deque.add(new int[] {graph[a].get(i)[0], graph[a].get(i)[1], 0});
			visited[graph[a].get(i)[0]] = 0;
		}
		
		if (visited[b] == 0) return 0;
		
		while (!deque.isEmpty()) {
			int[] pair = deque.pollFirst();
			int cur = pair[0]; // 현재 노드
			int curT = pair[1]; // 현재 급전 방식
			int d = pair[2]; // 현재 비용
			if (cur == b) return visited[cur];
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i)[0];
				int nxtT = graph[cur].get(i)[1];
				if ((curT ^ nxtT) == 0) { // 두 비트가 같으면 급전 방식이 같음
					if (d < visited[nxt]) {
						visited[nxt] = d;
						deque.addFirst(new int[] {nxt, nxtT, d});
					}
				} else {
					if (d + 1 < visited[nxt]) {
						visited[nxt] = d + 1;
						deque.addLast(new int[] {nxt, nxtT, d + 1});
					}
				}
			}
		}
		return visited[b];
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph[s].add(new int[] {e, t});
			graph[e].add(new int[] {s, t});
		}
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int ans = bfs(A, B);
		System.out.println(ans);
	}
}

