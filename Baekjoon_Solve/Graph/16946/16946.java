// 벽 부수고 이동하기 4 (16946번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	
	static int N, M, areaNo; // 행, 열, 지역의 번호
	static int[] component;
	static int[][] graph, visited;
	
	
	static void bfs(int r, int c, int area) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		int cnt = 1; // 연결 컴포넌트의 크기
		visited[r][c] = area; // 연결 컴포넌트의 종류 마킹
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int y = tmp[0];
			int x = tmp[1];
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (graph[ny][nx] == 0 && visited[ny][nx] == 0) { // 벽이 아니고, 아직 연결되지 않은 곳일 경우
					cnt += 1; // 연결 컴포넌트의 크기 증가
					visited[ny][nx] = area; // 같은 연결 컴포넌트로 마킹
					queue.add(new int[] {ny, nx});
				}
			}
		}
		component[area] = cnt; // 연결 컴포넌트의 최종 크기를 배열에 저장
	}
	
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new int[N][M];
		component = new int[N * M + 1];
		areaNo = 1;
		
		Queue<int[]> zeroQueue = new LinkedList<>();
		Queue<int[]> oneQueue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(line.charAt(j) + "");
				if (graph[i][j] == 0) zeroQueue.add(new int[] {i, j});
				else oneQueue.add(new int[] {i, j});
			}
		}
		
		// 0에 대해서 탐색
		while (!zeroQueue.isEmpty()) {
			int[] pair = zeroQueue.poll();
			int r = pair[0];
			int c = pair[1];
			if (visited[r][c] != 0) continue;
			bfs(r, c, areaNo++);
		}
		
		// 1에 대해서 탐색
		while (!oneQueue.isEmpty()) {
			int[] pair = oneQueue.poll();
			HashSet<Integer> hashSet = new HashSet<>();
			int y = pair[0];
			int x = pair[1];
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (visited[ny][nx] != 0 && !hashSet.contains(visited[ny][nx])) {
					hashSet.add(visited[ny][nx]);
					graph[y][x] = (graph[y][x] + component[visited[ny][nx]]) % 10;
				}
			}
		}
		
		StringBuilder sb;
		for (int i = 0; i < N; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < M; j++) sb.append(graph[i][j]);
			bw.write(sb.toString() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
 	}
}