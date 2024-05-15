// 버스 노선 개편하기 (23740번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Pair> pairList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pairList.add(new Pair(s, e, c));
		}
		
		pairList.sort((o1, o2) -> {
			if (o1.s < o2.s) return -1;
			else if (o1.s > o2.s) return 1;
			else {
				if (o1.e < o2.e) return -1;
				else if (o1.e > o2.e) return 1;
			}
			return Integer.compare(o1.c, o2.c);
		});
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.e < o2.e) return -1;
			else if (o1.e > o2.e) return 1;
			else {
				if (o1.s < o2.s) return -1;
				else if (o1.s > o2.s) return 1;
			}
			return Integer.compare(o1.c, o2.c);
		});
		
		ArrayList<Pair> busWay = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			Pair pair = pairList.get(i);
			if (!pq.isEmpty() && pq.peek().e >= pair.s) { // 노선을 합침
				Pair tmp = pq.poll();
				tmp.e = Math.max(tmp.e, pair.e);
				tmp.c = Math.min(tmp.c, pair.c);
				pq.add(tmp);
			} else { // 비어있거나 노선을 합칠 수 없음
				if (pq.isEmpty()) pq.add(pair);
				else {
					busWay.add(pq.poll());
					pq.add(pair);
				}
			}
		}
		
		while (!pq.isEmpty()) busWay.add(pq.poll());
		busWay.sort((o1, o2) -> Integer.compare(o1.s, o2.s));
		
		bw.write(busWay.size() + "\n");
		for (int i = 0; i < busWay.size(); i++) {
			Pair pair = busWay.get(i);
			bw.write(pair.s + " " + pair.e + " " + pair.c + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int s, e, c;
	
	Pair(){}
	
	Pair(int s, int e, int c) {
		this.s = s;
		this.e = e;
		this.c = c;
	}
}
