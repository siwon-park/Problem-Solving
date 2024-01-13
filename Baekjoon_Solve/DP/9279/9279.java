// 얼어붙은 스프링쿨러 (9279번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 1001;
	static int N, C;
	static boolean[] visited = new boolean[1001];
	static int[][] graph = new int[1001][1001];
	
	static void init(int n) {
		for (int i = 0; i < n + 1; i++) {
			visited[i] = false;
			Arrays.fill(graph[i], 0);
		}
	}
	
	static int dfs(int cur) {
		visited[cur] = true;
		boolean isSpring = true;
		int ret = 0;
		for (int i = 0; i < N + 1; i++) {
			if (!visited[i] && graph[cur][i] != 0) {
				isSpring = false;
				ret += Math.min(graph[cur][i], dfs(i));
			}
		}
		if (isSpring) {
			return MAX;
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String line = "";
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			init(N);
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				graph[u][v] = w;
				graph[v][u] = w;
			}
			int ans = dfs(C);
			bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	} 
}