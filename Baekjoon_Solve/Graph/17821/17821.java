// Zoo (17821번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int[] dy = new int[] {-1, 0, 1, 0};
	static int[] dx = new int[] {0, 1, 0, -1};
	static int R, C;
	static int[][] graph;
	static int[][] visited;
	
	static int bfs() {
		Deque<int[]> deque = new LinkedList<>();
		deque.add(new int[] {0, 0, graph[0][0]}); // 위치, 동물 종류
		visited[0][0] = 1;
		int ans = 1;
		while (!deque.isEmpty()) {
			int[] pair = deque.pollFirst();
			int y = pair[0];
			int x = pair[1];
			int ani = pair[2];
			ans = Math.max(ans, visited[y][x]);
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C || graph[ny][nx] == 0 || visited[ny][nx] != MAX) continue;
				if (graph[ny][nx] != ani) { // 동물 종류가 다를 경우
					visited[ny][nx] = visited[y][x] + 1;
					deque.addLast(new int[] {ny, nx, graph[ny][nx]});
				} else {
					visited[ny][nx] = visited[y][x];
					deque.addFirst(new int[] {ny, nx, ani});					
				}
			}
		}
		
		return ans;
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
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == 'T') {
					graph[i][j] = 1;
				} else if (line.charAt(j) == 'B') {
					graph[i][j] = 2;
				}
				visited[i][j] = MAX;
			}
		}
		
		int ans = bfs();
		System.out.println(ans);
	}
}

