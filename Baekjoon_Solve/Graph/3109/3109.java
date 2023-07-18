// 빵집 (3109번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, ans; // 행, 열, 정답
	static String[] graph; // 그래프
	static boolean[][] visited;
	
	static boolean dfs(int r, int c) {
		visited[r][c] = true;
		if (c == C - 1) {
			ans += 1;
			return true;
		}
		boolean flag = false;
		// 오른쪽 대각선 위 이동
		if (r - 1 >= 0 && c + 1 < C && !visited[r - 1][c + 1] && graph[r - 1].charAt(c + 1) == '.') {
			if (!flag) flag = dfs(r - 1, c + 1);				
		}  // 오른쪽 이동
		if (c + 1 < C && !visited[r][c + 1] && graph[r].charAt(c + 1) == '.') {
			if (!flag) flag = dfs(r, c + 1);
		} // 오른쪽 대각 하단 이동
		if (r + 1 < R && c + 1 < C && !visited[r + 1][c + 1] && graph[r + 1].charAt(c + 1) == '.') {
			if (!flag) flag = dfs(r + 1, c + 1);
		}
		return flag;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[R][C];
		graph = new String[R];
		for (int i = 0; i < R; i++) graph[i] = br.readLine();
		
		ans = 0;
		for (int r = 0; r < R; r++) {
			dfs(r, 0);
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}