// 내리막 길 (1520번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] graph, memo;
	
	static int recur(int y, int x) {
		if (y == 1 && x == 1) {
			return memo[y][x];
		}
		if (memo[y][x] != -1) {
			return memo[y][x];
		}
		
		int cnt = 0;
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (ny <= 0 || ny > N || nx <= 0 || nx > M) continue;
			if (graph[y][x] < graph[ny][nx]) {
				cnt += recur(ny, nx);
			}
		}
		memo[y][x] = cnt;
		return memo[y][x];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		memo = new int[N + 1][M + 1];
		graph = new int[N + 1][M + 1];
		
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(memo[i], -1);
		}
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memo[1][1] = 1;
		recur(N, M);
		bw.write(memo[N][M] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}