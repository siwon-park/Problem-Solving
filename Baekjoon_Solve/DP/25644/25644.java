// 최대 상승 (25644번)
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2]; // 0: 현재 시점의 주가, 1: 과거 주가 중 최솟값
		arr[0][1] = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int maxProfit = 0;
		for (int i = 1; i < N + 1; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Math.min(arr[i][0], arr[i - 1][1]);
			maxProfit = Math.max(maxProfit, arr[i][0] - arr[i][1]);
		}
		
		bw.write(maxProfit + "");
		bw.flush();
		bw.close();
		br.close();
	}
}