// 과제 (13904번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Pair[] pairs = new Pair[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair(d, w);
		}
		
		// 마감 기한이 작은 순, 점수가 작은 순으로 정렬
		Arrays.sort(pairs, (o1, o2) -> {
			if (o1.d < o2.d) return -1;
			else if (o1.d > o2.d) return 1;
			else return Integer.compare(o1.w, o2.w);
		});
		
		// 점수가 작은 순으로 정렬
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
		for (int i = 0; i < N; i++) {
			Pair pair = pairs[i];
			if (pq.size() < pair.d) pq.add(pair);
			else {
				if (pq.peek().w < pair.w) {
					pq.poll();
					pq.add(pair);
				}
			}
		}
		
		int ans = 0;
		while (!pq.isEmpty()) ans += pq.poll().w;
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int d, w;
	Pair(int d, int w) {
		this.d = d;
		this.w = w;
	}
}