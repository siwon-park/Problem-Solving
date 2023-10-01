// 이미지 보정 작업 (27068번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};	
	static int N, M, K;
	static long X, ans;
	static long[][] arr;
	static long[][] images = new long[500][500];
	
	static void binarySearch() {
		long s = 0;
		long e = X;
		while (s <= e) {
			long mid = (s + e) >> 1;
			boolean flag = bfs(mid);
			if (flag) {
				e = mid - 1;
				ans = mid;
			} else {
				s = mid + 1;
			}
		}
	}
	
	static boolean bfs(long limit) {
		// images 배열 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				images[i][j] = arr[i][j];
			}
		}
		
		int kCnt = 0; // 보정 횟수
		while (true) {
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (i < N - 1) {
						if (Math.abs(images[i][j] - images[i + 1][j]) > limit) {
							kCnt += 1;
							if (images[i][j] > images[i + 1][j]) images[i + 1][j] = X;
							else images[i][j] = X;
							flag = true;
						}
					}
					if (j < M - 1) {
						if (Math.abs(images[i][j] - images[i][j + 1]) > limit) {
							kCnt += 1;
							if (images[i][j] > images[i][j + 1]) images[i][j + 1] = X;
							else images[i][j] = X;
							flag = true;
						}
					}
				}
			}
			if (!flag) break;
		}
		return kCnt <= K;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		
		arr = new long[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		ans = X;
		binarySearch();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
