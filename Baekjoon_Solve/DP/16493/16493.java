// 최대 페이지 수 (16493번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] dp;
	static Pair[] pairs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pairs = new Pair[M + 1];
		int d, p;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			pairs[i + 1] = new Pair(d, p);
		}
		
		dp = new int[M + 1][N + 1];
		for (int i = 1; i < M + 1; i++) {
			Pair pair = pairs[i];
			for (int j = 1; j < N + 1; j++) {
				// i번 챕터까지 j일 동안 읽었을 때의 최댓값 
				dp[i][j] = (j >= pair.d) ? Math.max(dp[i - 1][j], dp[i - 1][j - pair.d] + pair.p) : dp[i - 1][j];
			}
		}
		
		bw.write(dp[M][N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair {
	int d;
	int p;
	Pair(){}
	Pair(int d, int p) {
		this.d = d;
		this.p = p;
	}
}