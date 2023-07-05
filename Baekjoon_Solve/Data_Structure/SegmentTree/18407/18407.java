// 가로 블록 쌓기 (18407번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N; // 블록의 개수
	static int[][] blocks; // 블록
	static HashMap<Integer, Integer> posMap; // 좌표 압축을 위한 해시맵
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		blocks = new int[N][2];
		
		ArrayList<Integer> posList = new ArrayList<>(); // 좌표 압축을 위한 리스트
		StringTokenizer st;
		int w, d;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 블럭의 크기
			d = Integer.parseInt(st.nextToken()); // 블럭의 시작 지점
			blocks[i][0] = d;
			blocks[i][1] = d + w - 1;
			posList.add(blocks[i][0]);
			posList.add(blocks[i][1]);
		}
		
		Collections.sort(posList); // 정렬
		int ord = 1; // 좌표 압축한 노드의 번호
		posMap = new HashMap<>();
		for (Integer x : posList) {
			if (posMap.get(x) == null) posMap.put(x, ord++);
		}
		
		int size = posMap.size(); // 노드 수
		
		SegmentTree segmentTree = new SegmentTree(size);
		
		int a, b, h;
		for (int i = 0; i < N; i++) {
			a = posMap.get(blocks[i][0]);
			b = posMap.get(blocks[i][1]);
			h = segmentTree.max(1, size, 1, a, b); // a와 b중 가장 큰 구간의 높이
			segmentTree.update(1, size, 1, a, b, h + 1); // 가장 큰 구간의 높이 + 1로 갱신해 줌
		}
		
		int l = posMap.get(posList.get(0));
		int r = posMap.get(posList.get(posList.size() - 1));
		
		bw.write(segmentTree.max(1, size, 1, l, r) + "");
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
			tree[n] = lazy[n];
			if (s != e) {
				lazy[n * 2] = lazy[n];
				lazy[n * 2 + 1] = lazy[n];
			}
			lazy[n] = 0;
		}
	}
	
	void update(int s, int e, int n, int l, int r, int v) {
		lazyPropagation(s, e, n);
		if (r < s || e < l) return;
		if (l <= s && e <= r) {
			lazy[n] = v;
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