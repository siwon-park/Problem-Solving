// 퇴사 2 (15486번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, curMax;
	static int[] dp;
	static int[][] arr;

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		arr = new int[N + 1][2];
		
		int t, p;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			arr[i][0] = t;
			arr[i][1] = p;
		}
		
		curMax = 0;
		for (int i = N; i >= 1; i--) {
			t = arr[i][0];
			p = arr[i][1];
			if (i - 1 + t <= N) {
				dp[i - 1] = Math.max(dp[i - 1 + t] + p, curMax);
				curMax = dp[i - 1];
			} else dp[i - 1] = curMax;
		}
		
		System.out.println(dp[0]);
 	}
}