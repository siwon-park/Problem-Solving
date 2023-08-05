package BOJ;

// 도서실카펫 (2601번)
import java.io.*;
import java.util.*;

public class Main {

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// (x1, y2), (x2, y1) -> 왼쪽 상단 꼭짓점, 오른쪽 하단 꼭짓점
		int x1 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine()); // 카펫의 길이
		/*
		 * x - k <= x2 <= x1 <= x -> x2 <= x <= x1 + k
		 * y - k <= y2 <= y1 <= y -> y2 <= y <= y1 + k
		 * */
		x1 += k;
		y1 += k;
		
		int M = Integer.parseInt(br.readLine()); // 얼룩의 수
		ArrayList<Pair> pairs = new ArrayList<>();
		ArrayList<int[]> inputs = new ArrayList<>();
		int c1, r2, c2, r1; // 왼쪽 상단 꼭짓점, 오른쪽 하단 꼭짓점
		for (int i = 0; i < M; i++) {
			try {
				st = new StringTokenizer(br.readLine());
				c1 = Integer.parseInt(st.nextToken());
				r2 = Integer.parseInt(st.nextToken());
				c2 = Integer.parseInt(st.nextToken());
				r1 = Integer.parseInt(st.nextToken());
				inputs.add(new int[] {c1, r2, c2, r1});
			} catch (Exception e) {
				inputs.add(inputs.get(i - 1));
			}
		}
		
		for (int i = 0; i < M; i++) {
			int[] input = inputs.get(i);
			c1 = input[0];
			r2 = input[1];
			c2 = input[2];
			r1 = input[3];
			c1 += k;
			r1 += k;
			if (r2 <= r1 && c2 <= c1) { // 이를 만족하지 않으면 한 변이 k인 정사각형으로 못 덮음
				pairs.add(new Pair(c2, r2, r1, 1)); // 1을 업데이트
				pairs.add(new Pair(c1 + 1, r2, r1, -1)); // -1을 업데이트
			}
		}
		
		
		// 정렬
		pairs.sort((o1, o2) -> Integer.compare(o1.x, o2.x)); // x좌표가 빠른 순으로 정렬
		
		SegmentTree segmentTree = new SegmentTree(1_000_555);
		int ans = 0;
        for (int i = 0, j = 0; i < pairs.size(); i = j) {
            while (j < pairs.size() && pairs.get(i).x == pairs.get(j).x) {
            	Pair pair = pairs.get(j);
                segmentTree.update(1, 1_000_555, 1, pair.y2, pair.y1, pair.v);
                j++;
            }
            ans = Math.max(ans, segmentTree.tree[1]);
        }
		bw.write(ans + "\n");
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
		tree[n] = Math.max(tree[n * 2], tree[n * 2 + 1]);
		return;
	}
	
	int max(int s, int e, int n, int l, int r) {
		lazyPropagation(s, e, n);
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return tree[n];
		int mid = (s + e) / 2;
		return Math.max(max(s, mid, n * 2, l, r), max(mid + 1, e, n * 2 + 1, l, r));
	}
	
}

class Pair {
	int x;
	int y2;
	int y1;
	int v;
	
	Pair(int x, int y2, int y1, int v) {
		this.x = x;
		this.y2 = y2;
		this.y1 = y1;
		this.v = v;
	}
}