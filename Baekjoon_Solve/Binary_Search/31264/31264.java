// 사격 (31264번)
import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static long A;
	static int[] arr;
	
	static int binarySearch() {
		int ans = 0;
		int s = arr[0];
		int e = arr[N - 1];
		while (s <= e) {
			int mid = (s + e) >> 1; // 사격 시작 점수
			long score = 0;
			int stat = mid;
			for (int i = 0; i < M; i++) {
				int idx = lowerBound(stat);
				if (arr[idx] <= stat) {
					stat += arr[idx];
					score += arr[idx];
				} else {
					idx = Math.max(idx - 1, 0);
					if (arr[idx] <= stat) {
						stat += arr[idx];
						score += arr[idx];
					}
				}
			}
			if (score >= A) {
				e = mid - 1;
				ans = mid;
			} else {
				s = mid + 1;
			}
		}
		
		return ans;
	}
	
	static int lowerBound(int v) {
		int idx = N - 1;
		int s = 0;
		int e = N - 1;
		while (s <= e) {
			int mid = (s + e) >> 1;
			if (arr[mid] >= v) {
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Long.parseLong(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int ans = binarySearch();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}