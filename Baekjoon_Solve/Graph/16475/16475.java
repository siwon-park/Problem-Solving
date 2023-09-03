// 수학 미로 (16475번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final long INF = Long.MAX_VALUE;
	static int N, M, K, L, P, S, E;
	static long[][][] distance;
	static boolean[] trap;
	static ArrayList<ArrayList<Node>>[] graph;
	
	static void dijkstra(int s) {
		distance[0][0][s] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.d, o2.d));
		pq.add(new Pair(s, 0, 0, 0));
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.r][pair.p][pair.n] < pair.d) continue;
			for (int i = 0; i < graph[pair.r].get(pair.n).size(); i++) {
				Node node = graph[pair.r].get(pair.n).get(i);
				int p = pair.p;
				int r = pair.r;
				if (trap[node.nxt]) { // 이동한 곳이 함정이면 스위치를 누름
					p += 1;
					if (p == P) r = (r == 0) ? 1 : 0; // 반전
					p %= P;
				}
				long nCost = pair.d + node.cost;
				if (nCost < distance[r][p][node.nxt]) {
					distance[r][p][node.nxt] = nCost;
					pq.add(new Pair(node.nxt, nCost, p, r));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		K = Integer.parseInt(st.nextToken()); // 함정 지역 수
		L = Integer.parseInt(st.nextToken()); // 함정 간선 수
		P = Integer.parseInt(st.nextToken()); // 스위치 번호
		
		trap = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) trap[Integer.parseInt(st.nextToken())] = true;
		
		graph = new ArrayList[2];
		graph[0] = new ArrayList<>();
		graph[1] = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph[0].add(new ArrayList<>());
			graph[1].add(new ArrayList<>());
		}
		
		int A, B, C;
		for (int i = 0; i < M - L; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			Node node = new Node(B, C);
			graph[0].get(A).add(node);
			graph[1].get(A).add(node);
		}
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			graph[0].get(A).add(new Node(B, C));
			graph[1].get(B).add(new Node(A, C)); // 스위치가 켜지면 역행
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		distance = new long[2][P + 1][N + 1];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < P + 1; j++) {
				Arrays.fill(distance[i][j], INF);
			}
		}

		dijkstra(S);
		
		long ans = INF;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < P + 1; j++) {
				ans = Math.min(ans, distance[i][j][E]);			
			}
		}
		if (ans == INF) ans = -1;
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

class Node {
	int nxt, cost;
	Node(){}
	Node(int nxt, int cost) {
		this.nxt = nxt;
		this.cost = cost;
	}
}

class Pair {
	int n, p, r;
	long d;
	Pair(){};
	Pair(int n, long d, int p, int r) {
		this.n = n;
		this.d = d;
		this.p = p;
		this.r = r;
	}
}