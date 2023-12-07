// 색종이 - 3 (2571번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] graph = new int[102][102];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 0, 0에 놓는 경우를 고려하기 위해 1씩 더해줌
			int c1 = Integer.parseInt(st.nextToken()) + 1;
			int r1 = Integer.parseInt(st.nextToken()) + 1;
			int r2 = r1 + 9; // 칸을 셀 때, 자신을 포함하니 10이 아니라 9를 더해줘야 함
			int c2 = c1 + 9;
			graph[r1][c1] += 1;
			graph[r2 + 1][c2 + 1] += 1;
			graph[r2 + 1][c1] -= 1;
			graph[r1][c2 + 1] -= 1;			
		}
		
		// 누적 합 계산
		for (int i = 1; i < 102; i++) {
			for (int j = 1; j < 102; j++) {
				graph[i][j] += graph[i - 1][j] + graph[i][j - 1] - graph[i - 1][j - 1];
			}
		}
		
		// 누적 합 계산2
		for (int i = 1; i < 102; i++) {
			for (int j = 1; j < 102; j++) {
				if (graph[i][j] > 0) graph[i][j] = 1;
				else graph[i][j] = 0;
				graph[i][j] += graph[i - 1][j] + graph[i][j - 1] - graph[i - 1][j - 1];
			}
		}
		
		int maxSum = 0;
		for (int r1 = 1; r1 < 102; r1++) {
			for (int c1 = 1; c1 < 102; c1++) {
				for (int r2 = r1; r2 < 102; r2++) {
					for (int c2 = c1; c2 < 102; c2++) {
						int sum = graph[r2][c2] - graph[r1 - 1][c2] - graph[r2][c1 - 1] + graph[r1 - 1][c1 - 1];
						if (sum == (Math.abs(r1 - r2) + 1) * (Math.abs(c1 - c2) + 1)) {
							maxSum = Math.max(maxSum, sum);							
						}
					}
				}
			}
		}

		bw.write(maxSum + "");
		bw.flush();
		bw.close();
		br.close();
	}
}