// 세 용액 (2473번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static long MAX = 3_000_000_000L;
	static long[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr); // 정렬
		
		long[] triple = new long[3];
		for (int i = 0; i < N - 2; i++) {
			int left = i + 1; // 왼쪽 포인터
			int right = N - 1; // 오른쪽 포인터
			if (MAX == 0) continue;
			while (left < right) {
				long sum = arr[i] + arr[left] + arr[right];
				if (Math.abs(sum) < Math.abs(MAX)) {
					MAX = sum;
					triple[0] = arr[i];
					triple[1] = arr[left];
					triple[2] = arr[right];
				}
				
				if (sum > 0) right -= 1;
				else if (sum < 0) left += 1;
				else break;
			}
		}
		
		Arrays.sort(triple);
		bw.write(triple[0] + " " + triple[1] + " " + triple[2]);
		bw.flush();
		br.close();
		bw.close();
	}
}