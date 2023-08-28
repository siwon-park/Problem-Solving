// 다이나믹이 뭐예요? (14494번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n + 1][m + 1];
		dp[0][0] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				dp[i][j] += dp[i - 1][j] % MOD;
				dp[i][j] %= MOD;
				dp[i][j] += dp[i][j - 1] % MOD;
				dp[i][j] %= MOD;
				dp[i][j] += dp[i - 1][j - 1] % MOD;
				dp[i][j] %= MOD;
			}
		}
		
		bw.write(dp[n][m] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}