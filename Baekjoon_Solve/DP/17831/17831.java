// 대기업 승범이네 (17831번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr;
	static boolean[] visited;
	static long[][] dp;
	static ArrayList<Integer>[] graph;
	
	static void dfs(int cur) {
		visited[cur] = true;
		
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i);
			if (!visited[nxt]) {
				dfs(nxt);
				dp[cur][0] += Math.max(dp[nxt][0], dp[nxt][1]); // cur이 멘티가 아닌 경우
				dp[cur][1] += dp[nxt][1]; // cur이 멘티인 경우
			}
		}
		
		long sum = dp[cur][1];
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i);
			dp[cur][1] = Math.max(dp[cur][1], sum + arr[cur] * arr[nxt] - dp[nxt][1] + dp[nxt][0]);
		}
		
	}
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		dp = new long[N + 1][2];
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 2; i < N + 1; i++) {
			int p = Integer.parseInt(st.nextToken());
			graph[p].add(i);
//			graph[i].add(p);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
 		
		dfs(1);
		bw.write(Math.max(dp[1][0], dp[1][1]) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}