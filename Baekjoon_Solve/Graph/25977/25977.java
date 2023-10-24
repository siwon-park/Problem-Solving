// k개 사과 트리 노드만으로 배를 최대로 수확하기 (25977번)
import java.io.*;
import java.util.*;

public class Main {

	static int n, k;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] appleAndPear;
	
	static int bfs() {
		int cnt = 0;
		boolean[][] visited = new boolean[n][(1 << n)];
		
		Pair s = new Pair(0, 1, 0, 0);
		if (appleAndPear[0] == 1) {
			s.k = 1;
		} else if (appleAndPear[0] == 2) {
			s.cnt = 1;
		}
		
		visited[0][1] = true;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			cnt = Math.max(cnt, pair.cnt);
			for (int i = 0; i < graph.get(pair.cur).size(); i++) {
				int nxt = graph.get(pair.cur).get(i);
				int bit = pair.bit | (1 << nxt);
				// 이미 이전에 nxt에서 사과나 배를 획득했으면 더 이상 획득 x
				if ((pair.bit & (1 << nxt)) > 0 && !visited[nxt][pair.bit]) { 
					visited[nxt][pair.bit] = true;
					queue.add(new Pair(nxt, pair.bit, pair.cnt, pair.k));
				} 
				// 이전에 nxt에서 사과나 배를 획득한 적이 없으면 갱신
				else if ((pair.bit & (1 << nxt)) == 0 && !visited[nxt][bit]) {
					// 사과 노드를 추가로 방문해도 그 수가 k 이하일 때만 방문
					if (appleAndPear[nxt] == 1 && pair.k + 1 <= k) {
						visited[nxt][bit] = true;
						queue.add(new Pair(nxt, bit, pair.cnt , pair.k + 1));
					} else if (appleAndPear[nxt] == 2) {
						visited[nxt][bit] = true;
						queue.add(new Pair(nxt, bit, pair.cnt + 1, pair.k));
					} else if (appleAndPear[nxt] == 0) {
						visited[nxt][bit] = true;
						queue.add(new Pair(nxt, bit, pair.cnt, pair.k));
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
		appleAndPear = new int[n];
		for (int i = 0; i < n; i++) {
			appleAndPear[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = bfs();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int cur, bit, cnt, k;
	Pair(){}
	Pair(int cur, int bit, int cnt, int k) {
		this.cur = cur;
		this.bit = bit;
		this.cnt = cnt;
		this.k = k;
	}
}