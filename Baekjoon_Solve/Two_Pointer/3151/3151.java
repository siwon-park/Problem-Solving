// 합이 0 (3151번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] A;
	
	static long combine(int n) {
		return n * (n - 1) / 2;
	}
	
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
			if (A[i] > 0) break; // A[i]가 0보다 크면 더 이상 0을 만들 수 없음
			int left = i + 1;
			int right = N - 1;
			while (left < right) {
				int sum = A[i] + A[left] + A[right];
				if (sum == 0) { // 합이 0인 경우
					int l = 1;
					int r = 1;
					// 1) A[left] == A[right]이면 조합 경우의 수를 구하고 break
					if (A[left] == A[right]) {
						cnt += combine(right - left + 1); // 2개를 고르는 경우의 수
						break;
					}
					// 2) A[left + 1] == A[left]이거나 A[right - 1] == A[right]인 경우
					// 같은 갯수가 몇개인지 카운트해야함
					while (left + 1 < right && A[left] == A[left + 1]) {
						l += 1;
						left += 1;
					}
					while (right - 1 > left && A[right] == A[right - 1]) {
						r += 1;
						right -= 1;
					}
					cnt += l * r; // lC1 + rC1만큼 더 함	
				}
				if (sum > 0) right -= 1;
				else left += 1;
			}
		}
		
		System.out.println(cnt);
	}
}