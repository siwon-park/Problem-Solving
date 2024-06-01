// 무서운 아르바이트 (12846번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		SegmentTree segTree = new SegmentTree(N, arr);
		segTree.init(1, N, 1);
		long ans = segTree.getMax(1, N, N);
		System.out.println(ans);
	}
}


class SegmentTree {
	int[] tree;
	int[] arr;
	
	SegmentTree(int n, int[] arr) {
		this.tree = new int[n * 4];
		this.arr = arr;
	}
	
	void init(int s, int e, int n) {
		if (s == e) {
			tree[n] = s; // 인덱스 저장
			return;
		}
		int mid = (s + e) >> 1;
		init(s, mid, n * 2);
		init(mid + 1, e, n * 2 + 1);
		// 왼쪽 오른쪽 값을 비교한 다음에 인덱스를 저장함
		int left = tree[n * 2];
		int right = tree[n * 2 + 1];
		if (arr[left] <= arr[right]) {
			tree[n] = left;
		} else {
			tree[n] = right;
		}
	}
	
	// 구간의 최솟값의 인덱스를 반환함
	int findMin(int s, int e, int n, int l, int r) {
		if (r < s || e < l) return -1;
		else if (l <= s && e <= r) {
			return tree[n];
		}
		int mid = (s + e) >> 1;
		int leftIdx = findMin(s, mid, n * 2, l, r);
		int rightIdx = findMin(mid + 1, e, n * 2 + 1, l, r);
		// 둘 다 -1 경우는 존재하지 않음
		if (leftIdx == -1) return rightIdx;
		if (rightIdx == -1) return leftIdx;
		return (arr[leftIdx] <= arr[rightIdx]) ? leftIdx : rightIdx;
	}
	
	long getMax(int l, int r, int n) {
		int idx = findMin(1, n, 1, l, r);
		long maxValue = (long) (r - l + 1) * arr[idx]; // 구간의 최솟값 * 구간의 수
		// 분할정복해서 탐색
		if (l <= idx - 1) {
			maxValue = Math.max(maxValue, getMax(l, idx - 1, n));
		}
		if (r >= idx + 1) {
			maxValue = Math.max(maxValue, getMax(idx + 1, r, n));
		}
		return maxValue;
	}
}

