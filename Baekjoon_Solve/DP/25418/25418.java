// 정수 a를 k로 만들기 (25418번)
import java.io.*;
import java.util.*;

public class Main {

	static final int MAX = 1_000_055;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[K + 1];
		Arrays.fill(dp, MAX);
		
		dp[A] = 0; // A를 만들기 위해 필요한 연산의 수
		for (int i = A + 1; i <= K; i++) {
			dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
		}
		
		bw.write(dp[K] + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}