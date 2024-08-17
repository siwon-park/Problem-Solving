// 중앙값 (1572번)
import java.util.*;
import java.io.*;

public class Main {

	static final int MAX = 65536;
	static int N, K;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// tree[1] = 0을 넣기 위해 MAX + 1 크기로 선언한다. 입력 값이 0 이상이기 때문.
		FenwickTree fenwick = new FenwickTree(MAX + 1);
		
		// 최초 K개의 부분 수열의 각 값에 해당하는 인덱스에 대해 1씩 업데이트
		for (int i = 1; i < K + 1; i++) {
			fenwick.update(arr[i] + 1, 1);
		}
		
		long ans = fenwick.getMedian(K); // 최초 K개의 부분 수열의 중앙값
		/*
		 * 두번째 K개의 구간에 대한 중앙값을 계산해야 하기 때문에 앞의 값에 해당하는 인덱스에서 -1을 빼고
		 * 끝에 새로운 값을 1개 값을 추가함
		 * */
		for (int i = 1; i < N - K + 1; i++) {
			fenwick.update(arr[i] + 1, -1);
			fenwick.update(arr[i + K] + 1, 1);
			ans += fenwick.getMedian(K);
		}
		
		System.out.println(ans);
	}
}


class FenwickTree {
	int[] tree;
	int size; // 65564
	
	FenwickTree(int n) {
		this.tree = new int[n + 1];
		this.size = n;
	}
	
	void update(int i, int v) {
		while (i <= size) {
			tree[i] += v;
			i += (i & -i);
		}
	}
	
	int sum(int i) {
		int ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
	
	int getMedian(int k) {
		int m = (k + 1) / 2; // 구간의 크기 / 2
		int s = 0;
		int e = size - 1; // 65563
		int median = 1;
		while (s <= e) {
			int mid = (s + e) >> 1;
			int cnt = sum(mid + 1); // 중간까지 숫자들의 빈도수
			if (cnt >= m) {
				e = mid - 1;
				median = mid;
			} else {
				s = mid + 1;
			}
		}
		return median;
	}
}
