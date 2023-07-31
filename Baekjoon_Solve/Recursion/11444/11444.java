// 피보나치 수 6 (11444번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final long MOD = 1_000_000_007;
	static HashMap<Long, Long> memo;
	
	static long fibo(long n) {
		if (memo.get(n) != null) return memo.get(n);
		if (n <= 1) {
			memo.put(n, n);
			return memo.get(n);
		} else if (n == 2) {
			memo.put(n, 1L);
			return memo.get(n);
		} else {
			long a, b, ret;
			if (n % 2 == 0) { // n이 짝수일 경우 -> a2n = an(an + 2 * an-1)
				a = fibo(n / 2);
				b = fibo(n / 2 - 1);
				ret = (a % MOD) * (a + 2 * b) % MOD;
			} else { // n이 홀수일 경우 -> a2n-1 = an ^ 2 + an-1 ^ 2
				a = fibo((n + 1) / 2);
				b = fibo((n + 1) / 2 - 1);
				ret = (a * a) % MOD + (b * b) % MOD;
			}
			ret %= MOD;
			memo.put(n, ret);
			return memo.get(n);
		}		
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine());
		memo = new HashMap<>();
		fibo(n);
		bw.write(memo.get(n) + "\n");
		bw.flush();
		bw.close();
		br.close();
 	}
}
