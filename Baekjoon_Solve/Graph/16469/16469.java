// 소년 점프 (16469번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 100_000;
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int R, C;
	static int[][][] visited;
	static String[] graph;
	
	static int[] bfs(Queue<Pair> queue) {
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			for (int k = 0; k < 4; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if (pair.d + 1 < visited[ny][nx][pair.z] && graph[ny].charAt(nx) == '0') {
					visited[ny][nx][pair.z] = pair.d + 1;
					queue.add(new Pair(ny, nx, pair.z, pair.d + 1));
				}
			}
		}
		
		int min = MAX;
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int v = Math.max(visited[i][j][0], Math.max(visited[i][j][1], visited[i][j][2]));
				if (v < min) {
					min = v;
					cnt = 1;
				} else if (v == min) {
					cnt += 1;
				}
			}
		}
		
		if (min == MAX) return new int[] {-1, -1};
		return new int[] {min, cnt};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		graph = new String[R];
		visited = new int[R][C][3];
		for (int i = 0; i < R; i++) {
			graph[i] = br.readLine();
			for (int j = 0; j < C; j++) {
				visited[i][j][0] = MAX;
				visited[i][j][1] = MAX;
				visited[i][j][2] = MAX;				
			}
		}
		
		Queue<Pair> queue = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;			
			queue.add(new Pair(r, c, i, 0));
			visited[r][c][i] = 0;
		}
		
		int[] ret = bfs(queue);
		if (ret[0] == -1) {
			System.out.println(-1);
		} else {
			System.out.println(ret[0]);
			System.out.println(ret[1]);
		}
		
		
	}
}

class Pair {
	int y, x, z, d;
	Pair() {}
	Pair(int y, int x, int z, int d) {
		this.y = y;
		this.x = x;
		this.z = z;
		this.d = d;
	}
}
