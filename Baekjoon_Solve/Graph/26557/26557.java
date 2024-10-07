// Bomb (26557번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static final int[] dz = {-1, 1};
	
	static int T;
	static int F, R, C;
	static String[][] graph;
	static int[][][] distance;
	
	static int dijkstra(PriorityQueue<int[]> pq) {
		while (!pq.isEmpty()) {
			int[] pair = pq.poll();
			int d = pair[0];
			int z = pair[1];
			int y = pair[2];
			int x = pair[3];
			if (distance[z][y][x] < d) continue;
			if (graph[z][y].charAt(x) == 'E') return distance[z][y][x];
			// 횡 이동 (z축은 같음)
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
				int nd = d;
				if (graph[z][ny].charAt(nx) == '#') { // 벽일 경우 비용 증가
					nd += 1;
				}
				if (nd < distance[z][ny][nx]) {
					distance[z][ny][nx] = nd;
					pq.add(new int[] {nd, z, ny, nx});
				}
			}
			// 종 이동 (z축만 변경)
			for (int k = 0; k < 2; k++) {
				int nz = z + dz[k];
				if (nz < 0 || nz >= F) continue;
				int nd = d;
				if (graph[nz][y].charAt(x) == '#') {
					nd += 1;
				}
				if (nd < distance[nz][y][x]) {
					distance[nz][y][x] = nd;
					pq.add(new int[] {nd, nz, y, x});
				}
			}
			 
		}
		return -1;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			F = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			graph = new String[F][R];
			distance = new int[F][R][C];
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
			int sr = 0, sc = 0, sf = 0;
			for (int i = 0; i < F; i++) {
				for (int j = 0; j < R; j++) {
					graph[i][j] = br.readLine();
					for (int k = 0; k < C; k++) {
						distance[i][j][k] = MAX;
						if (graph[i][j].charAt(k) == 'S') {
							sf = i;
							sr = j;
							sc = k;
							distance[sf][sr][sc] = 0;
							pq.add(new int[] {0, sf, sr, sc});
						}
					}
				}
			}
			int ans = dijkstra(pq);
			bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

