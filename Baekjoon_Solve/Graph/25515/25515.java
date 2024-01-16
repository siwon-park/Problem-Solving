//트리 노드 합의 최댓값 (25515번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] arr;
	static long[] dp;
	
	static void dfs(int cur) {
		dp[cur] = arr[cur];
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i);
			dfs(nxt);
			if (dp[nxt] > 0) dp[cur] += dp[nxt];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new long[N];
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[p].add(c); // 부모 -> 자식만 연결
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		System.out.println(dp[0] + "");
	} 
}