// 아이템 먹기 (2411번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, A, B;
	static int[][] map;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		
		// 아이템 입력
		Pair[] items = new Pair[A + 2];
		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			items[i] = new Pair(y, x);
			map[y][x] = 1;
		}
		items[A] = new Pair(1, 1);
		items[A + 1] = new Pair(N, M);
		
		// 장애물 입력
		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = -1; // 갈 수 없는 곳은 -1 표시
		}
		
		// 아이템을 정렬 -> 좌표 빠른 순으로 정렬
		Arrays.sort(items, (o1, o2) -> {
			if (o1.y > o2.y) return 1;
			else if (o1.y < o2.y) return -1;
			else return Integer.compare(o1.x, o2.x);
		});
		
		int[][] dp = new int[N + 1][M + 1];
		if (map[1][1] != -1) dp[1][1] = 1;
		for (int n = 1; n < A + 2; n++) {
			Pair pair1 = items[n - 1];
			Pair pair2 = items[n];
			// pair1에서 pair2로 가는 경우의 수를 구함
			int y1 = pair1.y;
			int x1 = pair1.x;
			int y2 = pair2.y;
			int x2 = pair2.x;
			
			for (int i = y1; i <= y2; i++) {
				for (int j = x1; j <= x2; j++) {
					if (map[i][j] == -1) continue;
					int left = (map[i][j - 1] == -1) ? 0 : dp[i][j - 1];
					int up = (map[i - 1][j] == -1) ? 0 : dp[i - 1][j];
					
					if (i == 1 && j > 1) dp[i][j] = left;
					else if (j == 1 && i > 1) dp[i][j] = up;
					else if (i > 1 && j > 1) dp[i][j] = left + up;
				}
			}
		}
		
		bw.write(dp[N][M] + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}


class Pair {
	int y;
	int x;
	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
}