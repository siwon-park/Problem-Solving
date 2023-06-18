// 걷다보니 신천역 삼 (Large) (14651번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MOD = 1_000_000_009;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][3];
		
		dp[1][0] = 0;
		dp[1][1] = 1;
		dp[1][2] = 1;
		for (int i = 2; i < N + 1; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
		}
		
		System.out.println(dp[N][0]);
	}
}