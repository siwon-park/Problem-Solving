// 불 (5427번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 1_000_001;
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int h, w;
	static Queue<int[]> sQueue, fireQueue;
	static String[] graph = new String[1000];
	static int[][] visited = new int[1000][1000];
	
	static void init(int h, int w) {
		sQueue = new LinkedList<>();
		fireQueue = new LinkedList<>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				visited[i][j] = MAX;
			}
		}
	}
	
	static void bfs1() {
		while (!fireQueue.isEmpty()) {
			int[] pair = fireQueue.poll();
			int y = pair[0];
			int x = pair[1];
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
				if (graph[ny].charAt(nx) != '#' && visited[y][x] + 1 < visited[ny][nx]) {
					visited[ny][nx] = visited[y][x] + 1;
					fireQueue.add(new int[] {ny, nx});
				}
			}
		}
	}
	
	static int bfs2() {
		int[] tmp = sQueue.poll();
		visited[tmp[0]][tmp[1]] = 0;
		sQueue.add(tmp);
		while (!sQueue.isEmpty()) {
			int[] pair = sQueue.poll();
			int y = pair[0];
			int x = pair[1];
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= h || nx < 0 || nx >= w) { // 범위를 벗어날 수 있으면 탈출 가능
					return visited[y][x] + 1;
				}
				if (graph[ny].charAt(nx) == '.' && visited[y][x] + 1 < visited[ny][nx]) {
					visited[ny][nx] = visited[y][x] + 1;
					sQueue.add(new int[] {ny, nx});
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			init(h, w);
			
			for (int i = 0; i < h; i++) {
				graph[i] = br.readLine();
				for (int j = 0; j < w; j++) {
					if (graph[i].charAt(j) == '*') {
						fireQueue.add(new int[] {i, j});
						visited[i][j] = 0;
					} else if (graph[i].charAt(j) == '@') {
						sQueue.add(new int[] {i, j});
					}
				}
			}
			
			bfs1(); // 불을 퍼뜨림
			int ans = bfs2(); // 상근이의 탈출 여부 확인
			if (ans == -1) {
				bw.write("IMPOSSIBLE\n");
			} else {
				bw.write(ans + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
