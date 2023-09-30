// 시간이 겹칠까? (28018번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q;
	static int[] arr = new int[1_000_002];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s] += 1;
			arr[e + 1] -= 1; // e까지만 누적 합을 반영
		}
		
		for (int i = 1; i < 1_000_001; i++) {
			arr[i] += arr[i - 1];
		}
		
		Q = Integer.parseInt(br.readLine()); // 쿼리 구간
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(st.nextToken());
			bw.write(arr[q] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}