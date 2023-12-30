// 인하니카 공화국 (12784번)
import java.io.*;
import java.util.*;

public class Main {

	static final int MAX = Integer.MAX_VALUE;
	static ArrayList<Pair>[] graph;
	static int[] dp;
	static boolean[] visited;
	
	static void init(int n) {
		graph = new ArrayList[n + 1];
		dp = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
	}
	
	static void dfs(int cur) {
		visited[cur] = true;
		for (int i = 0; i < graph[cur].size(); i++) {
			Pair pair = graph[cur].get(i);
			int nxt = pair.node;
			if (!visited[nxt]) {
				dfs(nxt);
				dp[cur] += Math.min(pair.d, dp[nxt]);			
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			init(N);
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				graph[u].add(new Pair(v, d));
				graph[v].add(new Pair(u, d));
			}
			
			// 리프 노드일 경우 다리의 수는 1개이기 때문에 MAX로 초기화. 단, 1번 노드는 제외
			for (int i = 2; i < N + 1; i++) {
				if (graph[i].size() == 1) {
					dp[i] = MAX;
				}
			}
			
			dfs(1);
			bw.write(dp[1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int node, d;
	Pair() {}
	Pair(int node, int d) {
		this.node = node;
		this.d = d;
	}
}