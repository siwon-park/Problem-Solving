// 모양 만들기 (16932번)
import java.io.*;
import java.util.*;

public class Main {

	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N, M;
	static boolean[][] visited;
	static int[][] graph;
	static int[] components;
	
	// 각 영역이 속한 연결 컴포넌트 번호와 연결 컴포넌트별 크기를 구하는 BFS
	static void bfs(int r, int c, int n) {
		visited[r][c] = true;
		graph[r][c] = n;
		components[n] += 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int y = pair[0];
			int x = pair[1];
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || graph[ny][nx] == 0) continue;
				visited[ny][nx] = true;
				queue.add(new int[] {ny, nx});
				components[n] += 1;
				graph[ny][nx] = n;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		components = new int[N * M + 1];
		visited = new boolean[N][M];
		graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int no = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && graph[i][j] == 1) {
					no++;
					bfs(i, j, no);
				}
			}
		}
		
		int maxShape = 0; // 모양의 최대 크기
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (graph[y][x] == 0) {
					int tmpShape = 1; // 0인 위치를 1로 바꾸니까 1부터 시작
					HashSet<Integer> hashSet = new HashSet<>(); // 중복 영역을 더하지 않기 위해 set 사용
					for (int k = 0; k < 4; k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];
						if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						hashSet.add(graph[ny][nx]);
					}
					for (Integer i : hashSet) {
						tmpShape += components[i];
					}
					maxShape = Math.max(maxShape, tmpShape);
				}
			}
		}
		
		bw.write(maxShape + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
