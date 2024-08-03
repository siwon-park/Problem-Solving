// 마트료시카 합치기 (25631번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		int cnt = N;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0]);
		for (int i = 1; i < N; i++) {
			if (pq.peek() < arr[i]) {
				pq.poll();
				pq.add(arr[i]);
				cnt -= 1;
			} else {
				pq.add(arr[i]);
			}
		}
		
		System.out.println(cnt);
	}
}

