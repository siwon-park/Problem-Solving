// 개구리 점프 (17619번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q;
	static int[] parent;
	static Wood[] woods;
	
	static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		woods = new Wood[N + 1];
		woods[0] = new Wood(-1, -1, -1);
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			woods[i] = new Wood(x1, x2, i);
		}
		
		// 정렬
		Arrays.sort(woods, (o1, o2) -> {
			if (o1.min > o2.min) return 1;
			else if (o1.min < o2.min) return -1;
			else return Integer.compare(o1.max, o2.max);
		});
		
		for (int i = 2; i < N + 1; i++) {
			Wood wood1 = woods[i - 1];
			Wood wood2 = woods[i];
			// 겹치는 범위를 벗어나면 continue -> 정렬 후 wood1의 최댓값보다 wood2의 최댓값이 더 크면 겹치는 부분이 없음
			if (wood1.max < wood2.min) continue;
			if (find(wood1.idx) != find(wood2.idx)) {
				union(wood1.idx, wood2.idx);
				// 범위 갱신 -> 정렬했으니 부모끼리 갱신하지 말고 인접한 나무끼리 갱신해도 됨
				woods[i - 1].min = Math.min(woods[i - 1].min, woods[i].min);
				woods[i - 1].max = Math.max(woods[i - 1].max, woods[i].max);
				woods[i].min = woods[i - 1].min;
				woods[i].max = woods[i - 1].max;
			}
		}
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int q1 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			if (find(q1) == find(q2)) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Wood {
	int min, max, idx;
	Wood() {}
	Wood(int min, int max, int idx) {
		this.min = min;
		this.max = max;
		this.idx = idx;
	}
}