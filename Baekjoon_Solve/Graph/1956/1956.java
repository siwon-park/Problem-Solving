// 운동 (1956번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 1_000_000_009;
	static int V, E; // 마을 수, 간선 수
	static int[][] graph;
	
	/*
	 * 플로이드 워셜
	 * */
	static void floyd() {
		for (int k = 1; k < V + 1; k++) {
			for (int a = 1; a < V + 1; a++) {
				for (int b = 1; b < V + 1; b++) {
					if (graph[a][k] == MAX || graph[k][b] == MAX) continue;
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new int[V + 1][V + 1];
		for (int i = 0; i < V + 1; i++) Arrays.fill(graph[i], MAX);
		
		int a, b, c;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a][b] = c;
		}
		
		floyd();
		
		int minCycle = MAX;
		for (int i = 1; i < V + 1; i++) minCycle = Math.min(minCycle, graph[i][i]);
			
		if (minCycle == MAX) System.out.println(-1);
		else System.out.println(minCycle);
	}
}