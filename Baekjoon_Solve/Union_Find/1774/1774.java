// 우주신과의 교감 (1774번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] parent = new int[1001];
	static int[][] spots = new int[1001][2];
	
	static void init() {
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
	}
	
	static double calDist(int x1, int x2, int y1, int y2) {
		long ret = (long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2);
		return Math.sqrt(ret);
	}
	
	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			spots[i][0] = x;
			spots[i][1] = y;
		}
		
		init();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		ArrayList<Pair> arrayList = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			int x1 = spots[i][0];
			int y1 = spots[i][1];
			for (int j = i + 1; j < N; j++) {
				int x2 = spots[j][0];
				int y2 = spots[j][1];				
				arrayList.add(new Pair(i + 1, j + 1, calDist(x1, x2, y1, y2)));
			}
		}
		
		Collections.sort(arrayList, (o1, o2) -> Double.compare(o1.dist, o2.dist));
		
		double ans = 0;
		for (Pair pair : arrayList) {
			if (find(pair.a) != find(pair.b)) {
				union(pair.a, pair.b);
				ans += pair.dist;
			}
		}
		
//		ans = Math.round(ans * 100) / (double) 100;
		System.out.printf("%.2f\n", ans);
		bw.close();
		br.close();
	}
}


class Pair {
	int a, b;
	double dist;
	Pair() {}
	Pair(int a, int b, double dist) {
		this.a = a;
		this.b = b;
		this.dist = dist;
	}
}
