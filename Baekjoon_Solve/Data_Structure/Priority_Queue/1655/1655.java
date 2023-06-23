// 가운데를 말해요 (1655번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*
		 * 우선순위 큐 2개로 중간값을 찾기위해 필요한 유지 조건
		 * 최소 힙의 첫번째 요소 >= 최대 힙의 첫번째 요소
		 * */
		int N = Integer.parseInt(br.readLine()); // 정수의 개수
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		
		for (int i = 0; i < N; i++) {
			// 최대 힙이 비어있거나 두 힙의 크기가 같다면 최대 힙에 숫자를 삽입하고 아니면 최소 힙에 삽입
			if (maxPQ.isEmpty() || minPQ.size() == maxPQ.size()) maxPQ.add(Integer.parseInt(br.readLine()));
			else minPQ.add(Integer.parseInt(br.readLine()));
			
			// 최소 힙[0] < 최대 힙[0]인 경우, 최소 힙[0] >= 최대 힙[0]을 만족시키기 위해 스왑을 실시함
			while (!minPQ.isEmpty() && !maxPQ.isEmpty() && minPQ.peek() < maxPQ.peek()) {
				int min = minPQ.poll();
				int max = maxPQ.poll();
				minPQ.add(max);
				maxPQ.add(min);
			}
			
			bw.write(maxPQ.peek() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}