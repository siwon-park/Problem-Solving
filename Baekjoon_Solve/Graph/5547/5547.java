// 일루미네이션 (5547번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int W, H, ans; // 너비, 높이, 답
	static int[][] graph; // 격자판
	// y가 짝수일 때 이동좌표
	static int[] evenDY = {-1, -1, 0, 1, 1, 0};
	static int[] evenDX = {-1, 0, 1, 0, -1, -1};
	
	// y가 홀수일 때 이동좌표
	static int[] oddDY = {-1, -1, 0, 1, 1, 0};
	static int[] oddDX = {0, 1, 1, 1, 0, -1};
	
	/*
	 * 그래프를 채우는 함수 -> 바깥에 있는 부분만 -1로 채움
	 * */
	static void fillGraph() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		boolean[][] visited = new boolean[H + 2][W + 2];
		visited[0][0] = true;
		int[] dy, dx;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int y = cur[0];
			int x = cur[1];
			if (y % 2 == 0) {
				dy = evenDY;
				dx = evenDX;
			} else {
				dy = oddDY;
				dx = oddDX;
			}
			int ny, nx;
			for (int k = 0; k < 6; k++) {
				ny = y + dy[k];
				nx = x + dx[k];
				if (ny < 0 || ny >= H + 2 || nx < 0 || nx >= W + 2) continue;
				if (!visited[ny][nx] && graph[ny][nx] == 0) {
					graph[ny][nx] = -1;
					visited[ny][nx] = true;
					queue.add(new int[] {ny, nx});
				}
			}
		}
	}
	
	static void calculateDiameter(int y, int x) {
		int ny, nx;
		int[] dy, dx;
		if (y % 2 == 0) {
			dy = evenDY;
			dx = evenDX;
		} else {
			dy = oddDY;
			dx = oddDX;
		}
		for (int k = 0; k < 6; k++) {
			ny = y + dy[k];
			nx = x + dx[k];
			if (ny < 0 || ny >= H + 2 || nx < 0 || nx >= W + 2) continue;
			if (graph[ny][nx] == 1) ans += 1;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		graph = new int[H + 2][W + 2];
		for (int i = 1; i < H + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < W + 1; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		fillGraph();
		
		ans = 0;
		for (int i = 0; i < H + 2; i++) {
			for (int j = 0; j < W + 2; j++) {
				if (graph[i][j] == -1) calculateDiameter(i, j);
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}