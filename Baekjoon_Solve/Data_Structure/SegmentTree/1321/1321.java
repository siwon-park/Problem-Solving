// 군인 (1321번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		N = Integer.parseInt(br.readLine()); // 군인의 수
		st = new StringTokenizer(br.readLine()); // 배열
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		SegmentTree segTree = new SegmentTree(N, arr);
		segTree.init(1, N, 1); // 세그먼트 트리 초기화
		
		M = Integer.parseInt(br.readLine()); // 쿼리의 수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 명령의 종류; 1: a명 증원/감원, 2: k번 군인의 부대 번호
			if (x == 1) {
				int idx = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				segTree.update(1, N, 1, idx, a);
			} else {
				int k = Integer.parseInt(st.nextToken());
				int army = segTree.find(1, N, 1, k);
				bw.write(army + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}


class SegmentTree {
	long[] tree;
	int[] arr;
	
	SegmentTree(int n, int[] arr) {
		this.tree = new long[n * 4];
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
		tree[n] = tree[n * 2] + tree[n * 2 + 1];
	}
	
	void update(int s, int e, int n, int idx, int val) {
		if (idx < s || e < idx) return;
		tree[n] += val; // 인덱스를 포함하는 모든 구간에 업데이트 -> 하단에 update 함수 호출 이후 덧셈 연산할 필요가 없음
		if (idx == s && e == idx) return;
		int mid = (s + e) >> 1;
		update(s, mid, n * 2, idx, val);
		update(mid + 1, e, n * 2 + 1, idx, val);
	}
	
	int find(int s, int e, int n, long prefixSum) {
		if (s == e) return s;
		int mid = (s + e) >> 1;
		if (tree[n * 2] >= prefixSum) return find(s, mid, n * 2, prefixSum); // 왼족 자식에서 누적합 이상인 곳을 찾음
		return find(mid + 1, e, n * 2 + 1, prefixSum - tree[n * 2]); // 오른쪽 자식에서 누적 합 - 왼쪽 자식 수 이상인 곳을 찾음
	}
}
