// K보다 큰 구간 (14246번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 누적 합 배열을 구함
		long[] arr = new long[n + 1];
		for (int i = 1; i < n + 1; i++) arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		long cnt = 0; // 쌍의 개수 -> worst: n * (n - 1) / 2 >= 2 ^ 31
		// 누적 합 배열이기 때문에 1번 인덱스에서 0번 인덱스를 빼면 arr[1]의 값임
		int s = 0; 
		int e = 1;
		while (s <= e && e <= n) {
			long sum = arr[e] - arr[s];
			if (sum > k) { // 누적 합의 차이가 k보다 크면 그 뒤로도 계속 k보다 큼
				cnt += (n - e + 1);
				s += 1;
			} else { // 구간 합이 k보다 작으면 e를 늘려서 구간 합을 증가시킴
				e += 1;
			}
		}
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}
