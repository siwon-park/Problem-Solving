// 주사위 쌓기 (15703번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Stack<Integer>> arrayList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
			arrayList.add(new Stack<>());
		}
		
		int ans = 0; // 주사위 탑의 수
		while (!pq.isEmpty()) {
			int cur = pq.poll(); // 현재 주사위 눈
			boolean flag = false;
			for (int i = 0; i < ans; i++) { // 넣을 수 있는 주사위를 현재 주사위 탑의 수만큼 반복
				Stack<Integer> stack = arrayList.get(i);
				if (stack.size() <= cur) {
					stack.add(cur);
					flag = true;
					break;
				}
			}
			if (!flag) {
				arrayList.get(ans).add(cur);
				ans += 1;
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}