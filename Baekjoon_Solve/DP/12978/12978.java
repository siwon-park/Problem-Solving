// 스크루지 민호 2 (12978번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N;
	static ArrayList<Integer>[] graph;
	static int[][] dp;
	static boolean[] visited;
	
	static void dfs(int cur) {
		visited[cur] = true;
		
		dp[cur][0] = 0; // 현재 도시에 경찰서를 세우지 않음
		dp[cur][1] = 1; // 현재 도시에 경찰서를 세움
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i);
			if (!visited[nxt]) {
				dfs(nxt);
				// 현재 도시에 세우지 않았으니 다음 도시에는 반드시 세워야 함 -> 안 그러면 둘 사이에 있는 도로를 감시 못함
				dp[cur][0] += dp[nxt][1];
				// 현재 도시에 세웠으니 다음 도시는 세운 경우와 세우지 않은 경우의 최솟값을 택
				dp[cur][1] += Math.min(dp[nxt][0], dp[nxt][1]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		dp = new int[N + 1][2];
		visited = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
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