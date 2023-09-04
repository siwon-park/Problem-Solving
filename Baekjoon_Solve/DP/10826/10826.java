// 피보나치 수 4 (10826번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, n, m;
	static int[] dp1, dp2; // 각 자리수별 숫자를 저장
	
	/*
	 * dp1과 dp2를 더함
	 * 홀/짝으로 구분하여 dp1과 dp2를 달리 계산함
	 * */
	static void plusFibo(int cur) {
		if (cur % 2 == 0) {
			int _max = Math.max(n, m);
			for (int i = 1; i <= _max; i++) {
				dp1[i] = (dp1[i] + dp2[i]);
				if (dp1[i] >= 10) {
					dp1[i + 1] += 1;
					dp1[i] %= 10;
					n = i + 1;
				} else n = i;
			}
		} else {
			int _max = Math.max(n, m);
			for (int i = 1; i <= _max; i++) {
				dp2[i] = (dp1[i] + dp2[i]);
				if (dp2[i] >= 10) {
					dp2[i + 1] += 1;
					dp2[i] %= 10;
					m = i + 1;
				} else m = i;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp1 = new int[3000];
		dp2 = new int[3000];
		dp1[1] = 0;
		dp2[1] = 1;
		n = 1;
		m = 1;
		for (int i = 2; i <= N; i++) {
			plusFibo(i);
		}
		
		StringBuilder sb = new StringBuilder();
		if (N % 2 == 0) {
			for (int i = 1; i <= n; i++) {
				sb.append(Integer.toString(dp1[i]));
			}			
		} else {
			for (int i = 1; i <= m; i++) {
				sb.append(Integer.toString(dp2[i]));
			}	
		}
		
		sb.reverse();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}