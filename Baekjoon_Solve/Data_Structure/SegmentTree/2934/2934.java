// LRH 식물 (2934번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int MAX = 100_001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] flowers = new int[MAX];
		SegmentTree segmentTree = new SegmentTree(MAX);
		
		StringTokenizer st;
		int l, r, before;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			// 꽃이 피기 전 값
			before = flowers[l] + flowers[r];
			
			// 구간 [l + 1, r - 1]을 업데이트
			segmentTree.update(1, MAX, 1, l + 1, r - 1, 1);
			flowers[l] = segmentTree.count(1, MAX, 1, l, l);
			flowers[r] = segmentTree.count(1, MAX, 1, r, r);
			
			// 꽃이 핀 후의 값 구간 [l, l] + 구간 [r, r] - before
			bw.write(flowers[l] + flowers[r] - before + "\n");	
		}
		bw.flush();
		bw.close();
		br.close();
	}
}


class SegmentTree {
	
	int[] tree;
	int[] lazy;
	
	SegmentTree(int n) {
		this.tree = new int[n * 4];
		this.lazy = new int[n * 4];
	}
	
    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {
            tree[n] += lazy[n];
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
	}
	
	int count(int s, int e, int n, int l, int r) {
		lazyPropagation(s, e, n);
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return tree[n];
		int mid = (s + e) / 2;
		return count(s, mid, n * 2, l, r) + count(mid + 1, e, n * 2 + 1, l, r);
	}
}