// 나는 북극곰입니다 (31932번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N, M, U, V, D, T;
	static ArrayList<int[]>[] graph;
	static int[] distance;
	
	static int parametricSearch(int et) {
		int s = 0;
		int e = et;
		int ans = -1;
		while (s <= e) {
			int mid = (s + e) >> 1;
			boolean flag = dijkstra(mid);
			if (flag) {
				s = mid + 1;
				ans = mid;
			} else {
				e = mid - 1;
			}
		}
		
		return ans;
	}
	
	static boolean dijkstra(int mid) {
		Arrays.fill(distance, MAX);
		distance[1] = mid;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
		pq.add(new int[] {mid, 1}); // 현재 시간, 현위치
		while (!pq.isEmpty()) {
			int[] pair = pq.poll();
			int k = pair[0];
			int cur = pair[1];
			if (distance[cur] < k) continue;
			if (cur == N) return true;
			for (int i = 0; i < graph[cur].size(); i++) {
				int[] nxtPair = graph[cur].get(i);
				int nxt = nxtPair[0];
				int d = nxtPair[1];
				int t = nxtPair[2];
				if (k + d <= t && k + d < distance[nxt]) {
					distance[nxt] = k + d;
					pq.add(new int[] {k + d, nxt});
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
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		distance = new int[N + 1];
		int maxT = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			U = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			graph[U].add(new int[] {V, D, T});
			graph[V].add(new int[] {U, D, T});
			maxT = Math.max(maxT, T);
		}
		
		System.out.println(parametricSearch(maxT));
 	}
}
