// 등산 (1486번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N, M, T, D;
	static int[][] graph;
	static int[][][] distance; // 0: 올라가는 방향, 1: 내려가는 방향
	
	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
		pq.add(new int[] {0, 0, 0, 0}); // 정방향
		pq.add(new int[] {0, 0, 0, 1}); // 역방향
		distance[0][0][0] = 0;
		distance[0][0][1] = 0;
		
		while (!pq.isEmpty()) {
			int[] pair = pq.poll();
			int t = pair[0];
			int y = pair[1];
			int x = pair[2];
			int z = pair[3];
			if (distance[y][x][z] < t) continue;
			int curH = graph[y][x];
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				int nxtH = graph[ny][nx];
				int diff = Math.abs(nxtH - curH);
				if (diff <= T) {
					if (z == 0) { // 정방향일 경우
						if (curH >= nxtH) { // 현재 위치보다 낮은 곳으로 이동 1초 소모
							if (t + 1 < distance[ny][nx][z]) {
								distance[ny][nx][z] = t + 1;
								pq.add(new int[] {t + 1, ny, nx, z});
							}
						} else { // 현재 위치보다 높은 곳으로 이동
							int tt = (nxtH - curH) * (nxtH - curH);
							if (t + tt < distance[ny][nx][z]) {
								distance[ny][nx][z] = t + tt;
								pq.add(new int[] {t + tt, ny, nx, z});
							}
						}
					} else { // 역방향일 경우
						if (curH <= nxtH) {
							if (t + 1 < distance[ny][nx][z]) {
								distance[ny][nx][z] = t + 1;
								pq.add(new int[] {t + 1, ny, nx, z});
							}
						} else {
							int tt = (nxtH - curH) * (nxtH - curH);
							if (t + tt < distance[ny][nx][z]) {
								distance[ny][nx][z] = t + tt;
								pq.add(new int[] {t + tt, ny, nx, z});
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		distance = new int[N][M][2];
		graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = line.charAt(j);
				if ('A' <= c && c <= 'Z') {
					graph[i][j] = c - 'A';
				} else {
					graph[i][j] = c - '0' - 23;
				}
				Arrays.fill(distance[i][j], INF);
			
			}
		}
		
		dijkstra();
		
		int maxH = graph[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (distance[i][j][0] != INF && distance[i][j][1] != INF) {
					if (distance[i][j][0] + distance[i][j][1] <= D) {
						maxH = Math.max(maxH, graph[i][j]);
					}
				}
			}
		}
		
		System.out.println(maxH);
	}
}

