// 양갈래 구하기 (31477번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N;
	static int[] dp; // i번째 노드까지 왔을 때의 최소 자른 비용
	static boolean[] visited;
	static ArrayList<int[]>[] graph;
	
	static void dfs(int cur) {
		visited[cur] = true;
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i)[0];
			int v = graph[cur].get(i)[1];
			if (!visited[nxt]) {
				dfs(nxt);
				dp[cur] += Math.min(dp[nxt], v);
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
		dp = new int[N + 1];
		for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());			
			graph[A].add(new int[] {B, V});
			graph[B].add(new int[] {A, V});
		}
		
		for (int i = 2; i < N + 1; i++) { // 리프 노드는 무조건 잘라야 하므로 MAX로 설정
			if (graph[i].size() == 1) dp[i] = MAX;
		}
		
		dfs(1);
		
		bw.write(dp[1] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
