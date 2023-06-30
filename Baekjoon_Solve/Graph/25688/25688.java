// 빠른 무작위 숫자 탐색 (25688번)
import java.io.*;
import java.util.*;

public class Main {

	static final int MAX = (1 << 6) - 1;
	static int r, c;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] board;
	
	static int bfs() {
		boolean[][][] visited = new boolean[5][5][MAX + 1];
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(r, c, 0, 0)); // 행, 열, 비트, 횟수
		visited[r][c][0] = true;
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			if (pair.k == MAX) return pair.cnt; // 모든 숫자를 다 밟았으면
			for (int i = 0; i < 4; i++) {
				int nr = pair.r + dy[i];
				int nc = pair.c + dx[i];
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
				if (board[nr][nc] >= 0) {
					int nk = pair.k; // board[nr][nc] == 0이면 이동만 함
					if (board[nr][nc] > 0) nk |= (1 << board[nr][nc] - 1); 
					if (!visited[nr][nc][nk]) {
						visited[nr][nc][nk] = true;
						queue.add(new Pair(nr, nc, nk, pair.cnt + 1));
					}
				}
			}
		}
		
		return -1; // 방문 불가능
	}
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		board = new int[5][5];
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		bw.write(bfs() + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair {
	int r;
	int c;
	int k;
	int cnt;
	
	Pair(int r, int c, int k, int cnt) {
		this.r = r;
		this.c = c;
		this.k = k;
		this.cnt = cnt;
	}
}