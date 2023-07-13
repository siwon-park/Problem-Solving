// 로봇 청소기 (14503번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, r, c, d;
	static int[][] board;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static int cleanUp(int y, int x, int w) {
		int cnt = 0;
		while (true) {
			// 현재 칸이 청소되지 않은 칸이면 청소한다
			if (board[y][x] == 0) {
				cnt += 1;
				board[y][x] = 2;
			}
			// 주변을 확인함
			boolean isDirty = false;
			for (int k = 0; k < 4; k++) {
				if (y + dy[k] < 0 || y + dy[k] >= N || x + dx[k] < 0 || x + dx[k] >= M) continue;
				if (board[y + dy[k]][x + dx[k]] == 0) isDirty = true;
			}
			
			int rw = w;
			if (!isDirty) { // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
				// 바라보는 방향의 역방향을 구함
				switch (w) {
				case 0:
					rw = 2;
					break;
				case 1:
					rw = 3;
					break;
				case 2:
					rw = 0;
					break;
				case 3:
					rw = 1;
					break;
				}
				// 후진 가능한지 확인 후 후진
				if (y + dy[rw] < 0 || y + dy[rw] >= N || x + dx[rw] < 0 || x + dx[rw] >= M) break;
				if (board[y + dy[rw]][x + dx[rw]] == 1) break;
				// 1칸 후진, 방향은 유지
				y += dy[rw];
				x += dx[rw];
			} else { // 빈 칸이 있는 경우
				// 반시계 방향 회전 90도
				w = (w + 3) % 4;
				// 앞 칸이 청소되지 않았으면 해당 칸으로 전진
				if (y + dy[w] < 0 || y + dy[w] >= N || x + dx[w] < 0 || x + dx[w] >= M) continue;
				if (board[y + dy[w]][x + dx[w]] == 0) {
					y += dy[w];
					x += dx[w];
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
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int ret = cleanUp(r, c, d);
		bw.write(ret + "");
		bw.flush();
		bw.close();
		br.close();
	}
}