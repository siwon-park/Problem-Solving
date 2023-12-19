// 조 짜기 (2229번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = i; j >= 1; j--) {
				int _min = Math.min(arr[i], arr[j]);
				int _max = Math.max(arr[i], arr[j]);
				dp[i] = Math.max(dp[i], dp[j - 1] + _max - _min);
			}
		}
		
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}