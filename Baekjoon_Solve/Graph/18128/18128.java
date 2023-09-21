// 치삼이의 징검다리 건너기 (18128번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0, -1, 1, 1, -1};
	static final int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
	static final int MAX = Integer.MAX_VALUE;
	static int N, W;
	static int[][] graph, waterField, distance;
	static Queue<Pair> waterQueue;
	
	static void bfs() {
		while (!waterQueue.isEmpty()) {
			Pair pair = waterQueue.poll();
			for (int k = 0; k < 4; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if (pair.lv + 1 < waterField[ny][nx]) {
					waterField[ny][nx] = pair.lv + 1;
					waterQueue.add(new Pair(ny, nx, pair.lv + 1));
				}
			}
		}
		// 출발 지점과 도착 지점은 모두 0으로 만듦
		waterField[0][0] = 0;
		waterField[N - 1][N - 1] = 0;
	}
	
	static int dijkstra() {
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.lv, o2.lv));
		pq.add(new Pair(0, 0, 0));
		distance[0][0] = 0;
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.y][pair.x] < pair.lv) continue;
			if (pair.y == N - 1 && pair.x == N - 1) return pair.lv;
			for (int k = 0; k < 8; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if (graph[ny][nx] == 1) { // 돌일 경우 이동 가능
					int maxLv = Math.max(pair.lv, waterField[ny][nx]);
					if (maxLv < distance[ny][nx]) {
						distance[ny][nx] = maxLv;
						pq.add(new Pair(ny, nx, maxLv));
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		waterQueue = new LinkedList<>();
		waterField = new int[N][N];
		distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(waterField[i], MAX);
			Arrays.fill(distance[i], MAX);
		}
		
		for (int w = 0; w < W; w++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			waterQueue.add(new Pair(r - 1, c - 1, 0));
			waterField[r - 1][c - 1] = 0;
		}
		
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs();
		int ans = dijkstra();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int y, x, lv;
	
	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	Pair(int y, int x, int lv) {
		this.y = y;
		this.x = x;
		this.lv = lv;
	}
}