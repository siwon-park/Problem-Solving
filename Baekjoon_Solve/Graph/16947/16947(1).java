// 서울 지하철 2호선 (16947번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N, c;
	static boolean[] isCycle;
	static boolean[][] visited;
	static int[] distance;
	static ArrayList<ArrayList<Integer>> graph;
	
	static boolean dfs(int s, int cur, int last) {
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i);
			if (!visited[s][nxt]) {
				visited[s][nxt] = true;
				dfs(s, nxt, cur);
			} else if (s == nxt && last != nxt) { // 출발 지점으로 돌아올 수 있으면 순환선에 포함된 정점
				isCycle[s] = true;
				return true;
			}
		}
		return isCycle[s];
	}
	
	static void bfs(int s) {
		Arrays.fill(distance, INF);
		distance[s] = 0;
		Deque<int[]> deque = new LinkedList<>();
		deque.addFirst(new int[] {s, 0});
		while (!deque.isEmpty()) {
			int[] pair = deque.poll();
			int cur = pair[0];
			int d = pair[1];
			for (int i = 0; i < graph.get(cur).size(); i++) {
				int nxt = graph.get(cur).get(i);
				if (distance[nxt] == INF && isCycle[nxt]) {
					distance[nxt] = 0;
					deque.addFirst(new int[] {nxt, 0});
				} else if (!isCycle[nxt] && d + 1 < distance[nxt]) {
					distance[nxt] = d + 1;
					deque.addLast(new int[] {nxt, d + 1});
				}
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1][N + 1];
		isCycle = new boolean[N + 1];
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
		
		int a, b;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		c = 1;
		for (int i = 1; i < N + 1; i++) {
			visited[i][i] = true;
			dfs(i, i, i);
			if (isCycle[i]) { // 사이클인 정점 한 개를 아무거나 기록
				c = i;
			}
		}
		
		distance = new int[N + 1];
		bfs(c);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(distance[i]);
			sb.append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}