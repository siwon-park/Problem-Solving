// 운전병의 딜레마 (27281번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, T; // 노드 수, 도로 수, 시간
	static ArrayList<int[]>[] graph;
	
	static int parmetricSearch(int s, int e) {
		int ans = -1;
		while (s <= e) {
			int mid = (s + e) >> 1;
			boolean flag = dijkstra(mid); // T시간 안에 mid의 불편도로 갈 수 있음 여부
			if (flag) { // 갈 수 있음 -> mid 값을 줄여봄
				e = mid - 1;
				ans = mid;
			} else { // 갈 수 없음 -> mid 값을 늘림
				s = mid + 1;
			}
		}
		return ans;
	}
	
	static boolean dijkstra(int limit) {
		long[] distance = new long[N + 1];
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[1] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.d, o2.d));
		pq.add(new Pair(1, 0, 0));
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.cur] < pair.d) continue;
			if (pair.cur == N) return true;
			for (int i = 0; i < graph[pair.cur].size(); i++) {
				int[] nxtPair = graph[pair.cur].get(i);
				int nxt = nxtPair[0];
				int nxtT = nxtPair[1];
				int nxtS = nxtPair[2];
				/*
				 * 최단 거리 + 총합 T이하로 이동해야 함
				 * 불편도는 최대 limit 이하로 만들어줘야 함 -> 불편도를 조정하면 시간이 바뀜
				 * */
				if (nxtS > limit) { // 상한치보다 크면 조정
					nxtT += nxtS - limit;
					nxtS = limit;
				}
				long nxtD = pair.d + nxtT; // 다음 노드까지 이동 시 걸린 총시간
				if (nxtD <= T && nxtD < distance[nxt]) {
					distance[nxt] = nxtD;
					pq.add(new Pair(nxt, nxtD, nxtS));
				}
			}
		}
		return false;
	}
	
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int es = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			// 양방향 간선 연결
			graph[u].add(new int[] {v, t, s});
			graph[v].add(new int[] {u, t, s});
			es = Math.max(es, s); // 불편도의 최댓값
		}
		
		int ans = parmetricSearch(0, es);
		System.out.println(ans);
 	}
}

class Pair {
	long d; // 거리
	int cur; // 현 위치
	int s; // 현재 불편도
	Pair(){};
	Pair(int cur, long d, int s) {
		this.cur = cur;
		this.d = d;
		this.s = s;
	}
}

