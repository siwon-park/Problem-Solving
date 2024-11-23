// 게으른 아리를 위한 접종 계획 (16169번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static ArrayList<int[]>[] graph;
	static int[] indegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			indegree[e] += 1;
			graph[s].add(new int[] {e, w});
		}
		
		Queue<int[]> queue = new LinkedList<>();
		int[] dp = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				queue.add(new int[] {i, 1});
				dp[i] = 1;
			}
		}
		
		int ans = 0;
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int cur = pair[0];
			int curT = pair[1];
			ans = Math.max(ans, dp[cur]);
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i)[0];
				int w = graph[cur].get(i)[1]; // 대기 시간
				indegree[nxt] -= 1;
				if (w >= 7) { // 대기 시간이 7일 이상이면 재접종을 해야함
					w += 1; // curT + w일에 재접종하고 다음날 맞아야 하므로 + 1
				}
				dp[nxt] = Math.max(dp[nxt], curT + w);					
				if (indegree[nxt] == 0) {
					queue.add(new int[] {nxt, dp[nxt]});
				}
			}
		}
		
		System.out.println(ans);
	}
}
