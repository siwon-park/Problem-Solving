// 어깨동무 (27932번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 2]; // 첫 시작과 제일 끝은 양끝에 존재하는 수와 같게 함
		st = new StringTokenizer(br.readLine());
		int H = 0;
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			H = Math.max(H, arr[i]);
		}
		
		arr[0] = arr[1];
		arr[N + 1] = arr[N];
		int s = 0;
		int e = H;
		
		while (s <= e) {
			int mid = (s + e) >> 1;
			int cnt = 0; // 지친 사람의 수
			for (int i = 1; i < N + 1; i++) {
				// 양쪽의 사람 중 키 차이가 mid보다 크면 지침
				if (Math.abs(arr[i - 1] - arr[i]) > mid || Math.abs(arr[i] - arr[i + 1]) > mid) {
					cnt += 1;
				}
			}
			
			if (cnt <= K) { // 지친 사람의 수가 K이하면
				e = mid - 1; // mid를 줄여서 탐색하여 지친 사람의 수를 K이하로 최대한 늘려봄
				H = mid;
			} else {
				s = mid + 1;
			}
		}
		
		bw.write(H + "");
		bw.flush();
		bw.close();
		br.close();		
	}
}
