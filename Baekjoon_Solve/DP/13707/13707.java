// 합분해 2 (13707번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MOD = 1_000_000_000;
	static int N, K;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[K + 1][N + 1];
		Arrays.fill(dp[1], 1); // 1개를 사용하여 0 ~ N을 만들 수 있는 경우의 수 -> 각각 1개
		
		for (int k = 2; k < K + 1; k++) {
			for (int n = 1; n < N + 1; n++) {
				dp[k][0] = 1;
				dp[k][n] = (dp[k - 1][n] + dp[k][n - 1]) % MOD;
			}
		}
	
		bw.write(dp[K][N] + "");
		bw.flush();
		bw.close();
		br.close();	
	}
}