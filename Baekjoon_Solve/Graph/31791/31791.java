// 바이러스 공격 (31791번)
import java.io.*;
import java.util.*;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N, M, Tg, Tb, X, B;
	static String[] graph;
	static int[][] distance;
	
	static void dijkstra(PriorityQueue<int[]> pq) {
		while (!pq.isEmpty()) {
			int[] pair = pq.poll();
			int t = pair[0];
			int y = pair[1];
			int x = pair[2];
			if (distance[y][x] < t || t >= Tg) continue;
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (graph[ny].charAt(nx) == '.') {
					if (t + 1 < distance[ny][nx]) {
						distance[ny][nx] = t + 1;
						pq.add(new int[] {t + 1, ny, nx});
					}
				} else if (graph[ny].charAt(nx) == '#') {
					if (t + 1 + Tb < distance[ny][nx]) {
						distance[ny][nx] = t + 1 + Tb;
						pq.add(new int[] {t + 1 + Tb, ny, nx});
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
		
		st = new StringTokenizer(br.readLine());
		Tg = Integer.parseInt(st.nextToken());
		Tb = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		graph = new String[N];
		distance = new int[N][M];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine();
			Arrays.fill(distance[i], INF);
			for (int j = 0; j < M; j++) {
				if (graph[i].charAt(j) == '*') {
					pq.add(new int[] {0, i, j});
					distance[i][j] = 0;
				}
			}
		}
		
		dijkstra(pq);
		
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (distance[i][j] > Tg) {
					flag = true;
					bw.write((i + 1) + " " + (j + 1) + "\n");
				}
			}
		}
		
		if (!flag) bw.write("-1");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
