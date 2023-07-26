// 나락도 락이다 (26156번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MOD = 1_000_000_007;
	static int N;
	static int[][] dp;

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		dp = new int[N + 1][5];
		dp[0][0] = 1; // 공집합
		for (int i = 1; i < N + 1; i++) {
			char c = S.charAt(i - 1);
			dp[i][0] = (dp[i - 1][0] * 2) % MOD;
			if (c == 'R') dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
			else dp[i][1] = dp[i - 1][1] % MOD;
			if (c == 'O') dp[i][2] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
			else dp[i][2] = dp[i - 1][2] % MOD;
			if (c == 'C') dp[i][3] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
			else dp[i][3] = dp[i - 1][3] % MOD;
			if (c == 'K') dp[i][4] = (dp[i - 1][3] + dp[i - 1][4]) % MOD;
			else dp[i][4] = dp[i - 1][4] % MOD;
		}
		
		int ret = dp[N][4];

		bw.write(ret + "\n");
		bw.flush();
		bw.close();
		br.close();
 	}
}