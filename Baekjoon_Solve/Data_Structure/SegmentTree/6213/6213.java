// Balanced Lineup (6213번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(br.readLine());
		
		SegTree segTree = new SegTree(N, arr);
		segTree.init(1, N, 1);
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int[] pair = segTree.minMax(1, N, 1, l, r);
			bw.write((pair[1] - pair[0]) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}


class SegTree {
	
	static final int[] INF = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
	int[][] tree;
	int[] arr;
	
	SegTree(int n, int[] arr) {
		this.tree = new int[n * 4][2];
		this.arr = arr;
	}
	
	void init(int s, int e, int n) {
		if (s == e) {
			tree[n][0] = arr[s];
			tree[n][1] = arr[s];
			return;
		}
		int mid = (s + e) >> 1;
		init(s, mid, n * 2);
		init(mid + 1, e, n * 2 + 1);
		tree[n][0] = Math.min(tree[n * 2][0], tree[n * 2 + 1][0]);
		tree[n][1] = Math.max(tree[n * 2][1], tree[n * 2 + 1][1]);
	}
	
	int[] minMax(int s, int e, int n, int l, int r) {
		if (r < s || e < l) return INF;
		else if (l <= s && e <= r) return tree[n];
		int mid = (s + e) >> 1;
		int[] left = minMax(s, mid, n * 2, l, r);
		int[] right = minMax(mid + 1, e, n * 2 + 1, l, r);
		int min = Math.min(left[0], right[0]);
		int max = Math.max(left[1], right[1]);
		return new int[] {min, max};
	}
}