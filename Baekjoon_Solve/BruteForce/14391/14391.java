// 종이 조각 (14391번)
import java.io.*;
import java.util.*;

public class Main {

	static void backtrack(int k) {
		if (k == N) {
			int ret = 0;
			// 행에 대해 연산
			for (int r = 0; r < N; r++) {
				int tmp = 0;
				for (int c = M - 1; c >= 0; c--) {
					if ((arr[r] & (1 << c)) != 0) { // 비트 연산 결과가 1이면
						tmp = tmp * 10 + orgArr[r][M - 1 -c];
					} else {
						ret += tmp;
						tmp = 0;
					}
				}
				if (tmp > 0) ret += tmp;
			}
			// 열에 대해 연산
			for (int c = 0; c < M; c++) {
				int tmp2 = 0;
				for (int r = 0; r < N; r++) {
					if ((arr[r] & (1 << c)) == 0) { // 비트 연산 결과가 0이면
						tmp2 = tmp2 * 10 + orgArr[r][M - 1 - c];
					} else {
						ret += tmp2;
						tmp2 = 0;
					}
				}
				if (tmp2 > 0) ret += tmp2;
			}
			MAX = Math.max(MAX, ret);
			return;
		}
		for (int i = 0; i < MAX_COL; i++) {
			arr[k] = i;
			backtrack(k + 1);
			arr[k] = 0;
		}
	}
	
	static int MAX_COL;
	static int N, M, MAX; // 행, 열, 최댓값
	static int[] arr; // 배열
	static int[][] orgArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MAX = 0;
		MAX_COL = (1 << M);
		
		arr = new int[N];
		orgArr = new int[N][M];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			for (int j = M - 1; j >= 0; j--) {
				orgArr[i][j] = num % 10;
				num /= 10;
			}
		}
		
		backtrack(0);
		
		System.out.println(MAX);
	}
}