// 중복된 숫자 (15719번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		/*
		 * 전체 숫자의 합 sum을 구한 다음에 n * (n - 1) / 2를 빼면 중복된 숫자를 더 쉽게 찾을 수 있음
		 * */
		
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			count[num] += 1;
			if (count[num] == 2) {
				bw.write(num + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

