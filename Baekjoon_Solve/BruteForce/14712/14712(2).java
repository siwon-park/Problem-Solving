// 넴모넴모 (Easy) (14712번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, ans;
	static int[][] graph;
	
	static void backtrack(int r, int c) {
		// 종료 조건이 있고 ans += 1
		if (r == N + 1) {
			ans += 1;
			return;
		}
		
		// 현재 위치에 넴모를 둠 -> 최적화; 둘 수 있는 곳일 경우에만 둬보자 -> 배열 크기를 1씩 늘림
		if (graph[r - 1][c - 1] == 0 || graph[r][c - 1] == 0 || graph[r - 1][c] == 0) {
			graph[r][c] = 1;
			backtrack(r + ((c / M)), (c % M) + 1);
			graph[r][c] = 0;			
		}

		// 현재 위치에 넴모를 두지 않음
		backtrack(r + ((c / M)), (c % M) + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][M + 1];
		ans = 0;
		backtrack(1, 1);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}