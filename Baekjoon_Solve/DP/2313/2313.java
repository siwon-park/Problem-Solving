// 보석 구매하기 (2313번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		long ans = 0;
		for (int i = 0; i < N; i++) {
			L = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			long lineMax = Long.MIN_VALUE;
			int l = 0;
			int r = 0;
			long sum = 0;
			int minLen = 0; // 보석의 최소 길이(선택한 보석 수)
			int curLen = 0; // 보석의 현재 길이
			for (int j = 0; j < L; j++) {
				int cur = Integer.parseInt(st.nextToken());
				// 현재 원소가 이전 합 + 현재 원소 이상이면 길이는 1
				if (sum + cur <= cur) {
					curLen = 1;
				} else {
					curLen += 1;
				}
				sum = Math.max(sum + cur, cur);
				// 구간의 최댓값을 갱신할 때 구간을 갱신함
				if (sum > lineMax) {
					r = j;
					l = j - curLen + 1;
					lineMax = sum;
					minLen = curLen;
				} else if (sum == lineMax && curLen < minLen) { // 최댓값과 같은데 선택한 보석이 더 적으면 선택
					r = j;
					l = j - curLen + 1;
					minLen = curLen;
				}
			}
			ans += lineMax;
			bw2.write((l + 1) + " " + (r + 1) + "\n");
		}
		
		bw1.write(ans + "\n");
		bw1.flush();
		bw2.flush();
		bw1.close();
		br.close();
	}
}