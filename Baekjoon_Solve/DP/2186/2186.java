// 문자판 (2186번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, L;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][][] memo; // (r, c)에서 idx번째 문자열과 일치하는 경우의 수
	static String line;
	static String[] graph;
	
	static void init(int n, int m, int l) {
		memo = new int[n][m][l + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
	}
	
	static int recur(int r, int c, int idx) {
		if (idx <= L - 1 && graph[r].charAt(c) == line.charAt(idx) && memo[r][c][idx] != -1) {
			return memo[r][c][idx];
		}
		if (graph[r].charAt(c) != line.charAt(idx)) {
			return 0;
		}
		if (idx == L - 1) {
			memo[r][c][idx] = 1;
			return memo[r][c][idx];
		}
		int cnt = 0; // 경우의 수
		for (int k = 1; k <= K; k++) {
			for (int w = 0; w < 4; w++) {
				int nr = r + dy[w] * k;
				int nc = c + dx[w] * k;
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				cnt += recur(nr, nc, idx + 1);
			}
		}
		memo[r][c][idx] = cnt;
		return memo[r][c][idx];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new String[N];
		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine();
		}
		
		line = br.readLine();
		L = line.length(); // 문자열의 길이
		
		init(N, M, L);
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i].charAt(j) == line.charAt(0)) {
					ans += recur(i, j, 0);
				}
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}