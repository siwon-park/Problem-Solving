// 신아를 만나러 (6146번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = new int[] {-1, 0, 1, 0};
	static final int[] dx = new int[] {0, 1, 0, -1};
	static boolean[][] visited = new boolean[1001][1001];
	
	static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r + 500, c + 500, 0});
		visited[r + 500][c + 500] = true;
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int y = pair[0];
			int x = pair[1];
			if (y == 500 && x == 500) return pair[2];
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= 1001 || nx < 0 || nx >= 1001) continue;
				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					queue.add(new int[] {ny, nx, pair[2] + 1});
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int ai = Integer.parseInt(st.nextToken());
			int bi = Integer.parseInt(st.nextToken());
			visited[ai + 500][bi + 500] = true;
		}
		
		int ans = bfs(y, x);
		System.out.println(ans);
	}
}

