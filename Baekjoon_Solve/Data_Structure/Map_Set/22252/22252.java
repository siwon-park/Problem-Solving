import java.io.*;
import java.util.*;

public class Main {
	
	static int Q;
	static HashMap<String, PriorityQueue<Integer>> pqHashMap;
	static HashMap<String, Long> valueHashMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Q = Integer.parseInt(br.readLine());
		pqHashMap = new HashMap<>();
		valueHashMap = new HashMap<>();
		
		long value = 0L; // 정보의 총 가치

		int x, k, c, b; // 쿼리의 종류, 가진 정보, 정보의 가치, 구매하려는 정보의 수
		String name; // 고릴라의 이름
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			valueHashMap.putIfAbsent(name, 0L);
			pqHashMap.putIfAbsent(name, new PriorityQueue<Integer>((o1, o2) -> Integer.compare(o2, o1)));
			if (x == 1) { // 고릴라가 정보를 얻음
				k = Integer.parseInt(st.nextToken());
				for (int j = 0; j < k; j++) {
					c = Integer.parseInt(st.nextToken());
					valueHashMap.put(name, valueHashMap.get(name) + c);
					pqHashMap.get(name).add(c);
				}
			} else if (x == 2) { // 고릴라로부터 정보를 구매
				b = Integer.parseInt(st.nextToken());
				PriorityQueue<Integer> pq = pqHashMap.get(name);
				if (pq.size() < b) { // 우선순위 큐의 사이즈가 더 작으면
					value += valueHashMap.get(name); // 갖고 있는 정보의 가치 합을 전부 더함
					valueHashMap.put(name, 0L); // 갖고 있는 정보의 가치를 0으로 만듦
					pqHashMap.put(name, new PriorityQueue<Integer>((o1, o2) -> Integer.compare(o2, o1))); // pq 초기화
				} else {
					while (!pq.isEmpty() && b > 0) {
						c = pq.poll();
						value += c;
						valueHashMap.put(name, valueHashMap.get(name) - c);
						b--;
					}
				}
			}
		}
		
		System.out.println(value);
	}
}