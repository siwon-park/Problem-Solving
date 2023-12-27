// 사회망 서비스(SNS) (2533번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] dp;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	
	static void dfs(int cur) {
		visited[cur] = true;
		/*
		 * 현재 노드가 새로운 아이디어를 받아들이려면 자신이 얼리어답터이거나 주변 모든 친구가 얼리어답터여야 한다.
		 * 자신이 얼리어답터인 경우 -> dp[cur][0], 주변 친구(자식)가 얼리어답터인 경우 -> dp[cur][1] 
		 * */
		int cur_size = graph[cur].size();
		dp[cur][0] = 1;
		dp[cur][1] = 0;
		for (int i = 0; i < cur_size; i++) {
			int nxt = graph[cur].get(i);
			if (!visited[nxt]) {
				dfs(nxt);
				dp[cur][1] += dp[nxt][0];
				dp[cur][0] += Math.min(dp[nxt][0], dp[nxt][1]);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;	
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		dp = new int[N + 1][2];
		for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		dfs(1);
		bw.write(Math.min(dp[1][0], dp[1][1]) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}