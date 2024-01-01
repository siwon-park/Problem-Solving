// 우수 마을 (1949번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N;
	static int[] arr;
	static int[][] dp;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	
	static void dfs(int cur) {
		visited[cur] = true;
		dp[cur][0] = 0; // 현재 마을이 우수 마을로 선정되지 않은 경우의 최댓값
		dp[cur][1] = arr[cur]; // 현재 마을이 우수 마을로 선정된 경우의 최댓값
		int cnt = 0;
		int _min = MAX;
		int minNxt = 0;
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i);
			if (!visited[nxt]) {
				dfs(nxt);
				dp[cur][1] += dp[nxt][0];
				dp[cur][0] += Math.max(dp[nxt][0], dp[nxt][1]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1][2];
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		graph[0] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		dfs(1);
		bw.write(Math.max(dp[1][0], dp[1][1]) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}