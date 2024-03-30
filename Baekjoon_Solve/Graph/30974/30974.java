// What's your ETA? (30974번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final Long MAX = Long.MAX_VALUE;
	static int N, M;
	static int[] D;
	static boolean[] isPrime = new boolean[10_000_001];
	static ArrayList<int[]>[] graph;
	
	static void init(int n) {
		D = new int[n + 1];
		checkPrime();
		graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();
//		Arrays.fill(graph, new ArrayList<>());
	}
	
	static void checkPrime() {
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i <= 10_000_000; i++) {
			int j = 2;
			if (isPrime[i]) {
				while (i * j <= 10_000_000) {
					isPrime[i * j] = false;
					j += 1;
				}
			}
		}
	}
	
	static String dijkstra() {
		long[] distance = new long[N + 1];
		Arrays.fill(distance, MAX);
		distance[1] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.w, o2.w));
		pq.add(new Pair(1, 0));
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			int cur = pair.node;
			long curW = pair.w;
			if (distance[cur] < curW) continue;
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i)[0];
				int nxtW = graph[cur].get(i)[1];
				if (curW + nxtW < distance[nxt]) {
					distance[nxt] = curW + nxtW;
					pq.add(new Pair(nxt, distance[nxt]));
				}
			}
		}
		
		if (distance[N] == MAX) return "Now where are you?";
		else return String.valueOf(distance[N]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init(N);
		st = new StringTokenizer(br.readLine()); // 재난 코드 정보
		for (int i = 1; i < N + 1; i++) D[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (isPrime[D[u] + D[v]]) { // u와 v의 버스 정류장 재난 코드 합이 소수일 경우에만 그래프로 연결
				graph[u].add(new int[] {v, w});
				graph[v].add(new int[] {u, w});
			}
		}
		
		String ans = dijkstra();
		System.out.print(ans);
	}
}


class Pair {
	int node;
	long w;
	Pair(int node, long w) {
		this.node = node;
		this.w = w;
	}
}