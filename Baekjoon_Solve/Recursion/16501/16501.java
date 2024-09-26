// 시간표 만들기 (31837번)
import java.io.*;
import java.util.*;

public class Main {

	static int[] arr, t1, t2, t3, t4;
	static double ans = 0.0;
	
	static void backtrack(int idx, int a, int b, int c, int d) {
		if (a == 2 && b == 2 && c == 2 && d == 2) {
			double avg1 = (t1[0] + t1[1]) / (double) 2;
			double avg2 = (t2[0] + t2[1]) / (double) 2;
			double ret1 = 1 - (Math.abs(avg1 - avg2) / (double) 10);
			
			double avg3 = (t3[0] + t3[1]) / (double) 2;
			double avg4 = (t4[0] + t4[1]) / (double) 2;
			double ret2 = 1 - (Math.abs(avg3 - avg4) / (double) 10);
			ans = Math.max(ans, Math.min(ret1, ret2));
			return;
		}
		
		// idx를 t1에 넣음
		if (a < 2) {
			t1[a] = arr[idx];
			backtrack(idx + 1, a + 1, b, c, d);
			t1[a] = -1;			
		}
		
		// idx를 t2에 넣음
		if (b < 2) {
			t2[b] = arr[idx];
			backtrack(idx + 1, a, b + 1, c, d);
			t2[b] = -1;
		}
		
		// idx를 t3에 넣음
		if (c < 2) {
			t3[c] = arr[idx];
			backtrack(idx + 1, a, b, c + 1, d);
			t3[c] = -1;			
		}
		
		// idx를 t4에 넣음
		if (d < 2) {
			t4[d] = arr[idx];
			backtrack(idx + 1, a, b, c, d + 1);
			t4[d] = -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[8];
		for (int i = 0; i < 8; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		t1 = new int[2];
		t2 = new int[2];
		t3 = new int[2];
		t4 = new int[2];
		Arrays.fill(t1, -1);
		Arrays.fill(t2, -1);
		Arrays.fill(t3, -1);
		Arrays.fill(t4, -1);
		
		backtrack(0, 0, 0, 0, 0);
		System.out.println(ans);
	}
}
