// 골목 대장 호석 - 효율성 2 (20183번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M, A, B;
	static long C;
	static int[] distance;
	static ArrayList<int[]>[] graph;

	static void init(int n) {
		graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
	}
	
	static int parametricSearch(int _min, int _max) {
		int s = _min;
		int e = _max;
		int ans = INF;
		while (s <= e) {
			int mid = (s + e) >> 1;
			boolean flag = dijkstra(mid);
			if (flag) { // 도달할 수 있으면 mid를 줄여봄
				e = mid - 1;
				ans = mid;
			} else {
				s = mid + 1;
			}
		}
		return (ans == INF) ? -1 : ans;
	}
	
	static boolean dijkstra(int limit) {
		distance = new int[N + 1];
		Arrays.fill(distance, INF);
		distance[A] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.max, o2.max));
		pq.add(new Pair(A, C, 0));
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.cur] < pair.max) continue;
			if (pair.cur == B) return true;
			for (int i = 0; i < graph[pair.cur].size(); i++) {
				int nxt = graph[pair.cur].get(i)[0];
				int cost = graph[pair.cur].get(i)[1];
				if (cost <= limit) {
					long nxtC = pair.c - cost;
					int maxC = Math.max(pair.max, cost);
					if (nxtC >= 0 && maxC < distance[nxt]) {
						distance[nxt] = maxC;
						pq.add(new Pair(nxt, nxtC, maxC));
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 노드 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		A = Integer.parseInt(st.nextToken()); // 시작 노드
		B = Integer.parseInt(st.nextToken()); // 도착 노드
		C = Long.parseLong(st.nextToken()); // 가진 돈(상한)
		
		init(N);
		int _min = INF;
		int _max = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] {v, c});
			graph[v].add(new int[] {u, c});
			_min = Math.min(_min, c);
			_max = Math.max(_max, c);
		}
		
		int ans = parametricSearch(_min, _max);
		System.out.println(ans);
		
	}
}


class Pair {
	int cur, max;
	long c;
	Pair() {}
	Pair(int cur, long c, int max) {
		this.cur = cur;
		this.c = c;
		this.max = max;
	}
}

