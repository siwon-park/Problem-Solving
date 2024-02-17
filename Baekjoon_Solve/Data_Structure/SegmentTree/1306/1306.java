// 달려라 홍준 (1306번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		SegmentTree segTree = new SegmentTree(N, arr);
		segTree.init(1, N, 1);
		
		for (int i = M; i < N - M + 2; i++) {
			int ans = segTree.rangeMax(1, N, 1, i - M + 1, i + M - 1);
			bw.write(ans + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class SegmentTree {
	int[] tree, arr;
	
	SegmentTree(int n, int[] arr) {
		this.tree = new int[n * 4];
		this.arr = arr;
	}
	
	void init(int s, int e, int n) {
		if (s == e) {
			tree[n] = arr[s];
			return;
		}
		int mid = (s + e) >> 1;
		init(s, mid, n * 2);
		init(mid + 1, e, n * 2 + 1);
		tree[n] = Math.max(tree[n * 2], tree[n * 2 + 1]);
	}
	
	int rangeMax(int s, int e, int n, int l, int r) {
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return tree[n];
		int mid = (s + e) >> 1;
		return Math.max(rangeMax(s, mid, n * 2, l, r), rangeMax(mid + 1, e, n * 2 + 1, l, r));
	}
}
