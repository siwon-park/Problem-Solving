// 소가 길을 건너간 이유 5 (14465번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		for (int i = 0; i < B; i++) arr[Integer.parseInt(br.readLine())] += 1;
		
		// 누적 합 계산
		for (int i = 1; i < N + 1; i++) arr[i] += arr[i - 1];
		
		// arr[n + k] - arr[n]의 값이 최솟값인 경우를 찾으면 됨
		int ans = 100_001;
		for (int i = K; i < N + 1; i++) ans = Math.min(ans, arr[i] - arr[i - K]);
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}