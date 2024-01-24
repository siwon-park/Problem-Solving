// 숏코딩의 왕 브실이 (29726번)
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
		
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		long _min = Long.MAX_VALUE;
		long _max = Long.MIN_VALUE;
		for (int i = 0; i < M + 1; i++) {
			_min = Math.min(_min, A[i]);
			_max = Math.max(_max, A[i + N - M - 1] - _min);
		}
		
		bw.write(_max + "");
		bw.flush();
		br.close();
		bw.close();
	}
}