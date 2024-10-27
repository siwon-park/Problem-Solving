// 곰곰이의 식단 관리 2 (26076번)
import java.io.*;
import java.util.*;

public class Main {

	static final int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
	static final int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};
	static int N, M;
	static int[][] graph;
	
	/*
	 * 벽에서 벽으로 이동하는 0-1 BFS
	 * 이동할 수 있는 공간이면 벽을 놓고 이동
	 * */
	static int bfs() {
		Deque<int[]> deque = new LinkedList<>();
		boolean[][] visited = new boolean[N + 2][M + 2];
		deque.add(new int[] {0, M + 1, 0}); // y, x, 놓은 장애물 수
		visited[0][M + 1] = true;
		while (!deque.isEmpty()) {
			int[] pair = deque.poll();
			int y = pair[0];
			int x = pair[1];
			int d = pair[2];
			if (y == N + 1 && x == 0) return d;
			for (int k = 0; k < 8; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny > N + 1 || nx < 0 || nx > M + 1 || visited[ny][nx]) continue;
				if (graph[ny][nx] == 0) { // 이동할 수 있는 공간이면 벽을 놓고 이동
					visited[ny][nx] = true;
					deque.addLast(new int[] {ny, nx, d + 1});
				} else if (graph[ny][nx] == 1) { // 벽이면 그대로 이동
					visited[ny][nx] = true;
					deque.addFirst(new int[] {ny, nx, d});
				}
			}
		}
		
		return 2;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 2][M + 2];
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(graph[i], 1); // 모두 벽으로 채움
			if (0 < i && i < N + 1) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < M + 1; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// 출발지와 도착지는 2로 만들어서 벽을 놓지 못하게 함
		graph[1][1] = 2;
		graph[N][M] = 2;
		
		// 좌상단, 우하단의 3칸들을 이동할 수 있는 공간으로 변경
		graph[0][0] = 0;
		graph[0][1] = 0;
		graph[1][0] = 0;
		graph[N + 1][M + 1] = 0;
		graph[N][M + 1] = 0;
		graph[N + 1][M] = 0;
		
		System.out.println(bfs());
 	}
}

