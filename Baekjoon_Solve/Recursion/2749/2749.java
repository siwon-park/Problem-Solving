// 피보나치 수 3 (2749번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MOD = 1_000_000;
	static HashMap<Long, Long> memo = new HashMap<>();
	
	static long recur(long n) {
		if (memo.get(n) != null) return memo.get(n);
		long ret = 0;
		if (n % 2 == 0) {
			long a = recur(n / 2);
			long b = recur(n / 2 - 1);
			ret = (a * a) % MOD + (2 * a * b) % MOD;
		} else {
			long a = recur((n + 1) / 2);
			long b = recur((n + 1) / 2 - 1);
			ret = (a * a) % MOD + (b * b) % MOD;
		}
		memo.put(n, ret % MOD);
		return memo.get(n);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine());
		memo.put(0L, 0L);
		memo.put(1L, 1L);
		recur(n);
		
		long ans = memo.get(n);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
