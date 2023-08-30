// 최소 편집 (15483번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String A = br.readLine();
		String B = br.readLine();
		
		int n = A.length();
		int m = B.length();
		
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i < n + 1; i++) {
			dp[i][0] = i;
			for (int j = 1; j < m + 1; j++) {
				dp[0][j] = j;
				char c1 = A.charAt(i - 1);
				char c2 = B.charAt(j - 1);
				if (c1 == c2) { // lcs를 갱신해야 함
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}
		bw.write(dp[n][m] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}