// 마라탕 재료 고르기 (28447번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[][] C;
	static int ans = Integer.MIN_VALUE;
	
	static void backtracking(int cur, int cnt, int[] comb) {
		if (cnt == K) {
			// 조합의 최댓값 계산
			int tmp = 0;
			for (int i = 0; i < K; i++) {
				for (int j = i + 1; j < K; j++) {
					tmp += C[comb[i]][comb[j]];
				}
			}
			ans = Math.max(ans, tmp);
			return;
		}
		if (cur >= N) return;
		
		// 현재 재료를 고름
		comb[cnt] = cur;
		backtracking(cur + 1, cnt + 1, comb);
		comb[cnt] = -1;
		// 현재 재료를 고르지 않고 넘어감
		backtracking(cur + 1, cnt, comb);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		C = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				C[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] ret = new int[K];
		Arrays.fill(ret, -1);
		backtracking(0, 0, ret);
		
		System.out.println(ans);
	}
}
