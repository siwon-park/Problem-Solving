// 카더가든 (28420번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, a, b, c;
	static int[][] arr;
	
	static int car1(int y, int x) {
		if (x - b - c < 0 || y - a < 0) return Integer.MAX_VALUE;
		return arr[y][x] - arr[y][x - b - c] - arr[y - a][x] + arr[y - a][x - b - c];
	}
	
	static int car2(int y, int x) {
		if (y - b - a < 0 || x - a - c < 0) return Integer.MAX_VALUE;
		int car = arr[y][x] - arr[y][x - a] - arr[y - b][x] + arr[y - b][x - a];
		int trailer = arr[y - b][x - a] - arr[y - b][x - a - c] - arr[y - b - a][x - a] + arr[y - b - a][x - a - c];
		return car + trailer;
	}
	
	static int car3(int y, int x) {
		if (y - c - a  < 0 || x - a - b < 0) return Integer.MAX_VALUE;
		int trailer = arr[y][x] - arr[y][x - a] - arr[y - c][x] + arr[y - c][x - a];
		int car = arr[y - c][x - a] - arr[y - c][x - a - b] - arr[y - c - a][x - a] + arr[y - c - a][x - a - b];
		return car + trailer;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] += arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				ans = Math.min(ans, car1(i, j)); // 일자형 (첫번째 그림)
				ans = Math.min(ans, car2(i, j)); // ㄱ형1 (두번째 그림)
				ans = Math.min(ans, car3(i, j)); // ㄱ형2 (세번째 그림)
			}
		}
		
		System.out.println(ans);
	}
}

