// 파일 합치기 3 (13975번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < K; k++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			long ans = 0L;
			while (pq.size() >= 2) {
				long x1 = pq.poll();
				long x2 = pq.poll();
				long sumX = x1 + x2;
				ans += sumX;
				pq.add(sumX);
			}
			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}