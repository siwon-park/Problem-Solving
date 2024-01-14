// RGB트리 (27501번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final String[] RGB = new String[] {"R", "G", "B"};
	static int N;
	static boolean[] visited;
	static int[][] dp, arr;
	static ArrayList<Integer>[] graph;
	static String[] colors;
	
	
	static void init(int n) {
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
		visited = new boolean[N + 1];
		dp = new int[N + 1][3];
		arr = new int[N + 1][3];
		colors = new String[N + 1];
	}
	
	
	static void dfs(int cur) {
		visited[cur] = true;
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i);
			if (!visited[nxt]) {
				dfs(nxt);
				dp[cur][0] += Math.max(dp[nxt][1], dp[nxt][2]); // 빨간색인 경우
				dp[cur][1] += Math.max(dp[nxt][0], dp[nxt][2]); // 초록색인 경우
				dp[cur][2] += Math.max(dp[nxt][0], dp[nxt][1]); // 파란색인 경우				
			}
		}
		
		dp[cur][0] += arr[cur][0];
		dp[cur][1] += arr[cur][1];
		dp[cur][2] += arr[cur][2];		
	}
	
	
	static void findColorPath(int cur, int color) {
		visited[cur] = true;
		if (color == 0) { // 1과 2선택 가능
			int nxtC = (dp[cur][1] > dp[cur][2]) ? 1 : 2;
			colors[cur] = RGB[nxtC];
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i);
				if (!visited[nxt]) {
					findColorPath(nxt, nxtC);
				}
			}
		} else if (color == 1) { // 0과 2선택 가능
			int nxtC = (dp[cur][0] > dp[cur][2]) ? 0 : 2;
			colors[cur] = RGB[nxtC];
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i);
				if (!visited[nxt]) {
					findColorPath(nxt, nxtC);
				}
			}
		} else if (color == 2) { // 0과 1선택 가능
			int nxtC = (dp[cur][0] > dp[cur][1]) ? 0 : 1;
			colors[cur] = RGB[nxtC];
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i);
				if (!visited[nxt]) {
					findColorPath(nxt, nxtC);
				}
			}
		} else {
			int max = -1;
			int c = 0;
			for (int i = 0; i < 3; i++) {
				if (dp[cur][i] > max) { //  - arr[cur][i]
					max = dp[cur][i]; // - arr[cur][i];
					c = i;
				}
			}
			
			colors[cur] = RGB[c];
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i);
				if (!visited[nxt]) {
					findColorPath(nxt, c);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		init(N);
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[p].add(c);
			graph[c].add(p);
		}
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1);
		bw.write(Math.max(Math.max(dp[1][0], dp[1][1]), dp[1][2]) + "\n");
		visited = new boolean[N + 1];
		findColorPath(1, -1);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) sb.append(colors[i]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	} 
}