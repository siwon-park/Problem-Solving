// 줄줄이 박수 (29718번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, A;
	static int[] prefixSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		prefixSum = new int[M + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) { // 각 열별로 합을 누적
				prefixSum[j] += Integer.parseInt(st.nextToken());
			}
		}
		
		// 누적합 계산
		for (int j = 1; j < M + 1; j++) {
			prefixSum[j] += prefixSum[j - 1];
		}
		
		A = Integer.parseInt(br.readLine()); // 열의 개수
		
		// 슬라이딩 윈도우
		int maxClap = 0;
		for (int j = A; j < M + 1; j++) {
			maxClap = Math.max(maxClap, prefixSum[j] - prefixSum[j - A]);
		}
		
		bw.write(maxClap + "");
		bw.flush();
		bw.close();
		br.close();
	}
}