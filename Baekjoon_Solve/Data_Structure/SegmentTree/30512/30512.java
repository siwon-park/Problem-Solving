// 조용히 완전히 영원히 (30512번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 1_000_001;
	static int N, Q;
	static int[] arr, D;
	
	static class SegmentTree {
		int[][] tree;
		int[][] lazy;
		
		SegmentTree(int n) {
			this.tree = new int[n * 4][2];
			this.lazy = new int[2][n * 4];
			Arrays.fill(lazy[0], MAX);
		}
		
		void init(int s, int e, int n) {
			if (s == e) {
				tree[n][0] = arr[s];
				return;
			}
			int mid = (s + e) >> 1;
			init(s, mid, n * 2);
			init(mid + 1, e, n * 2 + 1);
			tree[n][0] = Math.min(tree[n * 2][0], tree[n * 2 + 1][0]);
			return;
		}
		
		void prop(int s, int e, int n) {
			if (lazy[0][n] != MAX) {
				if (tree[n][0] > lazy[0][n]) { // 구간 대푯값이 lazy값보다 낮을 때만 갱신
					tree[n][0] = lazy[0][n];
					tree[n][1] = lazy[1][n]; // 쿼리 번호 갱신
				}
				if (s != e) {
					if (lazy[0][n * 2] > lazy[0][n]) {
						lazy[0][n * 2] = lazy[0][n];
						lazy[1][n * 2] = lazy[1][n];
					}
					if (lazy[0][n * 2 + 1] > lazy[0][n]) {
						lazy[0][n * 2 + 1] = lazy[0][n];
						lazy[1][n * 2 + 1] = lazy[1][n];
					}
				}
				lazy[0][n] = MAX;
				lazy[1][n] = 0;
			}
		}
		
		void update(int s, int e, int n, int l, int r, int x, int q) {
			prop(s, e, n);
			if (r < s || e < l) return;
			if (l <= s && e <= r) {
				lazy[0][n] = Math.min(lazy[0][n], x);
				lazy[1][n] = q;
				prop(s, e, n);
				return;
			}
			int mid = (s + e) >> 1;
			update(s, mid, n * 2, l, r, x, q);
			update(mid + 1, e, n * 2 + 1, l, r, x, q);
			tree[n][0] = Math.min(tree[n * 2][0], tree[n * 2 + 1][0]);
			return;
		}
		
		void init2(int s, int e, int n) {
			prop(s, e, n);
			if (s == e) {
				arr[s] = tree[n][0];
				D[tree[n][1]] += 1; // 몇 번째 쿼리로 변했는지를 기록
				return;
			}
			int mid = (s + e) >> 1;
			init2(s, mid, n * 2);
			init2(mid + 1, e, n * 2 + 1);
			return;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Q = Integer.parseInt(br.readLine());
		D = new int[Q + 1];
		SegmentTree segTree = new SegmentTree(N);
		segTree.init(1, N, 1);
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int q =  i + 1;
			int l = Integer.parseInt(st.nextToken()); // l
			int r = Integer.parseInt(st.nextToken()); // r
			int x = Integer.parseInt(st.nextToken()); // x
			segTree.update(1, N, 1, l, r, x, q);
		}
	
		segTree.init2(1, N, 1); // 수열 복원 및 남은 props 전파
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(arr[i]);
			sb.append(" ");
		}
		sb.append("\n");
		bw.write(sb.toString());
		
		for (int i = Q; i > 1; i--) {
			D[i - 1] += D[i];
		}
		
		sb = new StringBuilder();
		for (int i = 2; i <= Q; i++) {
			sb.append(N - D[i]);
			sb.append(" ");
		}
		sb.append(N);
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}