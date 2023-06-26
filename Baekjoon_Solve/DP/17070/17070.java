// 파이프 옮기기 1 (17070번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][][] dp = new int[N][N][3]; // 가로, 세로, 대각선
		
		// 제일 초기에는 가로로 뉘여져 있음
		dp[0][1][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) continue; // 벽이면 불가능
				// 현재 가로로 올 수 있는 경우
				if (j - 1 >= 0) {
					dp[i][j][0] += dp[i][j - 1][0];
					dp[i][j][0] += dp[i][j - 1][2];
				}
				// 현재 세로로 올 수 있는 경우
				if (i - 1 >= 0) {
					dp[i][j][1] += dp[i - 1][j][1];
					dp[i][j][1] += dp[i - 1][j][2];
				}
				// 현재 대각선으로 올 수 있는 경우
				if (i - 1 >= 0 && j - 1 >= 0) {
					if (map[i - 1][j] != 1 && map[i][j - 1] != 1) {
						dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
					}
				}
			}
		}
		
		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
	}
}