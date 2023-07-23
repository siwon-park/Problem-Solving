// 합이 0인 네 정수 (7453번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] A, B, C, D, AB, CD, AC, BD, AD, BC;
	
	static int lowerBound(int[] arr, int target) {
		int s = 0;
		int e = arr.length - 1;
		int idx = e + 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] >= target) {
				e = mid - 1;
				idx = mid;
			} else {
				s = mid + 1;
			}
		}
		return idx;
	}
	
	static int upperBound(int[] arr, int target) {
		int s = 0;
		int e = arr.length - 1;
		int idx = e + 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] > target) {
				e = mid - 1;
				idx = mid;
			} else {
				s = mid + 1;
			}
		}
		
		return idx;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		
		int j = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[j] = Integer.parseInt(st.nextToken());
			B[j] = Integer.parseInt(st.nextToken());
			C[j] = Integer.parseInt(st.nextToken());
			D[j++] = Integer.parseInt(st.nextToken());
		}
		
		// 나올 수 있는 각 조합의 배열
		int MAX = N * N;
		AB = new int[MAX];
		CD = new int[MAX];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				AB[idx] = A[i] + B[j];
				CD[idx++] = C[i] + D[j];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		long ans = 0;
		int l_idx, r_idx;
		for (int i = 0; i < MAX; i++) {
			// AB x CD 조합
			l_idx = lowerBound(CD, -AB[i]);
			if (l_idx != MAX) {
				r_idx = upperBound(CD, -AB[i]);
				if (AB[i] + CD[l_idx] == 0) ans += r_idx - l_idx;
			}
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
 	}
}