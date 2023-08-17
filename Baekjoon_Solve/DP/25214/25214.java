// 크림 파스타 (25214번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N];
		int min = arr[0];
		bw.write(dp[0] + "");
		for (int i = 1; i < N; i++) {
			min = Math.min(min, arr[i]);
			dp[i] = Math.max(dp[i - 1], arr[i] - min);
			bw.write(" " + dp[i]);
		}
		
		bw.flush();
		bw.close();
		br.close();
 	}
}
