// 강의실 (1374번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Pair[] pairs = new Pair[N];
		
		StringTokenizer st;
		int no, s, e;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			no = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair(no, s, e);
		}
		
		Arrays.sort(pairs, (o1, o2) -> Integer.compare(o1.s, o2.s));
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.e, o2.e));
		
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
	int no;
	int s;
	int e;
	
	Pair(int no, int s, int e) {
		this.no = no;
		this.s = s;
		this.e = e;
	}
}