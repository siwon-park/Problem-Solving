// 크게 만들기 (2812번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String tmp = br.readLine();
		Stack<Integer> stack = new Stack<>(); // 스택
	
		for (int i = 0; i < N; i++) { // 1번 인덱스부터 시작
			int num = tmp.charAt(i) - '0';
			// 스택의 맨 위에 있는 수가 현재 숫자보다 작은 동안 반복 + K가 0보다 큰 동안
			while (!stack.isEmpty() && stack.peek() < num && K > 0) { 
				stack.pop(); // 스택에서 뽑고 삽입 후, 삭제 횟수에 반영
				K--;
			}
			stack.add(num);
		}
		
		// 만약 숫자가 내림차순으로 주어진 경우가 많아서 아직 K개를 다 제거하지 못했을 때 스택의 뒤에서 부터 삭제
		while (K-- > 0) stack.pop();
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) sb.append(stack.pop());
		
		bw.write(sb.reverse().toString());
		bw.flush();
		bw.close();
		br.close();
 	}
}