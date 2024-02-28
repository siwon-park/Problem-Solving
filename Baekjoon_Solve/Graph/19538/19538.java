// 루머 (19538번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] nearBy, time;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	static void bfs(Queue<Pair> queue) {
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int cur = pair.node;
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i);
				if (visited[nxt]) continue; // 이미 루머를 믿고 있으면 무시
				nearBy[nxt] += 1; // 주변 사람으로부터 루머를 들음
				int size = graph[nxt].size(); // 주변의 크기
				int half = (size % 2 == 0) ? size / 2 : (size / 2) + 1;
				if (nearBy[nxt] >= half) { // 주변 절반 이상이 믿으면
					visited[nxt] = true; // 본인도 루머를 믿음
					time[nxt] = pair.t + 1;
					queue.add(new Pair(nxt, time[nxt]));
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append((visited[i]) ? time[i] : -1);
			sb.append(" ");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		nearBy = new int[N + 1];
		time = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int node = Integer.parseInt(st.nextToken());
				if (node == 0) break;
				graph[i].add(node);
			}
		}
		
		M = Integer.parseInt(br.readLine());
		Queue<Pair> queue = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int node = Integer.parseInt(st.nextToken());
			queue.add(new Pair(node, 0));
			visited[node] = true;
			nearBy[node] = graph[node].size();
			time[node] = 0;
		}
		
		bfs(queue);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int node, t;
	Pair(int node, int t) {
		this.node = node;
		this.t = t;
	}
}
