// 겨울나기 (18135번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 칸 수
		int M = Integer.parseInt(st.nextToken()); // 영역의 수
		SegmentTree segTree = new SegmentTree(M); // 영역의 크기만큼 세그먼트 트리를 구성
		int[] area = new int[N + 1];
		
		// 영역 i에 c를 저장함
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			area[a] = i;
			area[b] = i;
			segTree.update(1, M, 1, i, i, c);
		}
		
		area[0] = 1;
		for (int i = 1; i < N + 1; i++) {
			if (area[i] == 0) area[i] = area[i - 1];
		}
		
		// 0, 0, 0을 입력받을 때까지 반복
		while (true) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (op == 0 && x == 0 && y == 0) {
				break;
			}
			
			if (op == 1) { // 구간 [x, y]의 도토리 개수 점검
				if (x <= y) {
					bw.write(segTree.sum(1, M, 1, area[x], area[y]) + "\n");
				} else {
					// 구간 [x, N]의 합과 구간 [1, y]의 합을 계산
					bw.write((segTree.sum(1, M, 1, area[x], area[N]) + segTree.sum(1, M, 1, area[1], area[y])) + "\n");
				}
			} else { // 구간 [x, y]에 도토리를 z개 추가 저장
				int z = Integer.parseInt(st.nextToken());
				if (x <= y) {
					segTree.update(1, M, 1, area[x], area[y], z);
				} else {
					// 구간 [x, N]과 구간 [1, y]에 z값을 업데이트
					segTree.update(1, M, 1, area[x], area[N], z);
					segTree.update(1, M, 1, area[1], area[y], z);
				}
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}


class SegmentTree {
	long[] tree, lazy;
	
	SegmentTree(int n) {
		this.tree = new long[n * 4];
		this.lazy = new long[n * 4];
	}
	
	void lazyPropagation(int s, int e, int n) {
		if (lazy[n] != 0) {
			tree[n] += (e - s + 1) * lazy[n];
			if (s != e) {
				lazy[n * 2] += lazy[n];
				lazy[n * 2 + 1] += lazy[n];
			}
		}
		lazy[n] = 0;
	}
	
	void update(int s, int e, int n, int l, int r, int v) {
		lazyPropagation(s, e, n);
		if (r < s || e < l) return;
		if (l <= s && e <= r) {
			lazy[n] += v;
			lazyPropagation(s, e, n);
			return;
		}
		int mid = (s + e) >> 1;
		update(s, mid, n * 2, l, r, v);
		update(mid + 1, e, n * 2 + 1, l, r, v);
		tree[n] = tree[n * 2] + tree[n * 2 + 1];
		return;
	}
	
	long sum(int s, int e, int n, int l, int r) {
		lazyPropagation(s, e, n);
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) {
			return tree[n];
		}
		int mid = (s + e) >> 1;
		return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
	}
}
