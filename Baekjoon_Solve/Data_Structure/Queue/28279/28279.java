// 덱 2 (28279번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 쿼리의 수
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			if (op == 1) { // 정수 X를 덱 맨 앞에 삽입
				int X = Integer.parseInt(st.nextToken());
				deque.addFirst(X);
			} else if (op == 2) { // 정수 X를 덱 맨 뒤에 삽입
				int X = Integer.parseInt(st.nextToken());
				deque.addLast(X);
			} else if (op == 3) { // 덱의 맨 앞을 확인하고 뽑음
				if (deque.isEmpty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(deque.pollFirst() + "\n");
				}
			} else if (op == 4) { // 덱의 맨 뒤를 확인하고 뽑음
				if (deque.isEmpty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(deque.pollLast() + "\n");
				}
			} else if (op == 5) { // 덱의 사이즈 확인
				bw.write(deque.size() + "\n");
			} else if (op == 6) { // 덱이 비어있는지 확인
				if (deque.isEmpty()) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
			} else if (op == 7) { // 덱의 맨 앞의 요소 확인
				if (deque.isEmpty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(deque.peekFirst() + "\n");
				}
			} else if (op == 8) { // 덱의 맨 뒤의 요소 확인
				if (deque.isEmpty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(deque.peekLast() + "\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();		
	}
}
