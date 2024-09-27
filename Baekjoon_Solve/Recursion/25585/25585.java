// 86 ─에이티식스─ 1 (25585번)
import java.util.*;
import java.io.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static final int[] dy = new int[] {-1, -1, 1, 1};
	static final int[] dx = new int[] {-1, 1, 1, -1};
	static int N, R, ans;
	static boolean[] visited;
	static boolean[][] check;
	static int[][] graph;
	static ArrayList<int[]> regions = new ArrayList<>();

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		check[r][c] = true;
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int y = pair[0];
			int x = pair[1];
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || check[ny][nx]) continue;
				check[ny][nx] = true;
				queue.add(new int[] {ny, nx});
			}
		}
	}
	
	
	static void backtrack(int y, int x, int d, int left) {
		if (left == 0) { // 레기온이 없으면 return
			ans = Math.min(ans, d);
			return;
		}
		
		for (int i = 0; i < R; i++) {
			int ny = regions.get(i)[0];
			int nx = regions.get(i)[1];
			int m = movable(y, x, ny, nx);
			if (!visited[i] && m != 0) {
				visited[i] = true;
				backtrack(ny, nx, d + m, left - 1);
				visited[i] = false;
			}
		}
	}
	
	
	/*
	 * 갈 수 있는지를 판별하는 함수
	 * */
	static int movable(int y, int x, int ty, int tx) {
		if (check[ty][tx]) return Math.max(Math.abs(y - ty), Math.abs(x - tx));
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		R = 0; // 레기온의 수
		ans = MAX;
		graph = new int[N][N];
		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) {
					regions.add(new int[] {i, j});
					R += 1;
				}
				else if (graph[i][j] == 2) {
					r = i;
					c = j;
				}
			}
		}
		
		check = new boolean[N][N];
		bfs(r, c);
		int left = R;
		visited = new boolean[R];
		backtrack(r, c, 0, left);
		if (ans == MAX) {
			System.out.println("Shorei");
		} else {
			System.out.println("Undertaker");
			System.out.println(ans);
		}
	}
}

