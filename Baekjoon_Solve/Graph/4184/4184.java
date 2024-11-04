// Ocean Currents (4184번)
import java.io.*;
import java.util.*;

public class Main {

	static final int MAX = Integer.MAX_VALUE;
	// 인덱스에 맞게 배치
	static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int R, C, N;
	static String[] graph;
	
	static int bfs(int rs, int cs, int rd, int cd) {
		if (rs == rd && cs == cd) return 0;
		int[][] visited = new int[R][C];
		for (int i = 0; i < R; i++) Arrays.fill(visited[i], MAX);
		visited[rs][cs] = 0;
		Deque<int[]> deque = new LinkedList<>();
		deque.add(new int[] {0, rs, cs});
		while (!deque.isEmpty()) {
			int[] pair = deque.pollFirst();
			int d = pair[0];
			int y = pair[1];
			int x = pair[2];
			if (visited[y][x] < d) continue;
			int cur = graph[y].charAt(x) - '0';
			for (int k = 0; k < 8; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if (cur == k && d < visited[ny][nx]) { // 방향이 같으면 드는 에너지는 0
					deque.addFirst(new int[] {d, ny, nx});
					visited[ny][nx] = d;
				} else if (cur != k && d + 1 < visited[ny][nx]) {
					deque.addLast(new int[] {d + 1, ny, nx});
					visited[ny][nx] = d + 1;
				}
			}
		}
		return visited[rd][cd];
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new String[R];
		for (int i = 0; i < R; i++) {
			graph[i] = br.readLine();
		}
		
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()) - 1;
			arr[i][1] = Integer.parseInt(st.nextToken()) - 1;
			arr[i][2] = Integer.parseInt(st.nextToken()) - 1;
			arr[i][3] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for (int i = 0; i < N; i++) {
			int ret = bfs(arr[i][0], arr[i][1], arr[i][2], arr[i][3]);
			bw.write(ret + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
 	}
}


