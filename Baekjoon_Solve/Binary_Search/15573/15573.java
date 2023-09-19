// 채굴 (15573번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N, M, K;
	static int[][] graph;
	
	static boolean bfs(int d) {
		int cnt = 0;
		boolean[][] visited = new boolean[N + 1][M + 2];
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int y = pair[0];
			int x = pair[1];
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= N + 1 || nx < 0 || nx >= M + 2) continue;
				if (graph[ny][nx] <= d && !visited[ny][nx]) {
					visited[ny][nx] = true;
					if (graph[ny][nx] != 0) cnt += 1; // 0이상의 광물에 대해서만 카운트
					if (cnt >= K) return true; // 캔 광물의 수가 K이상이면 탐색을 종료
					queue.add(new int[] {ny, nx});
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][M + 2]; // 지면을 염두해서 N + 2가 아니라 N + 1로 선언
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int s = 1;
		int e = 1_000_000;
		int ans = e;
		while (s <= e) {
			int mid = (s + e) >> 1;
			boolean flag = bfs(mid); // 채굴기 성능을 mid로 했을 때, K이상으로 광물을 캘 수 있는지 확인
			if (flag) { // K개 이상으로 광물을 캘 수 있음 -> 채굴기 성능을 줄여서 탐색해 봄
				e = mid - 1;
				ans = mid;
			} else { // K개 이상으로 광물을 캘 수 없음 -> 채굴기 성능을 증가시킴
				s = mid + 1;
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}