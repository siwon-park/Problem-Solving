// 히스토그램에서 가장 큰 직사각형 (6549번)
import java.io.*;
import java.util.*;

public class Main {

	static int MAX = 100_555;
	static int[] arr = new int[MAX];
	static int[] tree = new int[MAX * 4];
	
	static class SegmentTree {
		
		SegmentTree() {
			Arrays.fill(arr, 0);
			Arrays.fill(tree, 0);
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
		
		int findIdx(int s, int e, int n, int l, int r) {
			if (r < s || e < l) return -1;
			else if (l <= s && e <= r) return tree[n];
			int mid = (s + e) >> 1;
			int left = findIdx(s, mid, n * 2, l, r);
			int right = findIdx(mid + 1, e, n * 2 + 1, l, r);
			if (left == -1) return right;
			if (right == -1) return left;
			return (arr[left] <= arr[right]) ? left: right;
		}
		
		long getWidth(int l, int r, int n) {
			int idx = findIdx(1, n, 1, l, r);
			long width = (long) (r - l + 1) * arr[idx];
			if (l <= idx - 1) {
				width = Math.max(width, getWidth(l, idx - 1, n));
			}
			if (idx + 1 <= r) {
				width = Math.max(width, getWidth(idx + 1, r, n));
			}
			return width;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			SegmentTree segTree = new SegmentTree(); // 모두 0으로 초기화
			for (int i = 1; i < n + 1; i++) arr[i] = Integer.parseInt(st.nextToken());
			segTree.init(1, n, 1);
			long max = segTree.getWidth(1, n, n);
			bw.write(max + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();		
	}
}

