// 골목 대장 호석 - 효율성 1 (20182번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, C, A, B;
	static int[] distance;
	static ArrayList<int[]>[] graph;

	static void init(int n, int c) {
		graph = new ArrayList[n + 1];
		distance = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
			distance[i] = c + 1;
		}
	}
	
	static int dijkstra(int s, int e) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.max, o2.max));
		distance[s] = 0;
		pq.add(new Pair(s, 0, 0));
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.cur] < pair.max) continue;
			for (int i = 0; i < graph[pair.cur].size(); i++) {
				int nxt = graph[pair.cur].get(i)[0];
				int d = graph[pair.cur].get(i)[1];
				int cost = pair.d + d;
				int max = Math.max(pair.max, d);
				if (cost <= C && max < distance[nxt]) {
					distance[nxt] = max;
					pq.add(new Pair(nxt, cost, max));
				}
			}
		}
		return (distance[e] == C + 1) ? -1 : distance[e];
 	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 노드 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		A = Integer.parseInt(st.nextToken()); // 시작 노드
		B = Integer.parseInt(st.nextToken()); // 도착 노드
		C = Integer.parseInt(st.nextToken()); // 가진 돈(상한)
		
		init(N, C);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new int[] {e, c});
			graph[e].add(new int[] {s, c});
		}
		
		int ans = dijkstra(A, B);
		System.out.print(ans);
	}
}


class Pair {
	int cur, d, max;
	Pair() {}
	Pair(int cur, int d, int max) {
		this.cur = cur;
		this.d = d;
		this.max = max;
	}
}

