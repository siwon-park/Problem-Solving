// 이진수 게임 (18112번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = (1 << 10) - 1; // 최대 비트
	static int L, K;
	static int[] visited = new int[MAX + 1];
	
	// 이진수를 정수형으로 바꾸는 함수
	static int binToInt(String str) {
		int ret = 0;
		int n = str.length();
		for (int i = 0; i < n; i++) {
			ret *= 2;
			if (str.charAt(i) == '1') {
				ret += 1;
			}
		}
		return ret;
	}
	
	static int bfs() {
		Arrays.fill(visited, -1); // 간선의 가중치가 같기 때문에 -1일 때만 갱신
		Queue<Integer> queue = new LinkedList<>();
		queue.add(L);
		visited[L] = 0;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (num == K) {
				return visited[num];
			}
			// 특정 자리 비트 토글링 -> 비트 XOR 연산(단, 맨 앞자리는 변경 x)
			for (int i = 0; i < 10; i++) {
				// 맨 앞자리 비트를 제외하고 토글링을 하려면 i + 1번째 비트가 1인 수의 최솟값보다는 작아야함
				if (1 << (i + 1) > num) continue;
				int nxtNum = num ^ (1 << i);
				if (visited[nxtNum] == -1) {
					visited[nxtNum] = visited[num] + 1;
					queue.add(nxtNum);
				}
			}
			
			// 현재 수 + 1 (단, MAX 이하)
			if (num + 1 <= MAX && visited[num + 1] == -1) {
				visited[num + 1] = visited[num] + 1;
				queue.add(num + 1);
			}
			
			// 현재 수 - 1 (단, 0 초과)
			if (num - 1 >= 0 && visited[num - 1] == -1) {
				visited[num - 1] = visited[num] + 1;
				queue.add(num - 1);
			}
		}
		
		return visited[K];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String binL = br.readLine();
		String binK = br.readLine();
		
		L = binToInt(binL);
		K = binToInt(binK);
		
		int ans = bfs();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
