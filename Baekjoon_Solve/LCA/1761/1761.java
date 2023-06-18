// 정점들의 거리 (1761번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M; // 노드의 개수, 쌍의 개수
	static final int LOG = 17; // 2 ^ 16 = 6만
	static ArrayList<ArrayList<int[]>> graph;
	static int[] distance, level; // 거리
	static int[][] parent; // 부모 배열
	
	/*
	 * 희소 배열을 세팅하는 함수
	 * */	
	static void setParent() {
		parent[1][0] = 1;
		for (int k = 0; k < LOG - 1; k++) {
			for (int n = 1; n < N + 1; n++) {
				if (parent[n][k] != -1) parent[n][k + 1] = parent[parent[n][k]][k];
			}
		}
	}
	
	/*
	 * dfs
	 * */
	static void dfs(int cur, int lv, int d) {
		distance[cur] = d;
		level[cur] = lv;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i)[0];
			int cost = graph.get(cur).get(i)[1];
			if (level[nxt] == -1) {
				parent[nxt][0] = cur; // nxt의 첫번째 부모는 cur
				dfs(nxt, lv + 1, d + cost);
			}
		}
	}
	
	static int lca(int a, int b) {
		if (level[a] < level[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		int diff = level[a] - level[b];
		for (int i = 0; diff > 0; i++) {
			if (diff % 2 == 1) a = parent[a][i];
			diff /= 2;
		}
		
		if (a == b) return a;
		for (int i = LOG - 1; i >= 0; i--) {
			if (parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		return parent[a][0];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 정점 a
			int b = Integer.parseInt(st.nextToken()); // 정점 b
			int c = Integer.parseInt(st.nextToken()); // 비용
			graph.get(a).add(new int[] {b, c});
			graph.get(b).add(new int[] {a, c});
		}
		
		distance = new int[N + 1];
		level = new int[N + 1];
		parent = new int[N + 1][LOG];
		for (int i = 0; i < N + 1; i++) Arrays.fill(parent[i], -1); 
		Arrays.fill(level, -1);
		
		dfs(1, 0, 0); // 1번 정점의 거리는 0, 레벨은 0
		setParent(); // 부모 배열 세팅
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int lca = lca(a, b);
			// 두 정점의 거리는 1번 노드에서 a까지의 거리 + 1번 노드에서 b까지의 거리 - 1번 노드에서 lca까지의 거리 * 2
			// 예외) a나 b가 lca일 경우
			if (a == lca) bw.write(distance[b] - distance[a] + "\n");
			else if (b == lca) bw.write(distance[a] - distance[b] + "\n");
			else bw.write(distance[a] + distance[b] - 2 * distance[lca] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}