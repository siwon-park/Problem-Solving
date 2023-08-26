// 동방 프로젝트 (Large) (14595번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 동아리 방의 수
		int M = Integer.parseInt(br.readLine()); // 쿼리의 수
		
		// 스위핑을 위한 우선순위 큐 -> 시작 번호가 빠른 순, 끝 번호가 빠른 순으로 담음
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.s > o2.s) return 1;
			else if (o1.s < o2.s) return -1;
			else return Integer.compare(o1.e, o2.e);
		});
		
		if (M == 0) { // 쿼리 수가 0이면 남은 동아리 방의 수는 그대로 N임
			bw.write(N + "");
		} else {
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				pq.add(new Pair(s, e));
			}
			
			// 스위핑 -> 겹치는 구간을 구함
			ArrayList<Pair> pairList = new ArrayList<>();
			int s = pq.peek().s; // 현재 시작점
			int e = pq.peek().e; // 현재 끝점
			while (!pq.isEmpty()) {
				Pair pair = pq.poll();
				if (pair.s <= e) e = Math.max(e, pair.e); // 시작 구간이 겹치는 e를 최댓값으로 갱신
				else { // 구간이 겹치는 부분이 없으면 현재의 시작점과 끝점을 삽입하고, 시작점과 끝점을 갱신함
					pairList.add(new Pair(s, e));
					s = pair.s;
					e = pair.e;
				}
				if (pq.isEmpty()) pairList.add(new Pair(s, e)); // pq가 비었으면 현재의 시작점과 끝점을 삽입
			}
			
			int left = N; // 남은 방의 수
			for (Pair pair : pairList) left -= (pair.e - pair.s);
			bw.write(left + "");
		}
		
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