// Beads (11143번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final String PUT = "P";
	static final String QUERY = "Q";
	static int T, B, P, Q; // TC, 박스수, P + Q: 쿼리 수
	static SegmentTree segTree = new SegmentTree(100_000);
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			B = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			for (int i = 0; i < P + Q; i++) {
				st = new StringTokenizer(br.readLine());
				String ord = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (ord.equals(PUT)) {
					segTree.update(1, B, 1, a, b);
				} else {
					bw.write(segTree.query(1, B, 1, a, b) + "\n");
				}
			}
			
			bw.flush();
			segTree.clear();
		}
		
		bw.close();
		br.close();
	}
}

class SegmentTree {
	int[] tree;
	
	SegmentTree(int n) {
		this.tree = new int[n * 4];
	}
	
	void update(int s, int e, int n, int idx, int val) {
		if (idx < s || e < idx) return;
		if (idx == s && e == idx) {
			tree[n] += val;
			return;
		}
		int mid = (s + e) >> 1;
		update(s, mid, n * 2, idx, val);
		update(mid + 1, e, n * 2 + 1, idx, val);
		tree[n] = tree[n * 2] + tree[n * 2 + 1];
		return;
	}
	
	int query(int s, int e, int n, int l, int r) {
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return tree[n];
		int mid = (s + e) >> 1;
		return query(s, mid, n * 2, l, r) + query(mid + 1, e, n * 2 + 1, l, r);
	}
	
	void clear() {
		Arrays.fill(tree, 0);
	}
}
