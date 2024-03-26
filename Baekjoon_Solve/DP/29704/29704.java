// 벼락치기 (29704번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N, T;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		Pair[] pairs = new Pair[N + 1];
		int[][] dp = new int[N + 1][T + 1];
		int day = 0;
		int total = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()); // 남은 기한
			int m = Integer.parseInt(st.nextToken()); // 벌금
			pairs[i] = new Pair(d, m);
			day += d;
			total += m;
		}
		
		for (int i = 1; i <= N; i++) {
			Pair pair = pairs[i];
			for (int j = 1; j <= T; j++) {
				if (j - pair.d >= 0) {
					// 기간 내 문제를 풀었을 때 부과 가능한 벌금의 최댓값을 구함
					dp[i][j] = Math.max(dp[i - 1][j - pair.d] + pair.m, dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		if (day == T) { // 기한 내에 모든 문제 해결 가능
			System.out.println(0);
		} else { // 전체에서 벌금의 최댓값을 뺀다. 어차피 total에는 범위를 벗어났을 때 부과되는 벌금도 포함되어 있다.
			System.out.println(total - dp[N][T]);			
		}
	}
}


class Pair {
	int d, m;
	Pair(int d, int m) {
		this.d = d;
		this.m = m;
	}
}