// 고양이 카페 (28353번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] w = new int[N];
		for (int i = 0; i < N; i++) w[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(w);
		
		int s = 0;
		int e = N - 1;
		int cnt = 0; // 행복해질 수 있는 사람의 수
		while (s < e) {
			int twoCats = w[s] + w[e]; // 두 고양이 무게의 합
			if (twoCats <= K) { // 두 고양이의 무게 합이 K 이하면 사람 수를 증가시키고 양 포인터를 가운데로 옮김
				cnt++;
				s++;
				e--;
			} else { // 두 고양이의 무게 합이 K보다 크면 e를 밀어서 무게 합을 감소시킴
				e--;
			}
		}
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}