// 시간을 돌리고 싶어 (32347번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] arr, future;
	
	static int binarySearch() {
		int s = 1;
		int e = N - 1;
		int ans = N - 1;
		while (s <= e) {
			int mid = (s + e) >> 1;
			int k = 0; // 타임머신 사용 횟수
			int cur = N - 1; // 현재일
			while (k < K) {
				k += 1;
				if (arr[cur] == 1) {
					cur -= mid;
				} else {
					cur = future[cur] - mid; // 과거에서 시간을 보내고 다시 과거로 감
				}
				cur = Math.max(cur, 0);
				if (cur == 0) break;
			}
			
			if (k <= K && cur == 0) { // K번 이하 사용 and 1일로 갈 수 있음
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

		N = Integer.parseInt(st.nextToken()); // 현재 일
		K = Integer.parseInt(st.nextToken()); // 타임머신의 최대 사용 일수
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		future = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int day = N - 1; // 가장 가까운 미래
		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] == 1) {
				future[i] = i;
				day = i;
			} else { // 현재 전원이 공급되지 않으면
				future[i] = day; // 전원이 공급되고 있는 가장 가까운 날을 기록
			}
		}
		
		int t = binarySearch();
		System.out.println(t);
		
	}
}

