// 함께 블록 쌓기 (18427번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MOD = 10007;
	static int N, M, H;
	static int[][] arr = new int[51][11];
	static int[][] dp = new int[51][1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 1;
			while (st.hasMoreTokens()) {
				arr[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N + 1; i++) {
			dp[i][0] = 1; // 높이 0을 만들 수 있는 경우는 1
		}
		
		for (int i = 1; i < N + 1; i++) {
			for (int k = 1; k < H + 1; k++) {
				for (int j = 1; j < M + 1; j++) {
					if (arr[i][j] == 0) break;
					// i번째 학생의 블럭을 선택하는 경우
					dp[i][k] += (k >= arr[i][j]) ? dp[i - 1][k - arr[i][j]] : 0;
					dp[i][k] %= MOD;
				}
				dp[i][k] += dp[i - 1][k]; // i를 선택하지 않는 경우
				dp[i][k] %= MOD;
			}
		}
		
		bw.write(dp[N][H] + "");
		bw.flush();
		bw.close();
		br.close();
		
	} 
}
