// 외판원 순회 (2098번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N, MAX; // 도시의 수
	static int[][] graph, memo;
	
	static int backtrack(int bit, int s) {
		if (memo[s][bit] != 0) {
			return memo[s][bit];
		}
		
		if (bit == MAX) {
			if (graph[s][0] == INF) return INF; // 순회 불가능함
			return graph[s][0];
		}
		
		int cost = INF;
		for (int i = 0; i < N; i++) {
			if ((bit & (1 << i)) != 0) continue;
			if (graph[s][i] == INF) continue;
			int tmp = backtrack(bit | (1 << i), i);
			if (tmp == INF) continue;
			cost = Math.min(cost, tmp + graph[s][i]);
		}
		memo[s][bit] = cost;
		return memo[s][bit];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		MAX = (1 << N) - 1;
		memo = new int[N][MAX + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 0 && i != j) graph[i][j] = INF;
			}
		}

		System.out.println(backtrack(0, 0));
	}	
}