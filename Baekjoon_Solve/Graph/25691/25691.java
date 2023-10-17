// k개 트리 노드에서 사과를 최대로 수확하기 (25691번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k, max;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] apples;
	
	static int bfs() {
		int cnt = 0;
		boolean[][] visited = new boolean[n][max + 1];
		if (apples[0] == 1) cnt += 1; // 루트가 사과일 경우
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 1, cnt, 1)); // 현재 노드, 비트, 사과의 수, 방문한 노드 수
		visited[0][1] = true;;
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			cnt = Math.max(cnt, pair.cnt);
			for (int i = 0; i < graph.get(pair.cur).size(); i++) {
				int nxt = graph.get(pair.cur).get(i);
				if ((pair.bit & (1 << nxt)) == 0) { // 아직 방문하지 않은 노드이면 방문
					int nxtBit = pair.bit | (1 << nxt);
					if (pair.k + 1 <= k && !visited[nxt][nxtBit]) {
						visited[nxt][nxtBit] = true;
						if (apples[nxt] == 1) {
							queue.add(new Pair(nxt, nxtBit, pair.cnt + 1, pair.k + 1));							
						} else {
							queue.add(new Pair(nxt, nxtBit, pair.cnt, pair.k + 1));							
						}
					}
				} else if ((pair.bit & (1 << nxt)) > 0) { // 방문한 노드인 경우
					int nxtBit = pair.bit | (1 << nxt);
					if (!visited[nxt][nxtBit]) { // 사과의 수가 클 때만 갱신, 방문 노드수 k는 갱신 x
						visited[nxt][nxtBit] = true;
						queue.add(new Pair(nxt, nxtBit, pair.cnt, pair.k));
					}
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(p).add(c);
			graph.get(c).add(p);
		}
		
		st = new StringTokenizer(br.readLine());
		apples = new int[n];
		for (int i = 0; i < n; i++) {
			apples[i] = Integer.parseInt(st.nextToken());
		}
		
		max = (1 << n) - 1;
		
		int ans = bfs();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int cur, bit, cnt, k;
	Pair() {}
	
	Pair(int cur, int bit, int cnt, int k) {
		this.cur = cur;
		this.bit = bit;
		this.cnt = cnt;
		this.k = k;
	}
}