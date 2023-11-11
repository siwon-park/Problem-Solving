// 네트워크 복구 (2211번)
import java.io.*;
import java.util.*;

public class Main {

	static final int MAX = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	static int N, M, K;
	static boolean[] visited;
	static int[] path, distance;
	static ArrayList<ArrayList<Pair>> graph;
	
	static void dijkstra(int s) {
		distance = new int[N + 1]; // 최단 거리
		path = new int[N + 1]; // 경로
		Arrays.fill(distance, MAX);
		distance[s] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new Pair(s, 0));
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.node] < pair.cost) continue;
			for (int i = 0; i < graph.get(pair.node).size(); i++) {
				Pair nxtPair = graph.get(pair.node).get(i);
				if (nxtPair.cost + pair.cost < distance[nxtPair.node]) {
					distance[nxtPair.node] = nxtPair.cost + pair.cost;
					pq.add(new Pair(nxtPair.node, distance[nxtPair.node]));
					path[nxtPair.node] = pair.node; // pair.node 다음으로 nxtPair.node로 갔음
				}
			}
		}
	}
	
	static void findPath(int cur) {
		visited[cur] = true;
		while (path[cur] != 0) {
			sb.append(path[cur]);
			sb.append(" ");
			sb.append(cur);
			sb.append("\n");
			K++;
			cur = path[cur];
			if (visited[cur]) return; // 다음 노드가 이미 방문한 노드면 더 이상 방문하지 않아도 됨
			visited[cur] = true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());			
			graph.get(A).add(new Pair(B, C));
			graph.get(B).add(new Pair(A, C));
		}
		
		dijkstra(1);
		K = 0; // 복구한 회선의 수
		visited = new boolean[N + 1];
		for (int i = 2; i < N + 1; i++) {
			if (visited[i]) continue;
			findPath(i);
		}
		
		bw.write(K + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int node, cost;
	Pair() {}
	Pair(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
}