// 탈출 (3055번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int R, C;
	static Pair D, S;
	static String[] graph;
	static int[][] visited;
	static Queue<Pair> hogQueue, waterQueue;
	
	
	static void init() {
		hogQueue = new LinkedList<>();
		waterQueue = new LinkedList<>();
		visited = new int[R][C];
		graph = new String[R];
		for (int i = 0; i < R; i++) {
			Arrays.fill(visited[i], 2501);
		}
	}
	
	static void spread(Queue<Pair> queue) {
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			for (int k = 0; k < 4; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if (pair.t + 1 < visited[ny][nx] && graph[ny].charAt(nx) == '.') {
					visited[ny][nx] = pair.t + 1;
					queue.add(new Pair(ny, nx, pair.t + 1));
				}
			}
		}
	}
	
	static boolean bfs(Queue<Pair> queue) {
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			if (pair.y == D.y && pair.x == D.x) return true;
			for (int k = 0; k < 4; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if (pair.t + 1 < visited[ny][nx] && graph[ny].charAt(nx) != 'X') {
					visited[ny][nx] = pair.t + 1;
					queue.add(new Pair(ny, nx, pair.t + 1));
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
		init();
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			graph[i] = line;
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == 'D') {
					D = new Pair(i, j, 0);
				} else if (line.charAt(j) == 'S') {
					S = new Pair(i, j, 0);
					hogQueue.add(S);
					visited[i][j] = 0;
				} else if (line.charAt(j) == '*') {
					waterQueue.add(new Pair(i, j, 0));
					visited[i][j] = 0;
				}
			}
		}
		
		spread(waterQueue);
		
		boolean flag = bfs(hogQueue);
		String ans = (flag) ? (visited[D.y][D.x] + "") : "KAKTUS";
		
		bw.write(ans);
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int y, x, t;
	Pair() {}
	Pair(int y, int x, int t) {
		this.y = y;
		this.x = x;
		this.t = t;
	}
}