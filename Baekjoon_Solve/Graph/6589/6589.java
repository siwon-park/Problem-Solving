// Heavy Cargo (6589번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, R;
	static HashMap<String, Integer> hashMap;
	static ArrayList<int[]>[] graph;
	
	static int dijkstra(int s, int e) {
		int[] distance = new int[N];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
		pq.add(new int[] {Integer.MAX_VALUE, s});
		while (!pq.isEmpty()) {
			int[] pair = pq.poll();
			int cost = pair[0];
			int cur = pair[1];
			if (cur == e) return distance[e];
			if (distance[cur] > cost) continue;
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i)[0];
				int nxtCost = graph[cur].get(i)[1];
				if (Math.min(cost, nxtCost) > distance[nxt]) {
					distance[nxt] = Math.min(cost, nxtCost);
					pq.add(new int[] {distance[nxt], nxt});
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tc = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			if (N == 0 && R == 0) break;
			
			hashMap = new HashMap<>(); 		
			graph = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			int ord = 0;
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				String U = st.nextToken();
				String V = st.nextToken();
				int w = Integer.parseInt(st.nextToken());
				if (!hashMap.containsKey(U)) {
					hashMap.put(U, ord++);
				}
				if (!hashMap.containsKey(V)) {
					hashMap.put(V, ord++);
				}
				int u = hashMap.get(U);
				int v = hashMap.get(V);
				// 양방향
				graph[u].add(new int[] {v, w});
				graph[v].add(new int[] {u, w});	
			}
			
			st = new StringTokenizer(br.readLine());
			int s = hashMap.get(st.nextToken());
			int e = hashMap.get(st.nextToken());
			
			int ans = dijkstra(s, e);
			bw.write("Scenario #" + tc + "\n");
			bw.write(ans + " tons\n");
			bw.write("\n");
			tc += 1;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

