// 짱해커 이동식 (25603번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static int[] arr;
	
	static int binarySearch(int min, int max) {
		int ans = max;
		int s = min;
		int e = max;
		while (s <= e) {
			int mid = (s + e) >> 1; // 최댓값의 최솟값
			int lastIdx = 0;
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				 /*
				  * 현재 인덱스에서 마지막 선택한 숫자의 인덱스 차이가 K보다 크면 mid로는 불가
				  * 또는 arr[i] > mid 인 상태에서 두 인덱스 차이가 K이면 불가
				  * */
				if (i - lastIdx > K || (arr[i] > mid && i - lastIdx >= K)) {
					flag = false;
					break;
				}
				if (arr[i] <= mid) { // arr[i]가 mid 이하면 선택
					lastIdx = i;
				}
			}
			
			if (flag) { // 선택 가능하면 최댓값의 최소를 줄여봄
				e = mid - 1;
				ans = mid;
			} else { // mid값으론 선택 불가능하니 mid를 증가시킴
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
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int _min = Integer.MAX_VALUE;
		int _max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			_min = Math.min(_min, arr[i]);
			_max = Math.max(_max, arr[i]);
		}
		
		int ans = binarySearch(_min, _max);
		System.out.println(ans);
	}
}