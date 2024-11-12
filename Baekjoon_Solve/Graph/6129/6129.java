// Obstacle Course (6129번)
import java.io.*;
import java.util.*;

public class Main {

	static final int MAX = Integer.MAX_VALUE;
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	
	static int N, sy, sx, ty, tx;
	static String[] graph;
	static int[][][] visited;
	
	static int bfs() {
		Deque<int[]> deque = new LinkedList<>();
		for (int i = 0; i < 4; i++) {
			deque.add(new int[] {0, sy, sx, i});			
			visited[i][sy][sx] = 0;
		}
		while (!deque.isEmpty()) {
			int[] pair = deque.poll();
			int curT = pair[0];
			int y = pair[1];
			int x = pair[2];
			int curK = pair[3];
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || graph[ny].charAt(nx) == 'x') continue;
				if (curK == k && curT < visited[k][ny][nx]) {
					visited[k][ny][nx] = curT;
					deque.addFirst(new int[] {curT, ny, nx, k});
				} else if (curK != k && curT + 1 < visited[k][ny][nx]) {
					visited[k][ny][nx] = curT + 1;
					deque.addLast(new int[] {curT + 1, ny, nx, k});
				}
			}
		}
		int min = MAX;
		for (int k = 0; k < 4; k++) min = Math.min(min, visited[k][ty][tx]);
		return min;
	}
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		graph = new String[N];
		visited = new int[4][N][N];
		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine();
			for (int j = 0; j < N; j++) {
				if (graph[i].charAt(j) == 'A') {
					sy = i;
					sx = j;
				} else if (graph[i].charAt(j) == 'B') {
					ty = i;
					tx = j;
				}
			}
			for (int k = 0; k < 4; k++) {
				Arrays.fill(visited[k][i], MAX);
			}
		}
		
		System.out.println(bfs());

	}
}

