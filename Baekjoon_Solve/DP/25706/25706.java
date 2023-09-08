// 자전거 묘기 (25706번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			int h = arr[i];
			dp[i] = 1;
			if (i + h + 1 < N) dp[i] += dp[i + h + 1];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) sb.append(dp[i] + " ");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
