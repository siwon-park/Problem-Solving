// 아우으 우아으이야!! (15922번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static final int MIN = Integer.MIN_VALUE;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Pair[] pairs = new Pair[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair(s, e);
		}
		
		// s가 빠른 순, e가 빠른 순으로 정렬
		Arrays.sort(pairs, (o1, o2) -> {
			if (o1.s > o2.s) return 1;
			else if (o1.s < o2.s) return -1;
			else return Integer.compare(o1.e, o2.e);
		});
		
		
		// e가 큰 순, s가 빠른 우선순위 큐를 만들고 0부터 N까지 스위핑
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.e > o2.e) return -1;
			else if (o1.e < o2.e) return 1;
			else return Integer.compare(o1.s, o2.s);
		});
		
		int len = 0; // 선분의 길이
		for (int i = 0; i < N; i++) {
			Pair curPair = pairs[i];
			if (pq.isEmpty()) pq.add(curPair);
			else {
				// 현재 선분의 시작점이 pq의 맨 위의 선분의 끝나는 지점보다 크면 pq에서 계속 뽑음
				int s = MAX;
				int e = MIN;
				int line = 0; // 현재 선분의 길이
				while (!pq.isEmpty() && curPair.s > pq.peek().e) {
					Pair outPair = pq.poll();
					s = Math.min(s, outPair.s);
					e = Math.max(e, outPair.e);
					line = Math.max(line, e - s);
				}
				pq.add(curPair);
				len += line;
			}
		}
		
		int s = MAX;
		int e = MIN;
		int line = 0;
		while (!pq.isEmpty()) {
			Pair outPair = pq.poll();
			s = Math.min(s, outPair.s);
			e = Math.max(e, outPair.e);
			line = Math.max(line, e - s);
		}
		len += line;
		
		bw.write(len + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}


class Pair {
	int s, e;
	
	Pair(int s, int e) {
		this.s = s;
		this.e = e;
	}
}