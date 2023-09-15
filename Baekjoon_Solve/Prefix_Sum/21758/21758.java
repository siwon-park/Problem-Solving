// 꿀 따기 (21758번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr, prefixSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		prefixSum = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefixSum[i] += prefixSum[i - 1] + arr[i];
		}
		
		int ans = 0;
		for (int i = 1; i < N + 1; i++) {
			int sum1 = prefixSum[N - 1] - prefixSum[i - 1] + prefixSum[i] - prefixSum[1]; // case1: i가 꿀통
			int sum2 = prefixSum[N - 1] + prefixSum[i - 1] - arr[i]; // case2: 1이 꿀통, i와 N이 벌
			if (i == N) sum2 = -1;
			int sum3 = prefixSum[N] - arr[1] - arr[i] + prefixSum[N] - prefixSum[i]; // case3: N이 꿀통, 1과 i가 벌
			if (i == 1 || i == N) sum3 = -1;
			ans = Math.max(ans, Math.max(Math.max(sum1, sum2), sum3));
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}