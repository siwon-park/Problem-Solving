// 육각수 (1229번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/*
		* 총 707개의 100만 이하의 육각수가 존재
		* 최소 개수는 항상 6이하
		*/ 
		
		int[] a = new int[709];
		int[] dp = new int[1_000_001];
		Arrays.fill(dp, 6);
		for (int i = 1; i < 709; i++) {
			a[i] = a[i - 1] + 4 * i - 3;
			dp[a[i - 1]] = 1; // 육각수는 1
		}
		
		dp[0] = 0; // 위 반복문에서 dp[0] = 1이라고 했으므로 0을 초기화
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < 709; j++) {
				if (i - a[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - a[j]] + 1);					
				} else {
					break;
				}
			}
		}
		
		System.out.println(dp[N]);
	}
}
