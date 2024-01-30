// 등수 찾기 (17616번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, X;
	static ArrayList<Integer>[] graph, reverseGraph;
	static boolean[] visited;
	
	static void init(int n) {
		graph = new ArrayList[n + 1];
		reverseGraph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];
	}
	
	static int find(int x, ArrayList<Integer>[] list) { // x보다 크거나 작은 노드를 찾는 함수
		int cnt = 0;
		Arrays.fill(visited, false);
		visited[x] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < list[cur].size(); i++) {
				int nxt = list[cur].get(i);
				if (!visited[nxt]) {
					visited[nxt] = true;
					queue.add(nxt);
					cnt++;
				}
 			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		init(N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// a가 b보다 잘했다
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b].add(a);
			reverseGraph[a].add(b);
		}
		
		int big = find(X, graph);
		int small = find(X, reverseGraph);
		int rest = N - (big + 1 + small); // 남은 수 -> 나보다 작다고 할 수 없음
		bw.write((big + 1) + " " + (rest + big + 1));
		bw.flush();
		bw.close();
		br.close();
	}
}