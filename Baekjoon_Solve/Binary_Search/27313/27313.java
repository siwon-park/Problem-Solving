// 효율적인 애니메이션 감상 (27313번)
import java.io.*;
import java.util.*;

public class Main {
		
	static int N, M, K;
	static int[] arr;
	
	static int binarySearch() {
		int ans = 0;
		Arrays.sort(arr); // 정렬
		if (arr[1] > M) return 0; // 가장 작은 원소를 보는데 걸리는 시간이 M보다 크면 볼 수 있는게 없음
		int s = 1;
		int e = N;	
		while (s <= e) {
			int mid = (s + e) >> 1; // 최대 mid개 시청 가능
			long m = 0;
			// mid개부터 역순으로 K개까지 선택하는게 무조건 이득임
			for (int i = mid; i > 0; i -= K) {
				m += arr[i];
			}
			
			if (m <= M) { // mid개를 봤는데 총 시간이 M이하면 더 시청 가능한지 확인해봄
				s = mid + 1;
				ans = mid;
			} else { // M이하로 mid개를 못본다면 시간을 더 줄여봄
				e = mid - 1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());				
		
		int ans = binarySearch();
		System.out.println(ans);
	}
}

