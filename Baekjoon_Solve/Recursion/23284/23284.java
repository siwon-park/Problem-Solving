// 모든 스택 수열 (23284번)
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	static void recur(int n, int idx, Stack<Integer> stack) {
		if (idx == N) {
			for (int i = 0; i < N - 1; i++) {
				sb.append(arr[i]);
				sb.append(" ");
			}
			sb.append(arr[N - 1] + "\n");
			return;
		} 
		if (!stack.isEmpty()) {
			int num = stack.pop();
			arr[idx] = num;
			recur(n, idx + 1, stack);
			arr[idx] = 0;
			stack.add(num);
		}
		
		if (n < N) {
			stack.add(n + 1);
			recur(n + 1, idx, stack);
			stack.pop();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		recur(0, 0, new Stack<>());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}