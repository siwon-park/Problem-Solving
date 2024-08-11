// 쓰담쓰담 (12741번)
import java.io.*;
import java.util.*;

public class Main {

	static String angry = "HSS090";
	static String happy = "CS204";	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		SegmentTree segTree = new SegmentTree(N, arr);
		segTree.init(1, N, 1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if (q == 1) {
				boolean ret = segTree.isAscending(1, N, 1, l, r);
				if (!ret) bw.write(angry + "\n");
				else bw.write(happy + "\n");
			} else {
				int v1 = arr[l];
				int v2 = arr[r];
				segTree.update(1, N, 1, l, v2);
				segTree.update(1, N, 1, r, v1);
				arr[l] = v2;
				arr[r] = v1;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class SegmentTree {
	
	int[][] tree;
	int[] arr;
	boolean[] asc;
	
	SegmentTree(int n, int[] arr) {
		this.tree = new int[n * 4][2];
		this.asc = new boolean[n * 4];
		this.arr = arr;
	}
	
	void init(int s, int e, int n) {
		if (s == e) {
			tree[n][0] = arr[s];
			tree[n][1] = arr[e];
			asc[n] = true;
			return;
		}
		int mid = (s + e) >> 1;
		init(s, mid, n * 2); // 왼쪽
		init(mid + 1, e, n * 2 + 1); // 오른쪽
		tree[n][0] = tree[n * 2][0];
		tree[n][1] = tree[n * 2 + 1][1];
		if (!asc[n * 2] || !asc[n * 2 + 1]) { // 둘 중 하나가 false이면 오름차순 아님
			asc[n] = false;
		} else { // 둘 다 true면
			if (tree[n * 2][1] > tree[n * 2 + 1][0]) asc[n] = false;
			else asc[n] = true;
		}
	}
	
	void update(int s, int e, int n, int idx, int v) {
		if (idx < s || e < idx) return;
		if (idx == s && e == idx) {
			tree[n][0] = v;
			tree[n][1] = v;
			return;
		}
		int mid = (s + e) >> 1;
		update(s, mid, n * 2, idx, v);
		update(mid + 1, e, n * 2 + 1, idx, v);
		tree[n][0] = tree[n * 2][0];
		tree[n][1] = tree[n * 2 + 1][1];
		if (!asc[n * 2] || !asc[n * 2 + 1]) {
			asc[n] = false;
		} else {
			if (tree[n * 2][1] > tree[n * 2 + 1][0]) asc[n] = false;
			else asc[n] = true;
		}
	}
	
	boolean isAscending(int s, int e, int n, int l, int r) {
		if (r < s || e < l) return true;
		if (l <= s && e <= r) return asc[n];
		int mid = (s + e) >> 1;
		boolean left = isAscending(s, mid, n * 2, l, r);
		boolean right = isAscending(mid + 1, e, n * 2 + 1, l, r);
		if (!left || !right) return false;
		else {
			if (r < s || mid < l) return right;
			else if (r < mid + 1 || e < l) return left;
			else {
				if (tree[n * 2][1] > tree[n * 2 + 1][0]) return false;
				return true;
			}
		}
	}	
}

