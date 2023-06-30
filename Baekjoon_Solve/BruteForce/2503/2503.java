// 합이 0 (3151번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A); // 정렬
		
		long cnt = 0;
		for (int i = 0; i < N - 2; i++) {
			int left = i + 1;
			int right = N - 1;
			while (left < N - 1 && right >= 0 && left < right) {
				int sum = A[i] + A[left] + A[right];
				if (sum == 0) {
					// 0일 경우 수정해야 함
					cnt += 1;
				} else if (sum > 0) right -= 1;
				else left += 1;
			}
		}
		
		System.out.println(cnt);
	}
}