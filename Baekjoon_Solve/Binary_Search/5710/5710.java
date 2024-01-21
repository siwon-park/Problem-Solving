// 전기 요금 (5710번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B;
	
	static int binarySearch(int t) {
		int s = 0;
		int e = t;
		while (s <= e) {
			int mid = (s + e) >> 1;
			int a = cal(mid);
			int b = cal(t - mid);
			int tmpA = Math.min(a, b); // 상근이의 요금
			int tmpB = Math.max(a, b); // 이웃의 요금
			if (tmpB - tmpA == B) return tmpA;
			else if (tmpB - tmpA > B) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return 0;
	}
	
	static int cal(int wh) {
		int wage = 0;
		if (wh > 1_000_000) {
			wage += 7 * (wh - 1_000_000);
			wh = 1_000_000;
		}
		if (wh > 10_000) {
			wage += 5 * (wh - 10_000);
			wh = 10_000;
		}
		if (wh > 100) {
			wage += 3 * (wh - 100);
			wh = 100;
		}
		wage += 2 * wh;
		return wage;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if (A == 0 && B == 0) break;
			// 사용한 총량을 계산
			int totalWh = 0;
			int a = Math.min(100, A / 2);
			totalWh += a;
			A -= 2 * a;
			if (A > 0) {
				int b = Math.min(9900, A / 3);
				totalWh += b;
				A -= 3 * b;
				if (A > 0) {
					int c = Math.min(990_000, A / 5);
					totalWh += c;
					A -= 5 * c;
					if (A > 0) {
						totalWh += A / 7;
					}
				}
			}
			
			int ans = binarySearch(totalWh);
			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	} 
}