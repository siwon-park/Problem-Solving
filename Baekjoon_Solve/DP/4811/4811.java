// 알약 (4811번)
import java.io.*;
import java.util.*;

public class Main {
	
	static long[][] dp = new long[31][31]; // dp[w][h]; 'W'가 w개, 'H'가 h개
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 1; i < 31; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < 31; j++) {
				if (i < j) continue; // 항상 w >= h임
				dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
			}
		}
		
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			bw.write(dp[N][N] + "\n");			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}