// 넴모넴모 (Easy) (14712번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, ans;
	static int[][] graph;
	
	static void backtrack(int r, int c) {
		// 종료 조건이 있고 ans += 1
		if (r == N) {
			boolean flag = check();
			if (flag) ans += 1;
			return;
		}
		
		// 현재 위치에 넴모를 둠
		graph[r][c] = 1;
		backtrack(r + ((c + 1) / M), (c + 1) % M);
		graph[r][c] = 0;

		// 현재 위치에 넴모를 두지 않음
		backtrack(r + ((c + 1) / M), (c + 1) % M);
	}
	
	static boolean check() {
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				int v1 = graph[i][j];
				int v2 = graph[i + 1][j];
				int v3 = graph[i][j + 1];
				int v4 = graph[i + 1][j + 1];
				if (v1 == 1 && v2 == 1 && v3 == 1 && v4 == 1) return false;
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		ans = 0;
		backtrack(0, 0);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
