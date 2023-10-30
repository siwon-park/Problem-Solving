// 방탈출 (23352번)
import java.io.*;
import java.util.*;

public class Main {

	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N, M;
	static int[][] graph;
	
	static int[] bfs(int r, int c) {
		int l = 1;
		int maxSum = graph[r][c] * 2; // 길이가 1인 경우 = 시작점과 끝점이 같은 경우
		boolean[][] visited = new boolean[N][M];
		visited[r][c] = true;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(r, c, 1));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			if (pair.l > l) {
				l = pair.l;
				maxSum = graph[r][c] + graph[pair.y][pair.x];
			} else if (pair.l == l) {
				maxSum = Math.max(maxSum, graph[r][c] + graph[pair.y][pair.x]);
			}
			for (int k = 0; k < 4; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || graph[ny][nx] == 0) continue;
				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					queue.add(new Pair(ny, nx, pair.l + 1));
				}
			}
		}
		return new int[] {l, maxSum};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxL = 0; // 가장 긴 비밀번호의 길이
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) continue;
				int[] ret = bfs(i, j);
				if (ret[0] > maxL) {
					maxL = ret[0];
					ans = ret[1];
				} else if (ret[0] == maxL) {
					ans = Math.max(ans, ret[1]);
				}
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int y, x, l; 
	Pair(){}
	Pair(int y, int x, int l) {
		this.y = y;
		this.x = x;
		this.l = l;
	}
}