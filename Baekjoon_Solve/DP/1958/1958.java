// LCS 3 (1958번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int[][][] dp = new int[101][101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();
		
		int N = s1.length();
		int M = s2.length();
		int L = s3.length();
		
		int lcs = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				for (int k = 1; k < L + 1; k++) {
					char c1 = s1.charAt(i - 1);
					char c2 = s2.charAt(j - 1);
					char c3 = s3.charAt(k - 1);
					if (c1 == c2 && c1 == c3) { // 세 문자열이 모두 같으면
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						// dp[i - 1][j - 1][k - 1]을 제외한 가장 큰 값을 찾음
						int v1 = dp[i - 1][j - 1][k];
						int v2 = dp[i - 1][j][k];
						int v3 = dp[i - 1][j][k - 1];
						int v4 = dp[i][j - 1][k];
						int v5 = dp[i][j - 1][k - 1];
						int v6 = dp[i][j][k - 1];
						dp[i][j][k] = Math.max(v1, Math.max(v2, Math.max(v3, Math.max(v4, Math.max(v5, v6)))));
					}
					lcs = Math.max(lcs, dp[i][j][k]);
				}
			}
		}

		bw.write(lcs + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
