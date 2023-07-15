// A[j]-A[i]+A[l]-A[k] 15487번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MIN = Integer.MIN_VALUE;
	static int N;
	static int[] A, RA;
	static int[][] dp, rdp;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		RA = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			RA[N - i - 1] = A[i];
		}
		
		dp = new int[N][2];
		rdp = new int[N][2];
		
		dp[0][0] = A[0];
		dp[0][1] = MIN;
		rdp[0][0] = RA[0];
		rdp[0][1] = MIN;
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][0], A[i]);
			dp[i][1] = Math.max(dp[i - 1][1], A[i] - dp[i - 1][0]);
			rdp[i][0] = Math.max(rdp[i - 1][0], RA[i]);
			rdp[i][1] = Math.max(rdp[i - 1][1], rdp[i - 1][0] - RA[i]);
		}
		
		int ans = MIN; // 최솟값
		for (int i = 1; i < N - 2; i++) {
			ans = Math.max(ans, dp[i][1] + rdp[N - i - 2][1]);
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
