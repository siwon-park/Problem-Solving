// 영일랜드 (31871번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static boolean[] visited;
	static int[][] graph;
	static int ans = -1;
	
	/*
	 * cur: 현재 노드, cnt: 방문한 노드의 수, d: 거리의 합
	 * */
	static void backtrack(int cur, int cnt, int d) {
		if (cnt > N) {
			if (cur == 0) {
				ans = Math.max(ans, d);		
			}
			return;
		}
		if (cnt != 0 && cur == 0) return; // 최적화; 현재 노드가 0이고 방문 노드 수가 0보다 크면 return
		
		for (int i = 0; i < N + 1; i++) {
			if (graph[cur][i] != 0 && !visited[i]) {
				visited[i] = true;
				backtrack(i, cnt + 1, d + graph[cur][i]);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N + 1];
		graph = new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[u][v] = Math.max(graph[u][v], d);
		}
		
		backtrack(0, 0, 0);
		System.out.println(ans);
	}
}

