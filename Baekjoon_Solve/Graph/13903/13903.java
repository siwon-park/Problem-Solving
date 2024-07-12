// 출근 (13903번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 1_000_555;
	static int R, C, N, ans;
	static int[] dy, dx;
	static int[][] graph;
	static int[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	
	static int bfs() {
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int y = pair[0];
			int x = pair[1];
			if (y == R - 1) return visited[y][x];
			for (int k = 0; k < N; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C || graph[ny][nx] == 0) continue;
				if (pair[2] + 1 < visited[ny][nx]) {
					visited[ny][nx] = pair[2] + 1;
					queue.add(new int[] {ny, nx, visited[ny][nx]});
				}
			}
		}
		return MAX;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new int[R][C];
		visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = MAX;
			}
		}
		
		N = Integer.parseInt(br.readLine());
		dy = new int[N];
		dx = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dy[i] = r;
			dx[i] = c;
		}
		
		for (int i = 0; i < C; i++) {
			if (graph[0][i] == 1) {
				queue.add(new int[] {0, i, 0});
				visited[0][i] = 0;
			}
		}
		ans = bfs();
		System.out.println((ans == MAX) ? -1 : ans);
	}
}

