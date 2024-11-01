// GULIVER (3140번)
import java.io.*;
import java.util.*;

public class Main {

	static final int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
	static final int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};
	static int N, M;
	static int[][] graph;

	static int bfs() {
		boolean[][] visited = new boolean[N][M + 2];
		Deque<int[]> deque = new LinkedList<>();
		deque.add(new int[] {0, 1, 0}); // 비용, y, x
		visited[1][0] = true;
		while (!deque.isEmpty()) { // 1, M + 1까지 최소 비용
			int[] pair = deque.pollFirst();
			int d = pair[0];
			int y = pair[1];
			int x = pair[2];
			if (y == 1 && x == M + 1) {
				return d;
			}
			for (int k = 0; k < 8; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny <= 0 || ny >= N - 1 || nx < 0 || nx > M + 1 || visited[ny][nx]) continue;
				visited[ny][nx] = true;
				if (graph[ny][nx] == 1) { // 벽이면 덱의 맨 앞에 삽입
					deque.addFirst(new int[] {d, ny, nx});
				} else { // 빈 공간이면 덱의 맨 뒤에 삽입
					deque.addLast(new int[] {d + 1, ny, nx});
				}
			}
			
		}
		return -1;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M + 2]; // 가로를 양쪽으로 1칸씩 늘려줌
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				if (line.charAt(j - 1) == '.') {
					graph[i][j] = 0;
				} else {
					graph[i][j] = 1;
				}
			}
			if (i == 0 || i == N - 1) continue;
			graph[i][0] = 1;
			graph[i][M + 1] = 1;
		}
		
		System.out.println(bfs());	
 	}
}

