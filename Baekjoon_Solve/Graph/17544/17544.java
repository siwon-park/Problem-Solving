// Canyon Crossing (17544번)
import java.io.*;
import java.util.*;

public class Main {

	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int R, C, K;
	static int[][] graph;

	static int binarySearch(int _min, int _max) {
		int s = _min;
		int e = _max;
		int ans = e;
		while (s <= e) {
			int mid = (s + e) >> 1;
			boolean flag = bfs(mid);
			if (flag) {
				s = mid + 1;
				ans = mid;
			} else {
				e = mid - 1;
			}
		}
		return ans;
	}
	
	static boolean bfs(int opt) {
		boolean[][] visited = new boolean[R][C];
		Deque<int[]> deque = new LinkedList<>();
		for (int i = 0; i < C; i++) {
			if (graph[R - 1][i] < opt) {
				deque.addLast(new int[] {1, R - 1, i});
			} else {				
				deque.addFirst(new int[] {0, R - 1, i});				
			}
			visited[R - 1][i] = true;
		}
		
		while (!deque.isEmpty()) {
			int[] pair = deque.pollFirst();
			int d = pair[0];
			int y = pair[1];
			int x = pair[2];
			if (y == 0) return true;
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if (graph[ny][nx] < opt) {
					if (!visited[ny][nx] && d + 1 <= K) {
						visited[ny][nx] = true;
						deque.addLast(new int[] {d + 1, ny, nx});
					}
				} else {
					if (!visited[ny][nx] && d <= K) {
						visited[ny][nx] = true;
						deque.addFirst(new int[] {d, ny, nx});
					}
				}
			}	
		}
		return false;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new int[R][C];
		int minH = Integer.MAX_VALUE;
		int maxH = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, graph[i][j]);
				maxH = Math.max(maxH, graph[i][j]);
			}
		}
		
		System.out.println(binarySearch(minH, maxH));
		
 	}
}
