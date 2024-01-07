// 가장 긴 증가하는 부분 수열 3 (12738번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr, lis;
	
	static int lowerBound(int[] _arr, int l, int target) {
		int s = 0;
		int e = l - 1;
		int idx = l;
		while (s <= e) {
			int mid = (s + e) >> 1;
			if (_arr[mid] >= target) {
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
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		lis = new int[N];
		
		lis[0] = arr[0];
		int len = 1; // 가장 긴 증가하는 부분 수열의 길이
		
		for (int i = 1; i < N; i++) {
			int cur = arr[i];
			if (lis[len - 1] < cur) {
				lis[len++] = cur;
			} else {
				int idx = lowerBound(lis, len, cur);
				lis[idx] = cur;
			}
		}
		
		bw.write(len + "");
		bw.flush();
		bw.close();
		br.close();
	}
}