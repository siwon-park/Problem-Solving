// 트리 노드 합의 최댓값 (25690번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] graph;
	static int[][] arr;
	static long[][] dp;
	
	static void init() {
		dp = new long[N][2];
		arr = new int[N][2];
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
	}

	static void dfs(int cur) {
		dp[cur][0] = arr[cur][0]; // cur을 white로 칠하는 비용
		dp[cur][1] = arr[cur][1]; // cur을 black으로 칠하는 비용
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i);
			dfs(nxt);
			dp[cur][0] += Math.min(dp[nxt][0], dp[nxt][1]); // 현재 white로 칠했으니 다음은 white, black 중 작은 것 택1
			dp[cur][1] += dp[nxt][0]; // 현재 black으로 칠했으니 다음은 white
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		init();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[p].add(c);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // white
			arr[i][1] = Integer.parseInt(st.nextToken()); // black
		}

		dfs(0);
		bw.write(Math.min(dp[0][0], dp[0][1]) + "");
		bw.flush();
		bw.close();
		br.close();
	} 
}