// 최소 회의실 개수 (19598번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static Pair[] pairs;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		pairs = new Pair[N];
		
		StringTokenizer st;
		int s, e;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair(s, e);
		}
		
		Arrays.sort(pairs, (o1, o2) -> Integer.compare(o1.s, o2.s)); // 시작 시간이 빠른 순으로 정렬
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.e, o2.e)); // 끝나는 시간이 빠른 우선순위
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			Pair cur = pairs[i];
			if (pq.isEmpty()) {
				pq.add(cur);
				cnt += 1;
			} else {
				Pair tmp = pq.peek();
				if (tmp.e <= cur.s) {
					pq.poll();
					pq.add(cur);
				} else {
					pq.add(cur);
					cnt += 1;
				}
			}
		}
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}


class Pair {
	int s;
	int e;
	
	Pair(int s, int e) {
		this.s = s;
		this.e = e;
	}
}