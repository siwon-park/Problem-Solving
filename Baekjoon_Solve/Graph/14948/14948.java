//군대탈출하기 (14948번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N, M, _min, _max;
	static int[][] graph;
	
	/*
	 * limit(상한치)이하의 블록만 지날 수 있는 bfs 함수
	 * */
	static boolean bfs(int limit) {
		if (graph[0][0] > limit) return false;
		boolean[][][] visited = new boolean[N][M][2];
		visited[0][0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 0}); // y, x, 특수 장비 사용 여부
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int y = pair[0];
			int x = pair[1];
			int z = pair[2];
			if (y == N - 1 && x == M - 1) return true;
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (graph[ny][nx] <= limit && !visited[ny][nx][z]) {
					visited[ny][nx][z] = true;
					queue.add(new int[] {ny, nx, z});
				}
				if (z == 0) { // 일단 특수 장비를 사용하지 않았으면 같은 방향으로 한 번 더 이동 가능하면 이동함
					int nny = ny + dy[k];
					int nnx = nx + dx[k];
					if (nny < 0 || nny >= N || nnx < 0 || nnx >= M) continue;
					// 중요! 이 때 한 칸 건너뛰어 다음에 도달하는 곳도 역시 상한선 이하여야 한다. 
					if (graph[nny][nnx] <= limit && !visited[nny][nnx][1]) {
						visited[nny][nnx][1] = true;
						queue.add(new int[] {nny, nnx, 1});
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
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		_min = Integer.MAX_VALUE;
		_max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				_min = Math.min(_min, graph[i][j]);
				_max = Math.max(_max, graph[i][j]);
			}
		}
		
		int s = _min;
		int e = _max;
		int ans = e;
		while (s <= e) {
			int mid = (s + e) >> 1;
			boolean flag = bfs(mid); // 상한선을 mid로 했을 때 갈 수 있는지 확인
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