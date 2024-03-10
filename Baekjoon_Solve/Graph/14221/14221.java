// 편의점 (14221번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N, M;
	static int[] distance, candidates; // 최단 거리 테이블, 집 후보지 번호
	static ArrayList<int[]>[] graph;
	
	static void init(int n) {
		distance = new int[n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			distance[i] = MAX;
			graph[i] = new ArrayList<>();
		} 
	}
	
	static int dijkstra(PriorityQueue<int[]> pq) {
		while (!pq.isEmpty()) {
			int[] pair = pq.poll();
			int cur = pair[0];
			int d = pair[1];
			if (distance[cur] < d) continue;
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i)[0];
				int c = graph[cur].get(i)[1];
				if (d + c < distance[nxt]) {
					distance[nxt] = d + c;
					pq.add(new int[] {nxt, d + c});
				}
			}
		}
		
		// 가장 가까운 집 후보 중 정점의 번호가 가장 낮은 곳을 찾음
		int minD = distance[candidates[0]];
		int ans = candidates[0];
		for (int i = 1; i < candidates.length; i++) {
			int cand = candidates[i];
			if (distance[cand] < minD) {
				minD = distance[cand];
				ans = cand;
			}
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 수 
		M = Integer.parseInt(st.nextToken()); // 간선의 수 
	
		init(N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		candidates = new int[p];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < p; i++) candidates[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(candidates);
		
		st = new StringTokenizer(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		for (int i = 0; i < q; i++) {
			int conv = Integer.parseInt(st.nextToken());
			distance[conv] = 0;
			pq.add(new int[] {conv, 0});
		}
		
		int ans = dijkstra(pq);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
