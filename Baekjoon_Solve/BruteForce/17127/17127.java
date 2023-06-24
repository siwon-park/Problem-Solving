// 벚꽃이 정보섬에 피어난 이유 (17127번)
import java.io.*;
import java.util.*;

public class Main {
		
	static int N; // 벚나무의 개수
	static int ans; // 정답
	static int[] arr, comb;
	
	static void combine(int k, int s) {
		if (k == 4) {
			int sumP = 0;
			for (int j = 1; j < 5; j++) {
				int tmp = 1;
				for (int l = comb[j - 1]; l < comb[j]; l++) tmp *= arr[l];
				sumP += tmp;
			}
			
			ans = Math.max(ans, sumP);
			return;
		}
		
		for (int i = s; i < N; i++) {
			comb[k] = i;
			combine(k + 1, i + 1);
			comb[k] = 0;
		}	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		ans = 0;
		if (N == 4) {
			for (int i = 0; i < N; i++) ans += arr[i];
		
		}
		
		comb = new int[5];
		comb[0] = 0;
		comb[4] = N;
		combine(1, 1);
		
		System.out.println(ans);
	}	
}