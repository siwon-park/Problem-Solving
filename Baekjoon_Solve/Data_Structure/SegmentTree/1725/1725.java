// 히스토그램 (1725번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr;
	
	static class SegmentTree {
		int[] tree;
		
		SegmentTree(int n) {
			this.tree = new int[n * 4];
		}
		
		void init(int s, int e, int n) {
			if (s == e) {
				tree[n] = s;
				return;
			}
			int mid = (s + e) >> 1;
			init(s, mid, n * 2);
			init(mid + 1, e, n * 2 + 1);
			int left = tree[n * 2];
			int right = tree[n * 2 + 1];
			if (arr[left] <= arr[right]) tree[n] = left;
			else tree[n] = right;
		}
		
		int findMinIdx(int s, int e, int n, int l, int r) {
			if (r < s || e < l) return -1;
			else if (l <= s && e <= r) return tree[n];
			int mid = (s + e) >> 1;
			int left = findMinIdx(s, mid, n * 2, l, r);
			int right = findMinIdx(mid + 1, e, n * 2 + 1, l, r);
			if (left == -1) return right;
			if (right == -1) return left;
			return (arr[left] <= arr[right]) ? left : right;
		}
		
		long getMaxWidth(int l, int r) {
			int idx = findMinIdx(1, N, 1, l, r);
			long maxWidth = (long) (r - l + 1) * arr[idx];
			if (l <= idx - 1) maxWidth = Math.max(maxWidth, getMaxWidth(l, idx - 1));
			if (r >= idx + 1) maxWidth = Math.max(maxWidth, getMaxWidth(idx + 1, r));
			return maxWidth;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(br.readLine());
		
		SegmentTree segTree = new SegmentTree(N);
		segTree.init(1, N, 1);
		
		long ans = segTree.getMaxWidth(1, N);
		System.out.println(ans);
	}
}

