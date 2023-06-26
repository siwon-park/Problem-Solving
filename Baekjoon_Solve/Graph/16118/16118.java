// 달빛 여우 (16118번)
import java.io.*;
import java.util.*;

public class Main {

	static final long MAX = Long.MAX_VALUE;
	static int N, M; // 정점의 수, 간선의 수
	static long[] foxDist; // 여우의 최단 거리 테이블
	static long[][] wolfDist; // 늑대의 최단 거리 테이블
	static ArrayList<Pair>[] graph; // 그래프
	
	// 여우의 다익스트라
	static void dijkstraFox() {
		Arrays.fill(foxDist, MAX);
		foxDist[1] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(1, 0)); // 현재 노드, 비용
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (foxDist[pair.n] < pair.c) continue;
			for (Pair info : graph[pair.n]) {
				if (pair.c + info.c < foxDist[info.n]) {
					foxDist[info.n] = pair.c + info.c;
					pq.add(new Pair(info.n, pair.c + info.c));
				}
			}
		}
	}
	
	// 늑대의 다익스트라
	static void dijkstraWolf() {
		Arrays.fill(wolfDist[0], MAX);
		Arrays.fill(wolfDist[1], MAX);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(1, 0, 0)); // 현재 노드, 비용, 사용한 간선의 수(홀, 짝)
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (wolfDist[pair.k][pair.n] < pair.c) continue;
			int k = 1 - pair.k;
			for (Pair info : graph[pair.n]) {
				long cost = (pair.k == 1) ? pair.c + info.c * 2 : pair.c + info.c / 2;
				if (cost < wolfDist[k][info.n]) {
					wolfDist[k][info.n] = cost;
					pq.add(new Pair(info.n, cost, k));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
		
		int a, b, d;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			graph[a].add(new Pair(b, 2 * d));
			graph[b].add(new Pair(a, 2 * d));
		}
		
		foxDist = new long[N + 1];
		wolfDist = new long[2][N + 1];
		
		dijkstraFox();
		dijkstraWolf();
		
		int cnt = 0;
		for (int i = 2; i < N + 1; i++) {
			if (foxDist[i] < wolfDist[0][i] && foxDist[i] < wolfDist[1][i]) cnt += 1;
		}
		
		System.out.println(cnt);
	}
}

class Pair implements Comparable<Pair> {
	int n;
	long c;
	int k;
	
	Pair(int n, long c) {
		this.n = n;
		this.c = c;
	}
	
	Pair(int n, long c, int k) {
		this.n = n;
		this.c = c;
		this.k = k;
	}
	
	@Override
	public int compareTo(Pair o) {
		return Long.compare(this.c, o.c);
	}
}