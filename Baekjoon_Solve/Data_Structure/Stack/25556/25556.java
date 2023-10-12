// 포스택 (25556번)
import java.io.*;
import java.util.*;

public class Main {
	
	static Stack<Integer>[] stacks = new Stack[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 4; i++) {
			stacks[i] = new Stack<>();
		}
		
		boolean check = true;
		for (int i = 0; i < N; i++) {
			int num = arr[i];
			boolean flag = false;
			for (int j = 0; j < 4; j++) {
				// 스택이 비어있거나 스택의 마지막 요소보다 현재 숫자가 더 크면 삽입 후 break
				if (stacks[j].isEmpty() || stacks[j].peek() < num) {
					flag = true;
					stacks[j].add(num);
					break;
				}
			}
			
			if (!flag) {
				check = false;
				break;
			}
		}
		
		if (check) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}
		
		bw.flush();
		bw.close();
		br.close();
	} 
}