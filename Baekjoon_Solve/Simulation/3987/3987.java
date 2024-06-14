// 보이저 1호 (3987번)
import java.util.*;
import java.io.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static final int[] dy = new int[] {-1, 0, 1, 0};
	static final int[] dx = new int[] {0, 1, 0, -1};	
	static int N, M;
	static String[] graph;
	
	static int bfs(int r, int c, int w) {
		int max = 0;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(r, c, w, 1));
		int[][][] visited = new int[4][N][M];
		visited[w][r][c] = 1;
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			max = Math.max(max, pair.d);
			int ny = pair.y + dy[pair.k];
			int nx = pair.x + dx[pair.k];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M || graph[ny].charAt(nx) == 'C') continue; // 블랙홀, 범위 벗어나면 무시
			if (visited[pair.k][ny][nx] == 0) {
				int k = pair.k;
				visited[k][ny][nx] = pair.d + 1;
				if (graph[ny].charAt(nx) == '.') {
					queue.add(new Pair(ny, nx, k, pair.d + 1));					
				} else if (graph[ny].charAt(nx) == '/') {
					if (pair.k == 0 || pair.k == 2) k = (pair.k + 1) % 4;
					else k = (pair.k + 3) % 4;
					queue.add(new Pair(ny, nx, k, pair.d + 1));
				} else if (graph[ny].charAt(nx) == '\\') {
					if (pair.k == 0 || pair.k == 2) k = (pair.k + 3) % 4;
					else k = (pair.k + 1) % 4;
					queue.add(new Pair(ny, nx, k, pair.d + 1));
				}
			} else { // visited[k][ny][nx]를 처음 방문하는게 아니면 사이클임
				return INF;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new String[N];
		for (int i = 0; i < N; i++) graph[i] = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		int sy = Integer.parseInt(st.nextToken()) - 1;
		int sx = Integer.parseInt(st.nextToken()) - 1;
		
		String[] way = new String[] {"U", "R", "D", "L"};
		int[] ret = new int[4];
		for (int k = 0; k < 4; k++) {
			ret[k] = bfs(sy, sx, k);
		}
		
		int tmp = 0;
		int w = 0;
		for (int i = 0; i < 4; i++) {
			if (tmp < ret[i]) {
				tmp = ret[i];
				w = i;
			}
		}
		
		bw.write(way[w] + "\n");
		if (tmp == INF) {
			bw.write("Voyager");			
		} else {
			bw.write(tmp + "");			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}

class Pair {
	int y, x, k, d;
	Pair(){}
	Pair(int y, int x, int k, int d) {
		this.y = y;
		this.x = x;
		this.k = k;
		this.d = d;
	}
}
