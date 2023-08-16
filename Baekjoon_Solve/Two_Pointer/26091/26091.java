// 현대모비스 소프트웨어 아카데미 (26091번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 팀 능력치 하한값
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		if (N <= 1) bw.write(0 + "");
		else {
			Arrays.sort(arr); // 정렬
			int cnt = 0;
			int s = 0;
			int e = N - 1;
			while (s < e) {
				int sum = arr[s] + arr[e];
				if (sum >= M) { // 능력치 합이 M 이상이면 만들 수 있는 팀 수를 1 증가시키고, 양쪽 포인터를 옮김
					s++;
					e--;
					cnt++;
				} else { // 능력치 합이 M보다 작으면 시작 포인터를 왼쪽으로 밀어서 능력치 합을 증가시킴
					s++;
				}
			}
			
			bw.write(cnt + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
 	}
}
