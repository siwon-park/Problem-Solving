// JuQueen (10277번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int C, N, O;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken()); // 코어의 수
		N = Integer.parseInt(st.nextToken());
		O = Integer.parseInt(st.nextToken());
		
		SegmentTree segmentTree = new SegmentTree(C);
		
		String op;
		int a, b, v, x;
		for (int i = 0; i < O; i++) {
			st = new StringTokenizer(br.readLine());
			op = st.nextToken(); // 쿼리 종류
			if (op.equals("state")) { // x번째 코어의 상태 확인
				x = Integer.parseInt(st.nextToken());
				bw.write(segmentTree.calculate(1, C, 1, x + 1, x + 1).max + "\n");
			} else if (op.equals("groupchange")) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				Pair now = segmentTree.calculate(1, C, 1, a + 1, b + 1);
				if (now.max + v > N) {
					segmentTree.update(1, C, 1, a + 1, b + 1, N - now.max);
					bw.write(N - now.max + "\n");
				} else if (now.min + v < 0) {
					segmentTree.update(1, C, 1, a + 1, b + 1, -now.min);
					bw.write(-now.min + "\n");
				} else {
					segmentTree.update(1, C, 1, a + 1, b + 1, v);
					bw.write(v + "\n");
				}
			} else if (op.equals("change")) {
				x = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				Pair now = segmentTree.calculate(1, C, 1, x + 1, x + 1);
				if (now.max + v > N) {
					segmentTree.update(1, C, 1, x + 1, x + 1, N - now.max);
					bw.write(N - now.max + "\n");
				} else if (now.max + v < 0) {
					segmentTree.update(1, C, 1, x + 1, x + 1, -now.max);
					bw.write(-now.max + "\n");
				} else {
					segmentTree.update(1, C, 1, x + 1, x + 1, v);
					bw.write(v + "\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}


class SegmentTree {
	
	Pair[] tree;
	int[] lazy;
	final Pair dummy = new Pair(Integer.MAX_VALUE, 0);
	
	SegmentTree(int n) {
		this.tree = new Pair[n * 4];
		for (int i = 0; i < n * 4; i++) tree[i] = new Pair(0, 0); 
		this.lazy = new int[n * 4];
	}
	
	void lazyPropagation(int s, int e, int n) {
		if (lazy[n] != 0) {
			tree[n].min += lazy[n];
			tree[n].max += lazy[n];
			if (s != e) {
				lazy[n * 2] += lazy[n];
				lazy[n * 2 + 1] += lazy[n];
			}
			lazy[n] = 0;
		}
	}
	
	void update(int s, int e, int n, int l, int r, int v) {
		lazyPropagation(s, e, n);
		if (r < s || e < l) return;
		if (l <= s && e <= r) {
			lazy[n] += v;
			lazyPropagation(s, e, n);
			return;
		}
		int mid = (s + e) / 2;
		update(s, mid, n * 2, l, r, v);
		update(mid + 1, e, n * 2 + 1, l, r, v);
		tree[n].min = Math.min(tree[n * 2].min, tree[n * 2 + 1].min);
		tree[n].max = Math.max(tree[n * 2].max, tree[n * 2 + 1].max);
		return;
	}
	
	Pair calculate(int s, int e, int n, int l, int r) {
		lazyPropagation(s, e, n);
		if (r < s || e < l) return dummy;
		if (l <= s && e <= r) return tree[n];
		int mid = (s + e) / 2;
		Pair o1 = calculate(s, mid, n * 2, l, r);
		Pair o2 = calculate(mid + 1, e, n * 2 + 1, l, r);
		return new Pair(Math.min(o1.min, o2.min), Math.max(o1.max, o2.max));
	}
}

class Pair {
	int min;
	int max;
	
	Pair(int min, int max) {
		this.min = min;
		this.max = max;
	}
}