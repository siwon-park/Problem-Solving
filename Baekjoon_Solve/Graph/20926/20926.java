// 얼음 미로 (20926번)
import java.io.*;
import java.util.*;

public class Main {

	static final int MAX = 10_000_555;
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	
	static int W, H, sy, sx, ey, ex;
	static String[] graph;
	static int[][][] distance;
	
	static int dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
		for (int k = 0; k < 4; k++) {
			pq.add(new int[] {0, sy, sx, k});
			distance[k][sy][sx] = 0;
		}
		
		while (!pq.isEmpty()) {
			int[] pair = pq.poll();
			int d = pair[0];
			int y = pair[1];
			int x = pair[2];
			int k = pair[3];
			if (distance[k][y][x] < d) continue;
			if (y == ey && x == ex) return distance[k][y][x];
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
			char nxt = graph[ny].charAt(nx);
			if (nxt == 'R') { // 다음 위치가 돌이면
				for (int nk = 0; nk < 4; nk++) {
					if (nk == k) continue; // 같은 방향이면 돌이니까 무시
					ny = y + dy[nk];
					nx = x + dx[nk];
					if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
					nxt = graph[ny].charAt(nx);
					if ('0' <= nxt && nxt <= '9') {
						int nd = d + (nxt - '0');
						if (nd < distance[nk][ny][nx]) {
							distance[nk][ny][nx] = nd;
							pq.add(new int[] {nd, ny, nx, nk});
						}
					} else if (nxt == 'E') {
						if (d < distance[nk][ny][nx]) {
							distance[nk][ny][nx] = d;
							pq.add(new int[] {d, ny, nx, nk});
						}
					}
				}
			} else if ('0' <= nxt && nxt <= '9') {
				int nd = d + (nxt - '0');
				if (nd < distance[k][ny][nx]) {
					distance[k][ny][nx] = nd;
					pq.add(new int[] {nd, ny, nx, k});
				}
			} else if (nxt == 'E') {
				if (d < distance[k][ny][nx]) {
					distance[k][ny][nx] = d;
					pq.add(new int[] {d, ny, nx, k});
				}
			}
		}
		
		return -1;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		graph = new String[H];
		distance = new int[4][H][W];
		for (int i = 0; i < H; i++) {
			graph[i] = br.readLine();
			for (int j = 0; j < W; j++) {
				for (int k = 0; k < 4; k++) {
					distance[k][i][j] = MAX;
				}
				char c = graph[i].charAt(j);
				if (c == 'T') { // 테라인 경우
					sy = i;
					sx = j;
				} else if (c == 'E') {
					ey = i;
					ex = j;
				}
 			}
		}
		
		System.out.println(dijkstra());
 	}
}
