// 수강 과목 (17845번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] dp = new int[N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()); // 중요도
			int t = Integer.parseInt(st.nextToken()); // 시간
			for (int j = N; j >= t; j--) { // 수강 과목을 1개씩 고르기 위해 역순 순회
				dp[j] = Math.max(dp[j], dp[j - t] + l);
			}
		}
		
		System.out.println(dp[N]);
	}
}
