// 창영이와 점프 (22114번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] L = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) L[i] = Integer.parseInt(st.nextToken());
		
		int s = 0, e = 0, jump = 0, cnt = 0, _max = 0;
		while (s <= e && e < N - 1) {
			if (L[e] <= K || (L[e] > K && jump == 0)) {
				if (L[e] > K && jump == 0) jump += 1;
				e += 1;
				cnt += 1;
				_max = Math.max(_max, cnt);
			} else if (L[e] > K) {
				if (L[s] > K) jump = 0;
				s += 1;
				cnt -= 1;
			}
		}
		
		bw.write((_max + 1) + ""); // N - 1개의 블럭에 대해서 카운트했으므로 i -> i + 1을 1개로 감안하면 +1을 해줘야 함
		bw.flush();
		bw.close();
		br.close();
	}
}
