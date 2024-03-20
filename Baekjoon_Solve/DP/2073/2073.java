// 수도배관공사 (2073번)
import java.io.*;
import java.util.*;

public class Main {

	static int D, P;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken()); // 거리
		P = Integer.parseInt(st.nextToken()); // 파이프의 수
		dp = new int[D + 1];
		dp[0] = Integer.MAX_VALUE;
		for (int i = 1; i < P + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int j = D; j >= l; j--) { // 거꾸로 순회해야 파이프를 한 번씩만 사용함
				dp[j] = Math.max(dp[j], Math.min(dp[j - l], c));
			}
		}
		
		System.out.println(dp[D]);
	}
}