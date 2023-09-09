// 비밀번호 제작 (20304번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, max;
	static int[] visited;
	static Queue<Integer> queue;

	static int bfs(int max) {
		while (!queue.isEmpty()) {
			int num = queue.poll();
			for (int i = 0; i < max; i++) {
				int newNum = num ^ (1 << i); // 비트 토글링 연산 -> num과 i번째 비트만 다름
				if (newNum > N) continue;
				if (visited[newNum] > visited[num] + 1) {
					visited[newNum] = visited[num] + 1; // num과 비트가 한 개만 다르니 + 1
					queue.add(newNum);
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N + 1; i++) {
			if (visited[i] > max) continue;
			ans = Math.max(ans, visited[i]);
		}
		return ans;
	}
	
	static int findMax(int n) { // 최대 비트 자리수를 찾음
		int _max = 0;
		while (n > 0) {
			_max += 1;
			n /= 2;
		}
		return _max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visited = new int[N + 1];
		max = findMax(N);
		Arrays.fill(visited, max + 1);
		queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int p = Integer.parseInt(st.nextToken());
			queue.add(p);
			visited[p] = 0;
		}
		
		int ans = bfs(max);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}