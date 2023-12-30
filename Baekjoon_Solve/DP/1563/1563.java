// 개근상 (1563번)
import java.io.*;
import java.util.*;

public class Main {

	static final int MOD = 1_000_000;
	static int N;
	static int[][][] dp = new int[1001][3][2]; // i일까지 A가 j회 연속으로 L이 k개 미만인 경우의 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		dp[1][0][0] = 1; // O
		dp[1][1][0] = 1; // A
		dp[1][0][1] = 1; // L

		for (int i = 2; i < N + 1; i++) {
			// 연속하니까 0연속인 경우는 이전에 j연속한 경우를 포함해야 함
			dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][2][0]) % MOD;
			dp[i][0][0] %= MOD;
			
			dp[i][0][1] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][1][0] + dp[i - 1][2][0] + dp[i - 1][1][1] + dp[i - 1][2][1]) % MOD;
			dp[i][0][1] %= MOD;
			
			dp[i][1][0] = dp[i - 1][0][0];
			dp[i][1][0] %= MOD;
			
			dp[i][1][1] = dp[i - 1][0][1] % MOD;
			dp[i][1][1] %= MOD;

			dp[i][2][0] = dp[i - 1][1][0];
			dp[i][2][0] %= MOD;
			
			dp[i][2][1] = dp[i - 1][1][1] % MOD;
			dp[i][2][1] %= MOD;
		}
		
		int ans = 0;
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 2; k++) {
				ans += dp[N][j][k];
				ans %= MOD;
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}