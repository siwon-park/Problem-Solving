import java.io.*;
import java.util.*;

public class Main {
	
	// 플로이드 워셜 -> 각 노드 사이의 이동 거리를 구함
	static int[][] floyd(int[][] graph, int N) {
		for (int k = 1; k <= N; k++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					if (graph[a][k] == MAX || graph[b][k] == MAX) continue;
					int cost = graph[a][k] + graph[k][b];
					if (cost < graph[a][b]) graph[a][b] = cost;
				}
			}
		}
		return graph;
	}
	
	// 조합을 구하는 함수
	static void comb(int k, int s, int[] pair) {
		if (k == 2) {
			int[] newPair = new int[2];
			for (int j = 0; j < 2; j++) newPair[j] = pair[j];
			combinations.add(newPair);
			return;
		}
		
		for (int i = s; i <= N; i++) {
			pair[k] = i;
			comb(k + 1, i + 1, pair);
			pair[k] = 0;
		}
	}
	
	static int N, M;
	static final int MAX = Integer.MAX_VALUE;
	static ArrayList<int[]> combinations;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(graph[i], MAX);
			graph[i][i] = 0;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A][B] = 1;
			graph[B][A] = 1;
		}
		
		int[][] newGraph = floyd(graph, N);
		
		combinations = new ArrayList<>();
		comb(0, 1, new int[2]);
		
		int minCost = MAX;
		int[] ans = new int[2];
		for (int[] pair : combinations) {
			int a = pair[0];
			int b = pair[1];
			int cost = 0;
			for (int i = 1; i <= N; i++) {
				cost += Math.min(newGraph[a][i], newGraph[b][i]);
			}
			cost *= 2; // 왕복이니까 2배
			if (cost < minCost) {
				minCost = cost;
				ans[0] = a;
				ans[1] = b;
			}
		}
		
		System.out.println(ans[0] + " " + ans[1] + " " + minCost);
	}
}