// Maximal Area (11861번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		SegmentTree segTree = new SegmentTree(N, arr);
		segTree.init(1, N, 1);
		long ans = segTree.maxArea(1, N, N);
		System.out.println(ans + "");
		
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
			tree[n] = s; // 최솟값의 위치를 기록
			return;
		}
		int mid = (s + e) >> 1;
		init(s, mid, n * 2);
		init(mid + 1, e, n * 2 + 1);
		int left = tree[n * 2];
		int right = tree[n * 2 + 1];
		tree[n] = (arr[left] <= arr[right]) ? left : right;
	}
	
	int findIdx(int s, int e, int n, int l, int r) {
		if (r < s || e < l) return -1;
		if (l <= s && e <= r) return tree[n];
		int mid = (s + e) >> 1;
		int left = findIdx(s, mid, n * 2, l, r);
		int right = findIdx(mid + 1, e, n * 2 + 1, l, r);
		if (left == -1) return right;
		if (right == -1) return left;
		return (arr[left] <= arr[right]) ? left : right;
	}
	
	long maxArea(int l, int r, int n) {
		int idx = findIdx(1, n, 1, l, r);
		long area = (long) arr[idx] * (r - l + 1);
		if (idx - 1 >= l) {
			area = Math.max(area, maxArea(l, idx - 1, n));
		}
		if (idx + 1 <= r) {
			area = Math.max(area, maxArea(idx + 1, r, n));
		}
		return area;
	}
}
