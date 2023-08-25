// 방 번호 (15668번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, A, B;
	static boolean flag;
	static boolean[] used;
	
	static void backtrack(int k, int a) {
		if (flag || a > N || a > 100_000) return;
		int b = N - a;
		B = b;
		boolean[] check = new boolean[10];
		while (b > 0) {
			if (used[b % 10] || check[b % 10]) break;
			check[b % 10] = true;
			b /= 10;
		}
		if (a != 0 && b == 0 && a + B == N) {
			A = a;
			flag = true;
			return;
		}		
		if (k == 10) {
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!used[i]) { // i를 아직 사용하지 않았다면
				used[i] = true;
				backtrack(k + 1, a * 10 + i);
				used[i] = false;
			}
		}
	}
	
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		A = 0;
		B = 0;
		used = new boolean[10];
		flag = false;
		backtrack(0, 0);
		if (A > 0 && B > 0 && A + B == N) {
			bw.write(A + " + " + B);			
		} else {
			bw.write(-1 + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
 	}
}