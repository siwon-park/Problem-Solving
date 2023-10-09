// 거울 설치 (2151번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N;
	static String[] graph;
	static Pair[] sePairs = new Pair[2];
	
	static int dijkstra() {
		Pair s = sePairs[0];
		Pair e = sePairs[1];
		int[][][] distance = new int[4][N][N];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(distance[i][j], 1_000_000);
			}
			distance[i][s.y][s.x] = 0;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt)); 
		for (int k = 0; k < 4; k++) {
			int ny = s.y + dy[k];
			int nx = s.x + dx[k];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
			if (graph[ny].charAt(nx) != '*') {
				pq.add(new Pair(s.y, s.x, k, 0));				
			}
		}
		
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.k][pair.y][pair.x] < pair.cnt) continue;
			if (pair.y == e.y && pair.x == e.x) return pair.cnt;
			int ny = pair.y + dy[pair.k];
			int nx = pair.x + dx[pair.k];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
			if (graph[ny].charAt(nx) != '*') {
				if (graph[ny].charAt(nx) == '!') {
					int cnt = pair.cnt + 1;
					if (pair.k == 0 || pair.k == 2) {
						if (cnt < distance[1][ny][nx]) {
							distance[1][ny][nx] = cnt;
							pq.add(new Pair(ny, nx, 1, cnt));
						}
						if (cnt < distance[3][ny][nx]) {
							distance[3][ny][nx] = cnt;
							pq.add(new Pair(ny, nx, 3, cnt));
						}
					} else {
						if (cnt < distance[0][ny][nx]) {
							distance[0][ny][nx] = cnt;
							pq.add(new Pair(ny, nx, 0, cnt));
						}
						if (cnt < distance[2][ny][nx]) {
							distance[2][ny][nx] = cnt;
							pq.add(new Pair(ny, nx, 2, cnt));
						}
					}
				}
				// 거울을 설치하지 않고 그냥 감
				if (pair.cnt < distance[pair.k][ny][nx]) {
					distance[pair.k][ny][nx] = pair.cnt;
					pq.add(new Pair(ny, nx, pair.k, pair.cnt));
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new String[N];
		int e = 0;
		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine();
			for (int j = 0; j < N; j++) {
				if (graph[i].charAt(j) == '#') {
					sePairs[e++] = new Pair(i, j);
				}
			}
		}
		
		int ans = dijkstra();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int y, x, k, cnt;
	Pair() {}
	
	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	Pair(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
	
	Pair(int y, int x, int k, int cnt) {
		this.y = y;
		this.x = x;
		this.k = k;
		this.cnt = cnt;
	}
}