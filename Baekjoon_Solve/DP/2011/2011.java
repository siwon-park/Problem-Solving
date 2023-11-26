// 암호코드 (2011번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int MOD = 1_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String sCode = "0" + br.readLine();
		int N = sCode.length();
		int[] dp = new int[N];
		dp[0] = 1;
		if (sCode.charAt(1) - '0' > 0) dp[1] = 1;
		
		for (int i = 2; i < N; i++) {
			if (sCode.charAt(i) - '0' > 0) {
				dp[i] += dp[i - 1] % MOD;
			}
			if (sCode.charAt(i - 1) - '0' > 0) {
				int num = (sCode.charAt(i - 1) - '0') * 10 + (sCode.charAt(i) - '0');
				if (num <= 26) {
					dp[i] += dp[i - 2] % MOD;
				}				
			}
			dp[i] %= MOD;
		} 

		bw.write(dp[N - 1] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}