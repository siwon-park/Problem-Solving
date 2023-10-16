// 두 동전 (16197번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N, M, no;
	static String[] graph;
	static boolean[][][][] visited;
	static Pair P = new Pair();
	
	static int bfs() {
		visited[P.y1][P.x1][P.y2][P.x2] = true;
		P.cnt = 0;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(P);
		int minCnt = 11;
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			for (int k = 0; k < 4; k++) {
				boolean one = false; // 동전1이 밖으로 나감 유무
				boolean two = false; // 동전2가 밖으로 나감 유무
				int ny1 = pair.y1 + dy[k];
				int nx1 = pair.x1 + dx[k];
				int ny2 = pair.y2 + dy[k];
				int nx2 = pair.x2 + dx[k];
				if (ny1 < 0 || ny1 >= N || nx1 < 0 || nx1 >= M) one = true;
				if (ny2 < 0 || ny2 >= N || nx2 < 0 || nx2 >= M) two = true;
				if (one == true && two == true) continue; // 둘 다 나갔으면 continue
				// 둘 중 하나만 나갔으면
				if ((one == true && two == false) || (one == false && two == true)) {
					minCnt = Math.min(minCnt, pair.cnt + 1);
					continue;
				}
				if (graph[ny1].charAt(nx1) == '#') {
					ny1 = pair.y1;
					nx1 = pair.x1;
				}
				if (graph[ny2].charAt(nx2) == '#') {
					ny2 = pair.y2;
					nx2 = pair.x2;
				}
				
				if (!visited[ny1][nx1][ny2][nx2] && pair.cnt + 1 <= 10) {
					visited[ny1][nx1][ny2][nx2] = true;
					queue.add(new Pair(ny1, nx1, ny2, nx2, pair.cnt + 1));
				}
			}
		}
		
		return (minCnt == 11) ? -1 : minCnt ;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		no = 0;
		graph = new String[N];
		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine();
			for (int j = 0; j < M; j++) {
				if (graph[i].charAt(j) == 'o') {
					if (no == 0) {
						P.y1 = i;
						P.x1 = j;
						no += 1;
					} else {
						P.y2 = i;
						P.x2 = j;
					}
				}
			}
		}
		
		visited = new boolean[N][M][N][M];
		int ans = bfs();
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int y1, x1, y2, x2, cnt;
	Pair() {}
	Pair(int y1, int x1, int y2, int x2, int cnt) {
		this.y1 = y1;
		this.x1 = x1;
		this.y2 = y2;
		this.x2 = x2;
		this.cnt = cnt;
	}
}