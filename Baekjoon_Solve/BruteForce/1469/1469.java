// 숌 사이 수열 (1469번)
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr, ans;
	static boolean[] visited;
	
	static void backtrack(int k, int _idx, int[] ret) {
		if (k == N) {
			// 사전순으로 더 빠른 수열인지 확인 후 변경
			boolean flag = true;
			for (int i = 0; i < N * 2; i++) {
				if (ans[i] < ret[i]) {
					flag = false;
					break;
				} else if (ans[i] > ret[i]) {
					break;
				}
			}
			
			if (flag) {
				int[] tmp = new int[N * 2];
				for (int i = 0; i < N * 2; i++) tmp[i] = ret[i];
				ans = tmp;
			}
			
			return;
		}
		
		for (int idx = 0; idx < 2 * N; idx++) {
			int nxtIdx = idx + arr[_idx] + 1;
			if (ret[idx] == -1 && nxtIdx < 2 * N && ret[nxtIdx] == -1) {
				ret[idx] = arr[_idx];
				ret[idx + arr[_idx] + 1] = arr[_idx];
				backtrack(k + 1, _idx + 1, ret);
				ret[idx] = -1;
				ret[idx + arr[_idx] + 1] = -1;
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int[] ret = new int[N * 2];
		Arrays.fill(ret, -1);
		
		ans = new int[N * 2];
		Arrays.fill(ans, 17);
		backtrack(0, 0, ret);
		
		if (ans[0] == 17) {
			bw.write("-1");
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N * 2 - 1; i++) {
				sb.append(ans[i]);
				sb.append(" ");
			}
			sb.append(ans[N * 2 - 1]);
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}