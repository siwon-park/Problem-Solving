// k개 트리 노드에서 사과와 배를 최대로 수확하기 (25976번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k;
	static int[] appleAndPear;
	static ArrayList<ArrayList<Integer>> graph;
	
	static int[] bfs() {
		int cnt = 0; // 사과 x 배의 개수
		int a = 0; // 사과의 개수
		int p = 0; // 배의 개수
		boolean[][] visited = new boolean[n][1 << n];
		visited[0][1] = true;
		Pair s = new Pair(0, 1, 0, 0, 1); // 현재 노드, 비트, 사과, 배, k
		if (appleAndPear[0] == 1) { // 루트 노드가 사과일 경우
			s.apple = 1;
		} else if (appleAndPear[0] == 2) {
			s.pear = 1;
		}
		Queue<Pair> queue = new LinkedList<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			if (pair.apple * pair.pear > cnt) { // 사과 x 배의 개수가 더 많은 경우
				cnt = pair.apple * pair.pear;
				a = pair.apple;
				p = pair.pear;
			} else if (pair.apple * pair.pear == cnt) { // 개수는 같은데 사과가 더 많을 경우
				if (pair.apple > a) {
					a = pair.apple;
					p = pair.pear;					
				} else if (pair.apple == a && pair.pear > p) {
					a = pair.apple;
					p = pair.pear;
				}
			}
			// 다음 노드 순회
			for (int i = 0; i < graph.get(pair.cur).size(); i++) {
				int nxt = graph.get(pair.cur).get(i);
				int nxtBit = pair.bit | (1 << nxt); // 다음 비트
				// 이미 방문한 노드인 경우 -> 현재 비트를 가지고 다음 노드를 방문하지 않았을 때만 방문
				if ((pair.bit & (1 << nxt)) > 0 && !visited[nxt][pair.bit]) {
					visited[nxt][pair.bit] = true;
					queue.add(new Pair(nxt, pair.bit, pair.apple, pair.pear, pair.k));
				}
				// 방문하지 않은 노드인 경우 -> 방문하고 k를 증가 + 사과나 배의 개수 갱신
				else if ((pair.bit & (1 << nxt)) == 0 && !visited[nxt][nxtBit] && pair.k + 1 <= k) {
					visited[nxt][nxtBit] = true;
					int nxtK = pair.k + 1;
					if (appleAndPear[nxt] == 1) { // 사과인 경우
						queue.add(new Pair(nxt, nxtBit, pair.apple + 1, pair.pear, nxtK));
					} else if (appleAndPear[nxt] == 2) { // 배인 경우
						queue.add(new Pair(nxt, nxtBit, pair.apple, pair.pear + 1, nxtK));
					} else { // 아무고토 아닌 경우
						queue.add(new Pair(nxt, nxtBit, pair.apple, pair.pear, nxtK));
					}
				}
			}
		}
		
		return new int[] {a, p};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(p).add(c);
			graph.get(c).add(p);
		}
		
		appleAndPear = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			appleAndPear[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ans = bfs();
		bw.write(ans[0] + " " + ans[1]);
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int cur, bit, apple, pear, k;
	Pair() {}
	Pair(int cur, int bit, int apple, int pear, int k) {
		this.cur = cur;
		this.bit = bit;
		this.apple = apple;
		this.pear = pear;
		this.k = k;
	}
}