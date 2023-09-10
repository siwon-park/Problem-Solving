// 피자 (Small) (14606번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static long[] memo = new long[11];
	
	static long recur(int n) {
		if (n <= 1) {
			return memo[1];
		}
		if (memo[n] != -1) return memo[n];
		long ret = 0;
		for (int i = 1; i < n / 2 + 1; i++) {
			ret = Math.max(ret, i * (n - i) + recur(i) + recur(n - i));
		}
		memo[n] = ret;
		return memo[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		Arrays.fill(memo, -1);
		memo[1] = 0;
		memo[2] = 1;
		
		recur(N);
		bw.write(memo[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}