// 숨바꼭질 3 (13549번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static final int MAX = 100_001;
	
	static int bfs(int n, int k) {
		boolean[] visited = new boolean[MAX]; // K의 2배로 선언
		Deque<Pair> queue = new LinkedList<>();
		queue.add(new Pair(N, 0));
		visited[N] = true;
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			if (pair.n == K) return pair.cnt;
			
			// 2배 점프하는 비용은 0이므로 큐의 앞에 삽입
			if (pair.n * 2 < MAX && !visited[pair.n * 2]) {
				visited[pair.n * 2] = true;
				queue.addFirst(new Pair(pair.n * 2, pair.cnt));
			}
			
			// -1, +1하는 비용은 1이므로 큐의 뒤에 삽입
			if (pair.n - 1 >= 0 && !visited[pair.n - 1]) {
				visited[pair.n - 1] = true;
				queue.addLast(new Pair(pair.n - 1, pair.cnt + 1));
			}
			
			if (pair.n + 1 < MAX && !visited[pair.n + 1]) {
				visited[pair.n + 1] = true;
				queue.addLast(new Pair(pair.n + 1, pair.cnt + 1));
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bw.write(bfs(N, K) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair {
	int n;
	int cnt;
	
	Pair(int n, int cnt) {
		this.n = n;
		this.cnt = cnt;
	}
}