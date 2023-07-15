// 강의실 배정 (11000번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Pair[] pairs = new Pair[N];
		int s, t;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair(s, t);
		}
		
		// 시작 시간이 빠른 순으로 정렬
		Arrays.sort(pairs, (o1, o2) -> Integer.compare(o1.s, o2.s));
		
		// 끝나는 시간이 빠른 우선순위 큐를 선언
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.e, o2.e));
		int cnt = 0; // 강의실 개수
		for (int i = 0; i < N; i++) {
			Pair cur = pairs[i];
			if (pq.isEmpty()) { // 우선순위 큐가 비어있으면 큐에 삽입 후 강의실의 수 증가
				pq.add(cur);
				cnt += 1;
			} else {
				Pair tmp = pq.peek(); // 끝나는 시간이 제일 빠른 강의
				if (tmp.e <= cur.s) { // 현재 강의의 시작 시간이 진행 중인 강의의 끝나는 시간 이상이면
					pq.poll(); // 끝나는 시간이 제일 빠른 강의는 빠짐
					pq.add(cur); // 현재 강의 우선순위 큐에 삽입
				} else { // 끝나는 시간 > 현재 강의의 시작 시간이면
					pq.add(cur); // 강의 중이기 때문에 우선순위 큐에 현재 강의 삽입 후
					cnt += 1; // 강의실 수를 늘림
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