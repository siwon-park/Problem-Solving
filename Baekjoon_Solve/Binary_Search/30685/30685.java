// 버터 녹이기 (30685번)
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	
	static int parametricSearch() {
		int s = 1;
		int e = 1_000_000_000;
		int ans = -1;
		while (s <= e) {
			int mid = (s + e) >> 1; // mid초
			int right = Math.min(arr[0][0] + arr[0][1] / 2, arr[0][0] + mid); // 제일 첫번째 버터가 녹았을 때 오른쪽 위치
			boolean flag = false;
			for (int i = 1; i < N; i++) {
				int curX = arr[i][0]; // 현재 버터의 위치
				int left = Math.max(curX - arr[i][1] / 2, curX - mid);
				if (right >= left) {
					flag = true; // mid 초에 겹침
					break;
				}
				right = Math.min(curX + arr[i][1] / 2, curX + mid);
			}
			
			if (flag) {
				e = mid - 1;
				ans = mid;
			} else {
				s = mid + 1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // x
			arr[i][1] = Integer.parseInt(st.nextToken()); // h
		}
		
		Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		
		int ret = parametricSearch();
		if (ret == -1) {
			System.out.println("forever");			
		} else {
			System.out.println(ret - 1); // 최대 mid초까지 가열했을 때 겹치게 되므로 -1을 해준다.				
		}
	}
}

