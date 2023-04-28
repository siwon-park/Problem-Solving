import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K; // 보석의 수, 가방의 수
	static int[] bags; // 각 가방별 담을 수 있는 무게
	static Pair[] jewelry; // 보석 정보를 담은 배열
	static long price; // 보석의 최대 가격 합
	static PriorityQueue<Integer> pq; // 우선순위 큐
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int m, v;
		jewelry = new Pair[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			jewelry[i] = new Pair(m, v);
		}
		
		bags = new int[K];
		for (int i = 0; i < K; i++) bags[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(bags);
		Arrays.sort(jewelry, (o1, o2) -> Integer.compare(o1.m, o2.m));
		
		pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		
		price = 0L;
		int i = 0;
		for (int bag : bags) {
			while (i < N && jewelry[i].m <= bag) {
				pq.add(jewelry[i].v);
				i++;
			}
			if (!pq.isEmpty()) price += pq.poll();
		}
		
		System.out.println(price);
	}
}


class Pair {
	int m;
	int v;
	
	Pair(int m, int v) {
		this.m = m;
		this.v = v;
	}
}