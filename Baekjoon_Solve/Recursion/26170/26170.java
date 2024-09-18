// 사과 빨리 먹기 (26170번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = new int[] {-1, 0, 1, 0};
	static final int[] dx = new int[] {0, 1, 0, -1};
	static int[][] graph = new int[5][5];
	static int ans = 26;
	
	static void dfs(int y, int x, int cnt, int d) {
		int org = graph[y][x];
		graph[y][x] = -1; // 현재 위치를 장애물로 변경
		if (cnt == 3) { // 먹은 사과가 3개면 최단 거리를 갱신 후 return
			ans = Math.min(ans, d);
			graph[y][x] = org; // 롤백
			return;
		}
		
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5 || graph[ny][nx] == -1) continue;
			if (graph[ny][nx] == 1) {
				dfs(ny, nx, cnt + 1, d + 1);
			} else {
				dfs(ny, nx, cnt, d + 1);
				
			}
		}
		graph[y][x] = org; // 롤백
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		dfs(r, c, 0, 0);
		
		System.out.println((ans == 26) ? -1 : ans);
	}
}

