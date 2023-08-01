// 곱셈 (1629번)
import java.io.*;
import java.util.*;

public class Main {
	
	static HashMap<Integer, Long> memo;
	
	static long recur(int a, int b, int c) {
		if (memo.get(b) != null) return memo.get(b);
		if (b == 0) {
			memo.put(b, 1L);
			return memo.get(0);			
		} else if (b == 1) {
			memo.put(b, (long) a % c);
			return memo.get(b);
		} else {
			long ret = 0;
			if (b % 2 == 0) {
				long tmp = recur(a, b / 2, c);
				ret = ((tmp % c) * (tmp % c)) % c;
			} else {
				long left = recur(a, b / 2, c);
				long right = recur(a, b / 2 + 1, c);
				ret = ((left % c) * (right % c)) % c;
			}
			memo.put(b, ret);
			return memo.get(b);
		}
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		memo = new HashMap<>();
		
		bw.write(recur(A, B, C) + "");
		
		bw.flush();
		bw.close();
		br.close();
 	}
}