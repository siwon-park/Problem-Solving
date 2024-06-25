// 연애 혁명 (27498번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] parent;
	
	static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	static void init(int n) {
		parent = new int[n + 1];
		for (int i = 0; i < n + 1; i++) parent[i] = i;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init(N);
		
		int total = 0;
		int edges = 0;
		ArrayList<int[]> arrayList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 애정도
			int d = Integer.parseInt(st.nextToken()); // 관계 유무
			if (d == 0) {
				arrayList.add(new int[] {a, b, c});
				total += c;
			}
			else {
				union(a, b);
				edges += 1;
			}
		}
		
		// 정렬
		arrayList.sort((o1, o2) -> Integer.compare(o2[2], o1[2]));
		
		for (int[] pair : arrayList) {
			int a = pair[0];
			int b = pair[1];
			int c = pair[2];
			if (find(a) != find(b)) {
				total -= c;
				union(a, b);
				edges += 1;
				if (edges == N - 1) break;
			}
		}
		
		System.out.println(total);
	}
}
