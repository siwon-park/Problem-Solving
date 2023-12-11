// 직사각형으로 나누기 (1451번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		
		long total = 0; // 총합
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = line.charAt(j - 1) - '0';
				total += arr[i][j];
			}
		}
		
		// 2차원의 배열 누적 합 계산
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] += (arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1]); 
			}
		}
		
		long _max = 0;
		if (N >= 1) { // 행이 1인 경우
			for (int i = 1; i < M; i++) {
				for (int j = i + 1; j <= M; j++) {
					_max = Math.max(_max, arr[N][i] * (arr[N][j] - arr[N][i]) * (total - arr[N][j]));
				}
			}
		}
		if (M >= 1) { // 열이 1인 경우
			for (int i = 1; i < N; i++) {
				for (int j = i + 1; j <= N; j++) {
					_max = Math.max(_max, arr[i][M] * (arr[j][M] - arr[i][M]) * (total - arr[j][M]));
				}
			}
		} 
		if (N > 1 && M > 1) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					long ret1 = arr[i][j] * (arr[i][M] - arr[i][j]) * (total - arr[i][M]);
					long ret2 = arr[i][j] * (arr[N][j] - arr[i][j]) * (total - arr[N][j]);
					long ret3 = arr[N][j] * (arr[i][M] - arr[i][j]) * (total - arr[i][M] - arr[N][j] + arr[i][j]);
					long ret4 = arr[i][M] * (arr[N][j] - arr[i][j]) * (total - arr[N][j] - arr[i][M] + arr[i][j]);
					_max = Math.max(_max,  Math.max(ret1, Math.max(ret2, Math.max(ret3, ret4))));
				}
			}
		}

		bw.write(_max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}