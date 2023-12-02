// 창영이와 커피 (22115번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N, K;
	static int[] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		dp = new int[N + 1][100_001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i + 1], MAX);
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (K == 0) {
			bw.write("0");
		} else {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					dp[i][arr[j - 1]] = 1;
				}
			}
			
			Arrays.fill(dp[0], MAX);
			dp[0][0] = 0;
			for (int i = 1; i < N + 1; i++) {
				int c = arr[i - 1];
				for (int j = 1; j < K + 1; j++) {
					if (j - c >= 0 && dp[i - 1][j - c] != MAX) {
						dp[i][j] = Math.min(dp[i - 1][j - c] + 1, dp[i - 1][j]); 
					} else {
						dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
					}
				}
			}
			
			int ans = dp[N][K] == MAX ? -1 : dp[N][K];
			bw.write(ans + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}