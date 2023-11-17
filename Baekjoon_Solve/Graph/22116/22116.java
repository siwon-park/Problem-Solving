// 창영이와 퇴근 (22116번)
import java.io.*;
import java.util.*;

public class Main {

	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	
	static boolean bfs(int lm) {
		init();
		Queue<int[]> queue = new LinkedList<>();
		visited[1][1] = true;
		queue.add(new int[] {1, 1});
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int y = pair[0];
			int x = pair[1];
			if (y == N && x == N) return true;
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny <= 0 || ny > N || nx <= 0 || nx > N || visited[ny][nx]) continue;
				if (Math.abs(graph[ny][nx] - graph[y][x]) <= lm) {
					visited[ny][nx] = true;
					queue.add(new int[] {ny, nx});
				}
			}
		}
		
		return false;
	}
	
	static void init() {
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(visited[i], false);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		int _min = Integer.MAX_VALUE;
		int _max = Integer.MIN_VALUE;
		graph = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				_min = Math.min(_min, graph[i][j]);
				_max = Math.max(_max, graph[i][j]);
			}
		}
		
		visited = new boolean[N + 1][N + 1];
		int s = 0;
		int e = _max - _min; // 최대 차이
		int ans = e;
		while (s <= e) {
			int mid = (s + e) >> 1;
			boolean flag = bfs(mid);
			if (flag) {
				e = mid - 1;
				ans = mid;
			} else {
				s = mid + 1;
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
