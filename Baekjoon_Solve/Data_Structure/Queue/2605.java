// 줄 세우기 (2605번)
import java.io.*;
import java.util.*;

public class Main {
	
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (arr[i] == 0) {
				deque.add(i + 1);
			} else {
				stack = new Stack<>();
				int m = arr[i];
				while (m-- > 0 && !deque.isEmpty()) {
					stack.add(deque.pollLast());
				}
				deque.add(i + 1);
				while (!stack.isEmpty()) {
					deque.add(stack.pop());
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			sb.append(deque.pollFirst());
			sb.append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}