// 대회 자리 (5176번)
import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean[] seats = new boolean[M + 1];
			for (int j = 0; j < P; j++) {
				int usr = Integer.parseInt(br.readLine());
				if (!seats[usr]) {
					seats[usr] = true;
				} else {
					cnt += 1;
				}
			}
			
			bw.write(cnt + "\n");
 		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

