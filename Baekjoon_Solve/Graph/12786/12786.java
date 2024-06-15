// INHA SUIT (12786번)
import java.util.*;
import java.io.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N, K;
	static ArrayList<Integer>[] graph;
	static boolean[][][] visited;
	
	static int bfs() {
		Deque<Pair> deque = new LinkedList<>();
		deque.addFirst(new Pair(0, 1, 0));
		while (!deque.isEmpty()) {
			Pair pair = deque.pollFirst();
			int nxt = pair.cur + 1;
			if (nxt > N) continue;
			for (int nxtH : graph[nxt]) {
				if (nxtH == pair.h || nxtH == pair.h + 1 || nxtH == pair.h - 1 || nxtH == Math.min(pair.h * 2, 20)) { // O, A, B, C기능
					if (!visited[nxt][nxtH][pair.k]) {
						visited[nxt][nxtH][pair.k] = true;
						deque.addFirst(new Pair(nxt, nxtH, pair.k));
					}
				} else { // T 기능
					if (pair.k + 1 <= K && !visited[nxt][nxtH][pair.k + 1]) {
						visited[nxt][nxtH][pair.k + 1] = true;
						deque.addLast(new Pair(nxt, nxtH, pair.k + 1));
					}
				}
			}
		}
		
		for (int t = 0; t <= K; t++) {
			for (int h : graph[N]) {
				if (visited[N][h][t]) {
					// System.out.println(visited[N][h][t] + " " + h + " " + t);
					return t;
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		graph[0] = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		visited = new boolean[N + 1][21][K + 1];
		int ans = bfs();
		System.out.println(ans);
		
	}
}

class Pair {
	int cur, h, k; // 현위치, 높이
	Pair() {}
	Pair(int cur, int h, int k) {
		this.cur = cur;
		this.h = h;
		this.k = k;
	}
}
