// 등산 (16681번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final long INF = Long.MAX_VALUE;
	static int N, M, D, E; // 정점, 경로, 체력 소모량, 성취감
	static int[] height; // 각 지점별 높이
	static ArrayList<ArrayList<int[]>> graph; // 그래프
	
	static long[] dijkstra(int s) {
		long[] distance = new long[N + 1]; // 각 지점에 가기까지 소모한 체력
		Arrays.fill(distance, INF);
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
		distance[s] = 0; // 출발지점의 가치는 무한대로 설정
		pq.add(new Pair(s, 0));
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			int cur = pair.node;
			long v = pair.cost;
			if (distance[cur] < v) continue;
			for (int i = 0; i < graph.get(cur).size(); i++) {
				int[] nxtPair = graph.get(cur).get(i);
				int nxt = nxtPair[0];
				int cost = nxtPair[1];
				if (height[nxt] <= height[cur]) continue; // 다음 이동할 곳의 높이가 작으면 continue
				long newCost = cost + v;
				if (newCost < distance[nxt]) {
					distance[nxt] = newCost;
					pq.add(new Pair(nxt, newCost));
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		height = new int[N + 1];
		graph = new ArrayList<>();
		graph.add(new ArrayList<>());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			graph.get(a).add(new int[] {b, n});
			graph.get(b).add(new int[] {a, n});
		}
		
		long[] d1 = dijkstra(1);
		long[] d2 = dijkstra(N);
		
		long ans = -INF;
		for (int i = 1; i < N + 1; i++) {
			if (d1[i] == INF || d2[i] == INF) continue; // 둘 중 하나가 갈 수 없다면 continue
			ans = Math.max((E * height[i]) - ((d1[i] + d2[i]) * D), ans);
		}
		
		if (ans == -INF) bw.write("Impossible");
		else bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int node;
	long cost;
	Pair(int node, long cost) {
		this.node = node;
		this.cost = cost;
	}
}