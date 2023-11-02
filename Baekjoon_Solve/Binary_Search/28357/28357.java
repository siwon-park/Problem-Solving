// 사탕 나눠주기 (28357번)
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static long K;
	static long[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long s = 0;
		long e = 1_000_000_000_000L;
		long ans = e;
		while (s <= e) {
			long mid = (s + e) >> 1; // 기준 점수
			long k = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] - mid > 0) {
					k += (arr[i] - mid);
				}
			}
			if (k <= K) { // 준 사탕의 개수가 K보다 작으면 최대한 많은 사탕을 나눠주기 위해
				e = mid - 1; // 기준 점수를 줄여서 사탕의 수를 조금 더 늘림
				ans = mid;
			} else {
				s = mid + 1;
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}