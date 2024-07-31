// 타일 장식물 (13301번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 2];
		dp[1] = 1L;
		for (int i = 2; i < N + 2; i++) dp[i] = dp[i - 1] + dp[i - 2];
		System.out.println(2 * dp[N] + 2 * dp[N + 1]);
	
	}
}

