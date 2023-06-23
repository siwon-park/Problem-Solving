// 내 왼손에는 흑염룡이 잠들어 있다 (13016번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, oneToFar, farToFar; // 국가의 수, 1에서 가장 먼 노드1, 가장 먼 노드1에서 가장 먼 노드2
	static int[] dist1, dist2, dist3; // 거리 테이블
	static boolean[] visited; // 방문 배열
	static ArrayList<ArrayList<int[]>> graph; // 트리
	
	/*
	 * 특정 노드에서 출발해서 다른 노드까지 가는데 걸리는 거리 테이블을 구하는 dfs
	 * cur: 현재 노드, d: 현재 누적 거리, dist: 거리 테이블
	 * */
	static void dfs(int cur, int d, int[] dist) {
		dist[cur] = d;
		visited[cur] = true;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i)[0];
			int c = graph.get(cur).get(i)[1];
			if (!visited[nxt]) dfs(nxt, d + c, dist);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
		
		StringTokenizer st;
		int from, to, len;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());
			graph.get(from).add(new int[] {to, len});
			graph.get(to).add(new int[] {from, len});
		}
		
		/*
		 * 이 문제의 핵심은 결국 가장 긴 트리의 지름을 찾는 것임
		 * */
		oneToFar = 0;
		farToFar = 0;
		dist1 = new int[N + 1]; // 1에서 출발했을 때의 거리 테이블
		dist2 = new int[N + 1]; // 1에서 출발했을 때의 가장 먼 노드1에서의 거리 테이블
		dist3 = new int[N + 1]; // 가장 먼 노드1에서 출발했을 때 가장 먼 노드2의 거리 테이블
		
		// 1에서 출발했을 때 가장 먼 거리에 있는 노드1를 구함
		visited = new boolean[N + 1];
		dfs(1, 0, dist1);
		int d = -1;
		for (int i = 1; i < N + 1; i++) {
			if (dist1[i] > d) {
				d = dist1[i];
				oneToFar = i;
			}
		}
		
		// 가장 먼 노드1에서 가장 먼 노드2까지의 거리를 구함
		visited = new boolean[N + 1];
		dfs(oneToFar, 0, dist2);
		d = -1;
		for (int i = 1; i < N + 1; i++) {
			if (dist2[i] > d) {
				d = dist2[i];
				farToFar = i;
			}
		}
		
		// 가장 먼 노드2에서 나머지 노드까지의 거리 테이블을 구함
		visited = new boolean[N + 1];
		dfs(farToFar, 0, dist3);
		
		// 각 여행 출발지 i에서 출발했을 때 가장 먼 거리 D[i]는 dist2[i]와 dist3[i] 중 큰 것임
		for (int i = 1; i < N + 1; i++) {
			bw.write(Math.max(dist2[i], dist3[i]) + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}