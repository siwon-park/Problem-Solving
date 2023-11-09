// 줄 세우기 (7570번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr, indexes, length;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		indexes = new int[N + 1]; // 숫자 n의 인덱스
		length = new int[N + 1]; // 숫자 n의 길이
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			length[arr[i]] = 1;
			indexes[arr[i]] = i;
		}
		
		// 가장 긴 증가하는 연속 부분 수열을 구해보자
		int len = 0;
		for (int i = 0; i < N; i++) {
			// arr[i] - 1의 인덱스가 arr[i]보다 작아야 함
			if (indexes[arr[i] - 1] < indexes[arr[i]]) {
				length[arr[i]] += length[arr[i] - 1];
			}
			len = Math.max(len, length[arr[i]]);
		}
		
		bw.write((N - len) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}