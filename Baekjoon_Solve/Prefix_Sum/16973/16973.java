// 직사각형 탈출 (16973번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, H, W; // 행, 열, 세로, 가로
	static int Sr, Sc, Fr, Fc; // 출발점(r, c), 도착점(r, c)
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static boolean[][] visited;
	static int[][] graph;
	
	static int bfs() {
		visited[Sr][Sc] = true;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(Sr, Sc, 0));
		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			// 도착점에 도달했으면서 사각형이 크기를 넘지 않을 경우에만 값을 반환
			if (cur.r == Fr && cur.c == Fc) {
				return cur.cnt;
			}
			for (int k = 0; k < 4; k++) {
				int nr = cur.r + dy[k];
				int nc = cur.c + dx[k];
				if (nr <= 0 || nr > N - H + 1 || nc <= 0 || nc > M - W + 1 || visited[nr][nc] || graph[nr][nc] >= 1) continue;
				visited[nr][nc] = true;
				queue.add(new Pair(nr, nc, cur.cnt + 1));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ArrayList<Pair> pairList = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 1) {
					pairList.add(new Pair(i, j));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine()); // H, W, Sr, Sc, Fr, Fc
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken());
		Sc = Integer.parseInt(st.nextToken());
		Fr = Integer.parseInt(st.nextToken());
		Fc = Integer.parseInt(st.nextToken());
		
		// 모든 격자판의 크기를 2씩 늘려서 선언
		graph = new int[N + 2][M + 2];
		visited = new boolean[N + 2][M + 2];
		for (int i = 0; i < pairList.size(); i++) {
			Pair tmp = pairList.get(i);
			int r = tmp.r;
			int c = tmp.c;
			// (r, c)를 우측하단 끝점으로 하는 정사각형의 누적 합을 계산
			// max를 해준 이유는 범위를 벗어나면 사각형을 못 만드는 경우가 있어서
			graph[Math.max(0, r - H + 1)][Math.max(0, c - W + 1)] += 1;
			graph[r + 1][Math.max(0, c - W + 1)] -= 1;
			graph[Math.max(0, r - H + 1)][c + 1] -= 1;
			graph[r + 1][c + 1] += 1;
		}
		
		// 누적 합 계산
		for (int i = 1; i < N + 1; i++) {
			graph[i][0] += graph[i - 1][0];
		}
		
		for (int j = 1; j < M + 1; j++) {
			graph[0][j] += graph[0][j - 1];
		}
		
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				graph[i][j] += (graph[i - 1][j] + graph[i][j - 1] - graph[i - 1][j - 1]);
			}
		}
		
		int ans = bfs();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair {
	int r, c, cnt;
	Pair(){}
	Pair(int r, int c) {
		this.r = r;
		this.c = c;
	}
	Pair(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}