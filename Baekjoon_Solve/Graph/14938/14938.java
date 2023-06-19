// 서강그라운드 (14938번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 1_000_000_009;
	static int N, M, R; // 지역의 수, 수색 범위, 길의 수
	static int[] items; // 각 구역별 아이템의 개수
	static int[][] graph;
	
	/*
	 * 플로이드 워셜
	 * */
	static void floyd() {
		for (int k = 1; k < N + 1; k++) {
			for (int a = 1; a < N + 1; a++) {
				for (int b = 1; b < N + 1; b++) {
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
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		items = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) items[i] = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(graph[i], MAX);
			graph[i][i] = 0;
		}
		
		int a, b, l;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			graph[a][b] = l;
			graph[b][a] = l;
		}
		
		floyd();
		
		int maxItems = 0; // 얻을 수 있는 아이템의 개수
		for (int i = 1; i < N + 1; i++) {
			int tmp = 0;
			for (int j = 1; j < N + 1; j++) {
				if (graph[i][j] <= M) { // 수색 범위 이내의 아이템만 획득 가능
					tmp += items[j];
				}
			}
			maxItems = Math.max(maxItems, tmp);
		}
		
		System.out.println(maxItems);
	}
}