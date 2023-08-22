// 줄서기 (17178번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 사람들의 줄 수
		Pair[] orders = new Pair[N * 5]; // 5명씩 N줄 -> 정렬
		Queue<Pair> outQueue = new LinkedList<>(); // 입구 밖 대기줄
		Stack<Pair> inStack = new Stack<>(); // 안쪽 대기줄
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				String[] tmp = st.nextToken().split("-"); // "-"를 기준으로 문자열 파싱
				Pair pair = new Pair(tmp[0].charAt(0) - '0', Integer.parseInt(tmp[1]));
				orders[i * 5 + j] = pair;
				outQueue.add(pair);
			}
		}
		
		// 티켓 알파벳이 빠르고, 숫자가 빠른 순서대로 정렬
		Arrays.sort(orders, (o1, o2) -> {
			if (o1.c > o2.c) return 1;
			else if (o1.c < o2.c) return -1;
			else return Integer.compare(o1.num, o2.num);
		});
		
		int idx = 0; // 올바른 순서의 인덱스 -> 인덱스 차례대로 들어가야 함
		while (!outQueue.isEmpty()) {
			// 만약 스택이 비어있지 않고, 스택의 마지막에 있는 요소가 올바른 순서이면 스택에서 뽑아서 입장시킴
			while (!inStack.isEmpty() && inStack.peek() == orders[idx]) {
				inStack.pop();
				idx++;
			}
			// 만약 큐의 맨 위에 있는 사람이 현재 순서가 아니면 스택에 넣어서 대기시킴
			if (outQueue.peek() != orders[idx]) inStack.push(outQueue.poll());
			else { // 큐의 맨 위에 있는 사람이 현재 순서가 맞다면 큐에서 뽑아서 제거
				outQueue.poll();
				idx++;
			}
		}
		
		// 만약 스택에 대기하고 있는 사람이 있다면 현재 순서가 맞는지 확인해야 함
		while (!inStack.isEmpty() && inStack.peek() == orders[idx]) {
			inStack.pop();
			idx++;
		}
		
		if (idx == N * 5) bw.write("GOOD");
		else bw.write("BAD");
		bw.flush();
		bw.close();
		br.close();
 	}
}

class Pair {
	int c;
	int num;
	Pair(int c, int num) {
		this.c = c;
		this.num = num;
	}
}