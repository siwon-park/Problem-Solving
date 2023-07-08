// 아맞다우산 (17244번)
import java.io.*;
import java.util.*;

public class Main {
	
	
	static int N, M, MAX; // 열, 행, 비트 최댓값
	static int sy, sx, ey, ex;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Character[][] graph; // 격자판
	static boolean[][][] visited; // 방문 배열
	
	static int bfs(int sy, int sx) {
		Queue<Pair> queue = new LinkedList<>();
		visited[sy][sx][0] = true;
		queue.add(new Pair(sy, sx, 0, 0));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			if (pair.bit == MAX && pair.y == ey && pair.x == ex) return pair.cnt;
			for (int k = 0; k < 4; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (graph[ny][nx] != '#') { // 벽이 아닐 경우에만 다음 위치로 방문
					if (graph[ny][nx] == '.' && !visited[ny][nx][pair.bit]) {
						visited[ny][nx][pair.bit] = true;
						queue.add(new Pair(ny, nx, pair.cnt + 1, pair.bit));
					} else if ('A' <= graph[ny][nx] && graph[ny][nx] <= 'Z') {
						int nxtBit = pair.bit | (1 << (graph[ny][nx] - 65));
						if (!visited[ny][nx][nxtBit]) {
							visited[ny][nx][nxtBit] = true;
							queue.add(new Pair(ny, nx, pair.cnt + 1, nxtBit));
						}
					}
					
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		graph = new Character[N][M];
		int x_cnt = 0;
		int sy = 0;
		int sx = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = line.charAt(j);
				if (graph[i][j] == 'S') { // 출발 지점
					sy = i;
					sx = j;
					graph[i][j] = '.';
				} else if (graph[i][j] == 'E') {
					ey = i;
					ex = j;
					graph[i][j] = '.';
				} else if (graph[i][j] == 'X') {
					graph[i][j] = (char) ('A' + x_cnt);
					x_cnt += 1;
				}
			}
		}
		
		MAX = (1 << x_cnt) - 1;
		visited = new boolean[N][M][MAX + 1];
		int ret = bfs(sy, sx);
		bw.write(ret + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int y;
	int x;
	int cnt;
	int bit;
	
	Pair(int y, int x, int cnt, int bit) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.bit = bit;
	}
}