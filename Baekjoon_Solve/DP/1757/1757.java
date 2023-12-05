// 달려달려 (1757번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N, M;
	static int[] arr;
	static int[][][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		dp = new int[N][M + 2][2]; // i분까지 체력 j를 사용해서 갈 수 있는 최대 거리, k: 0 - i분에 쉼, 1 - i분에 쉬지 않음
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i][1][1] = arr[i]; // i분에 1의 지침지수로 arr[i]만큼 뜀
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M + 1; j++) {
				// 지금 쉬는 경우
				if (j == 0) { // j = 0인 경우 연속적으로 체력 0에서 쉬는 경우까지 계산
					dp[i][j][0] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]));										
				} else {
					dp[i][j][0] = Math.max(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);	
				}
				
				// 지금 달리는 경우 -> 체력이 0에서 달리는 경우와 연속해서 달리는 경우
				if (j - 1 >= 0) {
					dp[i][j][1] = Math.max(dp[i][j][1], Math.max(dp[i - 1][0][0], dp[i - 1][j - 1][1]) + arr[i]);					
				}
			}
		}

		bw.write(dp[N - 1][0][0] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}