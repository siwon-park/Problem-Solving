// 해킹 (10282번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int n, d, c;
	static int[] distance;
	static ArrayList<ArrayList<Pair>> graph;
	
	static void init(int m) {
		graph = new ArrayList<>();
		for (int i = 0; i < m + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		distance = new int[m + 1];
		Arrays.fill(distance, MAX);
	}
	
	static int[] dijkstra(int s) {
		distance[s] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(s, 0));
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.node] < pair.t) continue;
			for (int i = 0; i < graph.get(pair.node).size(); i++) {
				Pair nxt = graph.get(pair.node).get(i);
				int nxtT = pair.t + nxt.t;
				if (nxtT < distance[nxt.node]) {
					distance[nxt.node] = nxtT;
					pq.add(new Pair(nxt.node, nxtT));
				}
			}
		}
		
		int cnt = 0;
		int lastT = 0;
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] != MAX) {
				lastT = Math.max(lastT, distance[i]);
				cnt += 1;
			}
		}
		
		return new int[] {cnt, lastT};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 노드 수
			d = Integer.parseInt(st.nextToken()); // 간선 수
			c = Integer.parseInt(st.nextToken()); // 시작 노드
			init(n);
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				graph.get(b).add(new Pair(a, t)); // b에서 a까지 t초 걸려서 이동
			}
			
			int[] ret = dijkstra(c);
			
			bw.write(ret[0] + " " + ret[1] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair implements Comparable<Pair> {
	int node, t;
	Pair() {}
	Pair(int node, int t) {
		this.node = node;
		this.t = t;
	}
	
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.t, o.t);
	}
}