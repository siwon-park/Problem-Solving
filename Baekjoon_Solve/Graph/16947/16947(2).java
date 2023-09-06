// 서울 지하철 2호선 (16947번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N, cycle;
	static boolean[] visited, isCycle;
	static int[] distance;
	static ArrayList<ArrayList<Integer>> graph;
	static Deque<int[]> deque = new LinkedList<>();
	
	static boolean dfs(int cur, int last) {
		visited[cur] = true;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i);
			if (!visited[nxt]) {
				boolean flag = dfs(nxt, cur);
				if (flag) { // 사이클 노드를 찾았음
					if (cycle == cur) { // 현재 노드가 사이클 노드면 
						isCycle[cur] = true;
						distance[cur] = 0;
						deque.addFirst(new int[] {cur, 0});
						return false; // false를 반환
					} else {
						isCycle[cur] = true;
						distance[cur] = 0;
						deque.addFirst(new int[] {cur, 0});
						return true;
					}
				}
			} else if (visited[nxt] && last != nxt) { // 다음 노드가 사이클 노드 -> true 반환하며 복귀
				isCycle[cur] = true;
				distance[cur] = 0;
				deque.addFirst(new int[] {cur, 0});
				cycle = nxt; // 다음 노드가 사이클 노드의 출발점으로 기록
				return true;
			}
		}
		return false;
	}
	
	static void bfs() {
		while (!deque.isEmpty()) {
			int[] pair = deque.poll();
			int cur = pair[0];
			int d = pair[1];
			for (int i = 0; i < graph.get(cur).size(); i++) {
				int nxt = graph.get(cur).get(i);
				if (distance[nxt] == INF && isCycle[nxt]) {
					distance[nxt] = 0;
					deque.addFirst(new int[] {nxt, 0});
				} else if (!isCycle[nxt] && d + 1 < distance[nxt]) {
					distance[nxt] = d + 1;
					deque.addLast(new int[] {nxt, d + 1});
				}
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		isCycle = new boolean[N + 1];
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
		
		int a, b;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		distance = new int[N + 1];
		Arrays.fill(distance, INF);
		dfs(1, 0);
		bfs();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(distance[i]);
			sb.append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}