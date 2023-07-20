// 수 묶기 (1744번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> lst1 = new ArrayList<>();
		ArrayList<Integer> lst2 = new ArrayList<>();		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num <= 0) lst1.add(num);
			else lst2.add(num);
		}
		
		Collections.sort(lst1); // 음수 오름차순 정렬
		Collections.sort(lst2, Collections.reverseOrder()); // 양수 내림차순 정렬
		Queue<Integer> queue1 = new LinkedList<>();
		queue1.addAll(lst1);
		Queue<Integer> queue2 = new LinkedList<>();
		queue2.addAll(lst2);
		
		int ans = 0;
		int n1, n2, sum, mul;
		while (queue1.size() >= 2) {
			n1 = queue1.poll();
			n2 = queue1.poll();
			sum = n1 + n2;
			mul = n1 * n2;
			if (sum > mul) ans += sum;
			else ans += mul;
		}
		
		while (queue2.size() >= 2) {
			n1 = queue2.poll();
			n2 = queue2.poll();
			sum = n1 + n2;
			mul = n1 * n2;
			if (sum > mul) ans += sum;
			else ans += mul;
		}
		
		while (!queue1.isEmpty()) ans += queue1.poll();
		while (!queue2.isEmpty()) ans += queue2.poll();
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}