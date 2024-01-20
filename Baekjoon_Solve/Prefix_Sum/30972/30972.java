// 닭강정의 전설 (30972번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] += (arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1]);
			}
		}
		
		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int sum1 = arr[r2][c2] - arr[r2][c1 - 1] - arr[r1 - 1][c2] + arr[r1 - 1][c1 - 1];
			int sum2 = arr[r2 - 1][c2 - 1] - arr[r2 - 1][c1] - arr[r1][c2 - 1] + arr[r1][c1];
			bw.write((2 * sum2 - sum1) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	} 
}