// Skridskor (26887번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static final int[] dy = new int[] {-1, 0, 1, 0};
	static final int[] dx = new int[] {0, 1, 0, -1};
	static final int[] rotate1 = new int[] {0, 2};
	static final int[] rotate2 = new int[] {1, 3};
	static int R, C;
	static int[][] graph;
	static int[][][] visited;
	
	static int bfs() {
		int ans = MAX;
		Deque<int[]> deque = new LinkedList<>();
		deque.add(new int[] {0, 0, 1}); // 현재 위치, 현재 방향
		visited[0][0][1] = 0;
		while (!deque.isEmpty()) {
			int[] pair = deque.poll();
			int y = pair[0];
			int x = pair[1];
 			int z = pair[2];
 			if (x == C) {
 				ans = Math.min(ans, visited[y][x][z]);
 				continue;
 			}
			int ny = y + dy[z];
			int nx = x + dx[z];
			if (ny < 0 || ny >= R || nx < 0 || visited[ny][nx][z] != MAX) continue; // 범위를 벗어나면 X
			if (graph[ny][nx] == 0) {
				visited[ny][nx][z] = visited[y][x][z];
				deque.addFirst(new int[] {ny, nx, z});
			} else { // 다음 칸이 벽이면 방향을 바꿈
				int[] rotate = rotate1;
				if (z == 0 || z == 2) rotate = rotate2;
				for (int k : rotate) {
					ny = y + dy[k];
					nx = x + dx[k];
					if (ny < 0 || ny >= R || nx < 0 || visited[ny][nx][k] != MAX || graph[ny][nx] == 1) continue;
					visited[ny][nx][k] = visited[y][x][z] + 1;
					deque.addLast(new int[] {ny, nx, k});
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

		graph = new int[R][C + 1];
		visited = new int[R][C + 1][4];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == '.') {
					graph[i][j] = 0;
				} else if (line.charAt(j) == '#') {
					graph[i][j] = 1;
				}
			}
			for (int j = 0; j <= C; j++) Arrays.fill(visited[i][j], MAX);
 		}
		
		System.out.println(bfs());
		
	}
}
