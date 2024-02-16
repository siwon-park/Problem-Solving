// 킥보드로 등교하기 (27977번)
import java.io.*;
import java.util.*;

public class Main {

	static int L, N, K;
	static int[] arr;
	
	static int binarySearch() {
		int s = 1;
		int e = L;
		int ans = L;
		while (s <= e) {
			int mid = (s + e) >> 1; // 현재 최적 배터리 크기
			int cur = mid; // 남은 배터리
			int k = 0; // 충전소 방문 횟수
			for (int i = 1; i < N + 2; i++) {
				int diff = arr[i] - arr[i - 1]; // 두 지점의 차이
				if (cur >= diff) { // 현재 잔여 배터리가 두 지점의 차이 이상이면 그냥 이동함
					cur -= diff;
				} else {
					k += 1;
					cur = mid;
					if (cur >= diff) {
						cur -= diff;
					} else {
						k = K + 1;
						break;
					}
				}
			}
			
			if (k <= K) { // 충전 횟수가 K이하면 e를 줄여서 탐색
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[N + 1] = L;
		
		int ans = binarySearch();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}