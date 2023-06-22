// KCM Travel (10217번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int T, N, M, K; // 테스트 케이스, 공항 수, 지원 비용, 티켓 정보 수
	static int[][] cost, dist;
	static ArrayList<ArrayList<Pair>> graph;
	static final int MAX = Integer.MAX_VALUE;
	
	static int dijkstra() {
		int[][] distance = new int[N + 1][M + 1]; // i번 도시까지 j의 비용으로 갈 수 있는 최소 소요 시간
		int[][] dist = new int[N + 1][100001];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(distance[i], MAX);
			Arrays.fill(dist[i], MAX);
		}
				
		PriorityQueue<Pair> pq = new PriorityQueue<>((Pair o1, Pair o2) -> 
		{
			if (o1.d > o2. d) return 1;
			else if (o1.d < o2.d) return -1;
			else return Integer.compare(o1.c, o2.c);
		});
		
		pq.add(new Pair(1, 0, 0)); // 1번 도시, 0의 비용, 0의 소요 시간
		distance[1][0] = 0;

		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			int cur = pair.node;
			if (distance[cur][pair.c] < pair.d) continue;
			if (dist[cur][pair.d] < pair.c) continue;
			if (cur == N) return pair.d;
			for (int i = 0; i < graph.get(cur).size(); i++) {
				Pair nxtPair = graph.get(cur).get(i);
				int nxt = nxtPair.node; // 다음 위치
				int nxtCost = pair.c + nxtPair.c; // 다음 위치까지 가는데 드는 비용
				int nxtDist = pair.d + nxtPair.d; // 다음 위치까지 가는데 드는 소요 시간
				if (nxtCost > M) continue;
				if (nxtDist >= distance[nxt][nxtCost]) continue;
				if (nxtCost >= dist[nxt][nxtDist]) continue;
				// nxtCost 이상의 비용에 대해서 nxtDist 이상인 것을 탐색할 필요 없음
				pq.add(new Pair(nxt, nxtCost, nxtDist));
				distance[nxt][nxtCost] = nxtDist;
				dist[nxt][nxtDist] = nxtCost;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			Pair[][] pairs = new Pair[N + 1][N + 1];
			graph = new ArrayList<>();
			
			for (int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
				for (int j = 0; j < N + 1; j++) pairs[i][j] = new Pair(MAX, MAX);
			}
			
			ArrayList<int[]> info = new ArrayList<>();
			int u, v, c, d;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken()); // 출발 공항
				v = Integer.parseInt(st.nextToken()); // 도착 공항
				c = Integer.parseInt(st.nextToken()); // 비용
				d = Integer.parseInt(st.nextToken()); // 소요 시간
				int[] tmp = new int[4];
				tmp[0] = u;
				tmp[1] = v;
				tmp[2] = c;
				tmp[3] = d;
				info.add(tmp);
				if (c <= pairs[u][v].c && d <= pairs[u][v].d) {
					pairs[u][v].c = c;
					pairs[u][v].d = d;
				}
			}
			
			for (int[] arr : info) {
				u = arr[0];
				v = arr[1];
				c = arr[2];
				d = arr[3];
				// 절대적으로 크면 continue
				if (pairs[u][v].c <= c && pairs[u][v].d < d) continue;
				if (pairs[u][v].c < c && pairs[u][v].d <= d) continue;
				graph.get(u).add(new Pair(v, c, d));				
			}
			
			int ret = dijkstra();
			if (ret == -1) bw.write("Poor KCM" + "\n");
			else bw.write(ret + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair {
	int node;
	int c;
	int d;
	
	Pair(int c, int d) {
		this.c = c;
		this.d = d;
	}
	
	Pair(int node, int c, int d) {
		this.node = node;
		this.c = c;
		this.d = d;
	}
}