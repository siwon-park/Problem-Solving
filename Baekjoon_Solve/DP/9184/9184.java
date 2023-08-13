// 신나는 함수 실행 (9184번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int[][][] memo;
	
	static int recur(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) return 1;
		if (memo[a][b][c] != 0) return memo[a][b][c];
		if (a > 20 || b > 20 || c > 20) return recur(20, 20, 20);
		int ret = 0;
		if (a < b && b < c) ret = recur(a, b, c - 1) + recur(a, b - 1, c - 1) - recur(a, b - 1, c);
		else ret = recur(a - 1, b, c) + recur(a - 1, b - 1, c) + recur(a - 1, b, c - 1) - recur(a - 1, b - 1, c - 1);
		memo[a][b][c] = ret;
		return memo[a][b][c];
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		memo = new int[51][51][51];
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1) break;
			int ans = recur(a, b, c);
			bw.write("w(" + a + ", " + b + ", " + c + ") = " + ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
 	}
}
