// 구간 자르기 (2283번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 1_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[MAX + 2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// A 위치에는 1을 더하고, B + 1 위치에는 -1을 더함
			arr[a + 1] += 1;
			arr[b + 1] -= 1;
		}
		
		// 누적 합 계산
		for (int i = 1; i < MAX + 2; i++) arr[i] += arr[i - 1];
		for (int i = 1; i < MAX + 2; i++) arr[i] += arr[i - 1];

		int A = MAX + 1;
		int B = MAX + 1;
		int s = 0;
		int e = 1;
		while (s < e && e <= MAX) {
			int k = arr[e] - arr[s];
			if (k == K) {
				A = s;
				B = e;
				break;
			} else if (k < K) e += 1;
			else s += 1;
			if (s == e) e += 1; // s와 e가 같아지는 경우 구간의 총 길이 합은 0이니, A < B인 구간을 찾기위해 e를 1증가시킴
		}
		
		if (A == MAX + 1 && B == MAX + 1) bw.write(0 + " " + 0);
		else bw.write(A + " " + B);
		bw.flush();
		bw.close();
		br.close();
	}
}