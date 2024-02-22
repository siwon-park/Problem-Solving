// 가희와 여행가요 (30797번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q;
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
		Q = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) parent[i] = i;
		
		ArrayList<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			pairs.add(new Pair(a, b, cost, time));
		}
		
		Collections.sort(pairs, (o1, o2) -> {
			if (o1.cost > o2.cost) return 1;
			else if (o1.cost < o2.cost) return -1;
			else return Integer.compare(o1.time, o2.time);
		});
		
		int m = 0;
		long t = 0;
		long c = 0;
		for (int i = 0; i < Q; i++) {
			Pair pair = pairs.get(i);
			if (find(pair.a) != find(pair.b)) {
				union(pair.a, pair.b);
				m += 1;
				c += pair.cost;
				t = Math.max(t, pair.time);
				if (m == N - 1) break;
			}
		}
		
		if (m != N - 1) {
			bw.write(-1 + "");
		} else {
			bw.write(t + " " + c);			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int a, b, cost, time;
	Pair(int a, int b, int cost, int time) {
		this.a = a;
		this.b = b;
		this.cost = cost;
		this.time = time;
	}
}
