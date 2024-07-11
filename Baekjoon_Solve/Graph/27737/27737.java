// 버섯 농장 (27737번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N, M, K;
	static int[][] graph;
	static boolean[][] visited;
	
	static int bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 1;
		queue.add(new int[] {y, x});
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int curY = pair[0];
			int curX = pair[1];
			for (int k = 0; k < 4; k++) {
				int ny = curY + dy[k];
				int nx = curX + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || graph[ny][nx] == 1) continue;
				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					queue.add(new int[] {ny, nx});
					cnt += 1;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = false;
		int mushroom = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && graph[i][j] == 0) {
					int cnt = bfs(i, j);
					if (cnt % K == 0) { // 나누어 떨어지면 몫만큼 증가
						mushroom += (cnt / K);
					} else { // 몫 + 1
						mushroom += (cnt / K) + 1;
					}
				}
			}
		}
		
		if (M >= mushroom && mushroom >= 1) {
			bw.write("POSSIBLE" + "\n");
			bw.write((M - mushroom) + "");
		} else {
			bw.write("IMPOSSIBLE");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

