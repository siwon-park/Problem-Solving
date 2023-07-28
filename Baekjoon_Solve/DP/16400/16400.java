// 소수 화폐 (16400번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MOD = 123_456_789;
	static int N, M;
	static int[] dp;
	static ArrayList<Integer> primeNumbers; // 소수
	
	static void findPrime(int n) { // n이하의 소수를 찾음
		boolean[] isPrime = new boolean[n + 1];
		isPrime[1] = true;
		for (int i = 2; i <= n; i++) {
			if (!isPrime[i]) {
				int j = 2;
				while (i * j <= n) {
					isPrime[i * j] = true;
					j += 1;
				}
				primeNumbers.add(i);
				M += 1;
			}
		}
	}

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		primeNumbers = new ArrayList<>();
		dp = new int[N + 1];
		dp[0] = 1;
		M = 0;
		findPrime(N);
		for (int i = 0; i < M; i++) {
			int prime = primeNumbers.get(i);
			for (int j = prime; j <= N; j++) {
				dp[j] = (dp[j] + dp[j - prime]) % MOD;
			}
		}
		
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}