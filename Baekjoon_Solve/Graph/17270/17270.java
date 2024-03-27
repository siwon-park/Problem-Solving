// 연예인은 힘들어 (17270번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int V, M;
	static ArrayList<int[]>[] graph;
	
	static int[] dijkstra(int s) {
		int[] distance = new int[V + 1];
		Arrays.fill(distance, MAX);
		distance[s] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.add(new int[] {s, 0});
		while (!pq.isEmpty()) {
			int[] pair = pq.poll();
			int cur = pair[0];
			int d = pair[1];
			if (distance[cur] < d) continue;
			for (int i = 0; i < graph[cur].size(); i++) {
				int[] nxtPair = graph[cur].get(i);
				int nxt = nxtPair[0];
				int nxtD = nxtPair[1];
				if (d + nxtD < distance[nxt]) {
					distance[nxt] = d + nxtD;
					pq.add(new int[] {nxt, distance[nxt]});
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		
		st = new StringTokenizer(br.readLine());
		int J = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] dist1 = dijkstra(J); // 지헌
		int[] dist2 = dijkstra(S); // 성하
		
		int ans = -1;
		int cost = MAX; // 걸리는 시간
		for (int i = 1; i < V + 1; i++) {
			if (i == J || i == S) continue; // 각자의 출발 위치는 새로운 약속 장소 X
			if (dist1[i] == MAX || dist2[i] == MAX) continue; // 도달 불가능하면 약속 장소 X
			if (dist1[i] + dist2[i] < cost) {
				cost = dist1[i] + dist2[i];
			}
		}
		
		int minJ = MAX; // 지헌이가 가는 거리
		for (int i = V; i >= 1; i--) {
			if (i == J || i == S) continue; // 각자의 출발 위치는 새로운 약속 장소 X
			if (dist1[i] == MAX || dist2[i] == MAX) continue; // 도달 불가능하면 약속 장소 X
			if (dist1[i] + dist2[i] == cost && dist1[i] <= dist2[i]) { // 지헌이가 늦게 도착하면 안 됨
				if (dist1[i] < minJ) { // 지헌이랑 가장 가까운 곳이 약속장소가 됨
					minJ = dist1[i];
					ans = i;
				}
			}
		}
		
		System.out.println(ans);
	}
}