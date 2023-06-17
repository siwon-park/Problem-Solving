// 자두나무 (2240번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[T + 1];
		for (int i = 1; i < T + 1; i++) arr[i] = Integer.parseInt(br.readLine());
		
		int[][][] dp = new int[T + 1][W + 1][2]; // T초에 체력을 W만큼 사용해서 얻을 수 있는 자두의 개수
		
		for (int i = 1; i < T + 1; i++) {
			if (arr[i] == 1) {
				dp[i][0][0] = dp[i - 1][0][0] + 1;
				dp[i][0][1] = dp[i - 1][0][1];
				for (int j = 1; j < W + 1; j++) {
					dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1]) + 1; // 받으러 감
					dp[i][j][1] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j][1]); // 움직이지 않음
				}
			} else {
				dp[i][0][1] = dp[i - 1][0][1];
				for (int j = 1; j < W + 1; j++) {
					dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1]); // 움직이지 않음
					dp[i][j][1] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j][1]) + 1; // 받으러 감
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < W + 1; i++) ans = Math.max(dp[T][i][0], dp[T][i][1]);
		System.out.println(ans);
	}
}