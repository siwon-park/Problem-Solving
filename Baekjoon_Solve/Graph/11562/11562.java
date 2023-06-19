// 백양로 브레이크 (11562번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 1_000_000_009;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[n + 1][n + 1];
		int[][] oneWay = new int[n + 1][n + 1]; // 단방향 길
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(graph[i], MAX);
			graph[i][i] = 0; // i -> i로 가는 비용은 0
		}
		
		int u, v, b;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[u][v] = 0; // 일방 통행
			if (b == 1) { // 양방향 길인 경우
				graph[v][u] = 0;
			} else {
				oneWay[u][v] = 1;
			}
			
		}
		
		// 플로이드 워셜
		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					int cost1 = graph[i][k];
					int cost2 = graph[k][j];
					if (graph[i][k] == MAX && oneWay[k][i] == 1) { // i -> k가 갈 수 없는데 역방향이 일방 통행이면 양방향으로 바꿈
						cost1 = 1;
					}
					if (graph[k][j] == MAX && oneWay[j][k] == 1) {
						cost2 = 1;
					}
					graph[i][j] = Math.min(graph[i][j], cost1 + cost2);
				}
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		int s, e;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			int w = graph[s][e];
			bw.write(w + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}