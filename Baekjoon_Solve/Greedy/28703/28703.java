// Double It (28703번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int max = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			pq.add(num);
			max = Math.max(max, num);
		}
		
		if (N == 1) {
			bw.write(0 + "");
		} else {
			int ans = Math.abs(max - pq.peek());
			int _max = max;
			while (pq.peek() < _max) {
				max = Math.max(max, pq.peek() * 2);
				pq.add(pq.poll() * 2);
				ans = Math.min(ans, max - pq.peek());
			}
			bw.write(ans + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}