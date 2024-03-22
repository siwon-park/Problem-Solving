// 겹치는 선분 (1689번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[i][0] = s;
			arr[i][1] = e;
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] > o2[0]) return 1;
			else if (o1[0] < o2[0]) return -1;
			else return Integer.compare(o1[1], o2[1]);
		});
		
		int ans = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		pq.add(arr[0][1]); // 끝점 삽입
		for (int i = 1; i < N; i++) {
			int s = arr[i][0];
			int e = arr[i][1];
			while(!pq.isEmpty() && s >= pq.peek()) pq.poll();
			pq.add(e);
			ans = Math.max(ans, pq.size());
		}
		System.out.println(ans);
	}
}