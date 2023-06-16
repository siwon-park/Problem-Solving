// 스도쿠 채점 (9291번)
import java.io.*;
import java.util.*;

public class Main {
	
	static boolean check(int[][] graph) {
		// 행 또는 열에 대해 확인
		for (int r = 0; r < 9; r++) {
			boolean[] rVisited = new boolean[10];
			boolean[] cVisited = new boolean[10];
			for (int c = 0; c < 9; c++) {
				if (rVisited[graph[r][c]]) return false;
				rVisited[graph[r][c]] = true;
				if (cVisited[graph[c][r]]) return false;
				cVisited[graph[c][r]] = true;
			}
		}
		
		// 3 x 3에 대해 확인
		for (int r = 0; r < 9; r += 3) {
			for (int c = 0; c < 9; c += 3) {
				boolean[] gVisited = new boolean[10];
				for (int i = r; i < r + 3; i++) {
					for (int j = c; j < c + 3; j++) {
						if (gVisited[graph[i][j]]) return false;
						gVisited[graph[i][j]] = true;
					}
				}
			}
		}
		
		return true;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		StringTokenizer st;
		for (int t = 1; t < T + 1; t++) {
			int[][] graph = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (t != T) st = new StringTokenizer(br.readLine());
			boolean flag = check(graph);
			bw.write(String.format("Case %d: ", t));
			if (flag) bw.write("CORRECT");
			else bw.write("INCORRECT");
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}