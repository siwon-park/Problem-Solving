// 같이 눈사람 만들래? (20366번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, MAX;
	static int[] H;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		H = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) H[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(H); // 정렬
	
		MAX = H[N - 1] - H[0];
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = N - 1; j >= i + 1; j--) {
				int left = i + 1;
				int right = j - 1;
				while (left < right) {
					int diff = H[j] + H[i] - (H[left] + H[right]);
					MAX = Math.min(MAX, Math.abs(diff));
					if (diff > 0) left += 1;
					else if (diff < 0) right -= 1;
					else break;
				}
			}
		}
		
		System.out.println(Math.abs(MAX));
	}
}