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
		arr = new int[2 * N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[i][0] = s;
			arr[i][1] = 1;
			arr[i + N][0] = e;
			arr[i + N][1] = -1;
		}
		
		/*
		 * 선분의 끝점에서 겹치는 것을 카운트하는 것을 피하기 위해 -1, 1도 오름차순으로 정렬해 줌
		 * */ 
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] > o2[0]) return 1;
			else if (o1[0] < o2[0]) return -1;
			else return Integer.compare(o1[1], o2[1]);
		});
		
		int ans = 0;
		int cnt = 0;
		for (int i = 0; i < 2 * N; i++) {
			cnt += arr[i][1];
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
