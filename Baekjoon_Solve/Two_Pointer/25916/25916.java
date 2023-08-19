// 싫은데요 (25916번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		long[] A = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
		
		long ans = 0;
		int s = 0; // 시작 포인터
		while (s <= N) {
			int e = s + 1;
			while (s < e && e <= N) {				
				long sum = A[e] - A[s];
				if (sum <= M) { // 합이 M보다 작으면
					ans = Math.max(ans, sum); // 최댓값을 갱신하고
					e += 1; // 끝 포인터를 옮김
				} else {
					s += 1; // 시작 포인터를 옮김
				}
			}
			s = e;
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}