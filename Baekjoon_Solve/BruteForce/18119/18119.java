// 단어 암기 (18119번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, known;
	static int[] words;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		words = new int[N];
		
		known = 0;
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			int bit = 0;
			for (int j = 0; j < word.length(); j++) {
				bit |= (1 << (word.charAt(j) - 97));
			}
			words[i] = bit;
			known |= bit;
		}
		
		int op, w, cnt;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			op = Integer.parseInt(st.nextToken());
			w = st.nextToken().charAt(0) - 97;
			known = known ^ (1 << w); // 비트 XOR 연산 (비트 토글링)
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if ((known & words[j]) == words[j]) cnt += 1;
			}
			bw.write(cnt + "\n");
		}
				
		bw.flush();
		bw.close();
		br.close();
 	}
}