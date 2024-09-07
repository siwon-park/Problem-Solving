// 인문예술탐사주간 (23829번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q;
	static int[] P;
	static long[] prefixP;
	
	static int lowerBound(int[] arr, int target) {
		int s = 1;
		int e = N;
		int ans = e + 1;
		while (s <= e) {
			int mid = (s + e) >> 1;
			if (arr[mid] >= target) {
				e = mid - 1;
				ans = mid;
			} else {
				s = mid + 1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		P = new int[N + 1];
		prefixP = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(P);
		for (int i = 1; i < N + 1; i++) {
			prefixP[i] = prefixP[i - 1] + P[i];
		}
		
		for (int i = 0; i < Q; i++) {
			int x = Integer.parseInt(br.readLine());
			int idx = lowerBound(P, x) - 1;
			long ans = (long) x * idx - prefixP[idx] + prefixP[N] - prefixP[idx] - (long) x * (N - idx);
			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

