// 출퇴근 (20313번)
import java.io.*;
import java.util.*;

public class Main {

	static final long MAX = Long.MAX_VALUE;
	static int N, M, A, B, K;
	static int[][] T;
	static ArrayList<int[]>[] graph;
	
	static void init(int n) {
		T = new int[M][101];
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
	}
	
	static long dijkstra(int s, int e) {
		long[][] distance = new long[N + 1][K + 1];
		for (int i = 0; i < N + 1; i++) Arrays.fill(distance[i], MAX);
		distance[s][0] = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.dist > o2.dist) return 1;
			else if (o1.dist < o2.dist) return -1;
			else return Integer.compare(o1.k, o2.k);
		});
		
		pq.add(new Pair(s, 0, 0));
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.cur][pair.k] < pair.dist) continue;
			if (pair.cur == e) return distance[pair.cur][pair.k];
			for (int k = pair.k; k < K + 1; k++) {
				for (int i = 0; i < graph[pair.cur].size(); i++) {
					int nxt = graph[pair.cur].get(i)[0];
					int r = graph[pair.cur].get(i)[1];
					int tk = T[r][k];
					if (tk + pair.dist < distance[nxt][k]) {
						distance[nxt][k] = tk + pair.dist;
						pq.add(new Pair(nxt, tk + pair.dist, k));
					}
				}
				
			}
		}
		
		long d = MAX;
		for (int k = 0; k < K + 1; k++) d = Math.min(d, distance[e][k]);
		return d;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		init(N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] {v, i});
			graph[v].add(new int[] {u, i});
			T[i][0] = r;
		}
		
		K = Integer.parseInt(br.readLine());
		for (int k = 1; k < K + 1; k++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) T[i][k] = Integer.parseInt(st.nextToken());
		}
		
		long ans = dijkstra(A, B);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
}

class Pair {
	int cur, k;
	long dist;
	Pair() {}
	Pair(int cur, long dist, int k) {
		this.cur = cur;
		this.dist = dist;
		this.k = k;
	}
}