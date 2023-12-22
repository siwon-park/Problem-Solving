// 미확인 도착지 (9370번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int n, m, t; // 노드, 간선, 목적지 후보 수
	static int s, g, h; // 출발지, 경유지1, 경유지2
	static ArrayList<ArrayList<int[]>> graph;
	
	static void init(int N) {
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
	}
	
	static int[] dijkstra(int start) {
		int[] distance = new int[n + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.add(new int[] {start, 0});
		
		while (!pq.isEmpty()) {
			int[] pair = pq.poll();
			int cur = pair[0];
			int cur_d = pair[1];
			if (distance[cur] < cur_d) continue;
			for (int i = 0; i < graph.get(cur).size(); i++) {
				int[] tmp = graph.get(cur).get(i);
				int nxt = tmp[0];
				int nxt_d = tmp[1];
				int dist = cur_d + nxt_d;
				if (dist < distance[nxt]) {
					distance[nxt] = dist;
					pq.add(new int[] {nxt, dist});
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			init(n);
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				graph.get(a).add(new int[] {b, d});
				graph.get(b).add(new int[] {a, d});
			}
			
			int[] candidates = new int[t];
			for (int i = 0; i < t; i++) {
				candidates[i] = Integer.parseInt(br.readLine());
			}
			
			int[] sToAll = dijkstra(s); // s에서 출발해서 모든 노드로 가는 최단 거리
			int[] gToAll = dijkstra(g); // g에서 출발해서 모든 노드로 가는 최단 거리
			int[] hToAll = dijkstra(h); // h에서 출발해서 모든 노드로 가는 최단 거리
			
			ArrayList<Integer> arrayList = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				int x = candidates[i]; // 목적지 후보
				int targetMinDist =  gToAll[h] + Math.min(sToAll[g] + hToAll[x], sToAll[h] + gToAll[x]); // g <-> h는 값이 같음
				if (sToAll[x] == targetMinDist) {
					arrayList.add(x);
				}
			}
			
			Collections.sort(arrayList);
			for (int i = 0; i < arrayList.size(); i++) {
				sb.append(arrayList.get(i));
				sb.append(" ");
			}
			sb.append("\n");
			
			bw.write(sb.toString());
 		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}