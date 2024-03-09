// 골목 대장 호석 - 기능성 (20168번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N, M, A, B, C;
	static int[] distance;
	static ArrayList<int[]>[] graph;
	
	static void init(int n) {
		distance = new int[n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			distance[i] = MAX;
			graph[i] = new ArrayList<>();
		}
	}
	
	static int dijkstra(int s, int e) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.d, o2.d));
		distance[s] = 0;
		pq.add(new Pair(s, C, 0));
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.cur] < pair.d) continue;
			for (int i = 0; i < graph[pair.cur].size(); i++) {
				int nxt = graph[pair.cur].get(i)[0];
				int d = graph[pair.cur].get(i)[1];
				int left = pair.c - d;
				int max = Math.max(pair.d, d);
				if (left >= 0 && max < distance[nxt]) {
					distance[nxt] = max;
					pq.add(new Pair(nxt, left, max));
				}
			}
		}
		return (distance[e] == MAX) ? -1 : distance[e];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 노드
		M = Integer.parseInt(st.nextToken()); // 도로의 수
		A = Integer.parseInt(st.nextToken()); // 출발지
		B = Integer.parseInt(st.nextToken()); // 도착지
		C = Integer.parseInt(st.nextToken()); // 예산
		
		init(N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] {v, d});
			graph[v].add(new int[] {u, d});
		}
		
		int ans = dijkstra(A, B);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int cur, c, d;
	Pair(int cur, int c, int d) {
		this.cur = cur;
		this.c = c;
		this.d = d;
	}
}
