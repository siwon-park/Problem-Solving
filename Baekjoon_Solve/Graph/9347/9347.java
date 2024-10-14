// 울타리 (9347번)
import java.io.*;
import java.util.*;

public class Main {

	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	
	static int T, R, C;
	static int[][] graph;
	static Deque<int[]> deque;
	
	static int[] bfs_0_1() {
		deque.clear();
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
					if (graph[i][j] == 0) {
						deque.addFirst(new int[] {0, i, j});
					} else {
						deque.addLast(new int[] {1, i, j});
					}
					visited[i][j] = true;
				}
			}
		}
		
		int maxD = 0;
		int cnt = 0;
		while (!deque.isEmpty()) {
			int[] pair = deque.pollFirst();
			int d = pair[0];
			int y = pair[1];
			int x = pair[2];
			if (graph[y][x] == 0) {
				if (d > maxD) {
					cnt = 1;
					maxD = d;
				} else if (d == maxD) {
					cnt++;
				}
			}
			
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if (graph[ny][nx] == 0 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					deque.addFirst(new int[] {d, ny, nx});
				} else if (graph[ny][nx] == 1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					deque.addLast(new int[] {d + 1, ny, nx});
				}
			}	
		}
		
		return new int[] {maxD, cnt};
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		deque = new LinkedList<>();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			graph = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] ret = bfs_0_1();
			bw.write(ret[0] + " " + ret[1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
 	}
}

