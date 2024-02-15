// 슬슬 가지를 먹지 않으면 죽는다 (27945번)
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) parent[i] = i;
		
		ArrayList<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			pairs.add(new Pair(u, v, t));
		}
		
		// 여는 일자를 기준으로 정렬
		Collections.sort(pairs, (o1, o2) -> Integer.compare(o1.t, o2.t));
		
		int m = 0;
		int d = 1;
		for (int i = 0; i < M; i++) {
			Pair pair = pairs.get(i);
			if (find(pair.u) != find(pair.v)) {
				union(pair.u, pair.v);
				m += 1;
				if (d == pair.t) d++;
				if (m == N - 1) break;
			}
		}
		
		bw.write(d + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int u, v, t;
	Pair() {}
	Pair(int u, int v, int t) {
		this.u = u;
		this.v = v;
		this.t = t;
	}
}