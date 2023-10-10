// 만남의 광장 (25708번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] graph;
	static int[] vertSum, hrznSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M]; // 격자판 -> 중복을 제거하기 위해 사용
		hrznSum = new int[N]; // 각 행의 합
		vertSum = new int[M]; // 각 열의 합
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int hSum = 0; // 현재 행의 합
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				hSum += graph[i][j];
				vertSum[j] += graph[i][j];
			}
			hrznSum[i] = hSum;
		}
		
		int max = Integer.MIN_VALUE; // 광장의 최대 아름다움은 음수일 수도 있음
		for (int r1 = 0; r1 < N - 1; r1++) {
			for (int r2 = r1 + 1; r2 < N; r2++) {
				for (int c1 = 0; c1 < M - 1; c1++) {
					for (int c2 = c1 + 1; c2 < M; c2++) {
						int cnt = (r2 - r1 - 1) * (c2 - c1 - 1); // 직사각형 영역 안 녹지의 칸수
						int sum = hrznSum[r1] + hrznSum[r2] + vertSum[c1] + vertSum[c2];
						sum -= (graph[r1][c1] + graph[r1][c2] + graph[r2][c1] + graph[r2][c2]); // 중복 제거
						max = Math.max(max, sum + cnt);
					}
				}
			}
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}