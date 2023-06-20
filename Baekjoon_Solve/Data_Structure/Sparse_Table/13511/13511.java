// 트리와 쿼리 2 (13511번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int LOG = 18; // 2 ^ 17 = 13만
	static int N, M; // 정점 수, 쿼리 수
	static int[] level; // 노드의 깊이
	static long[] distance; // 경로의 길이
	static int[][] parent; // 부모 배열
	static ArrayList<ArrayList<int[]>> graph;
	
	/*
	 * 부모 배열 세팅
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
	 * 트리의 깊이와 경로의 길이를 구하는 dfs
	 * */
	static void dfs(int cur, int lv, long d) {
		distance[cur] = d;
		level[cur] = lv;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i)[0];
			int cost = graph.get(cur).get(i)[1];
			if (level[nxt] == -1) {
				parent[nxt][0] = cur;
				dfs(nxt, lv + 1, d + cost);
			}
		}
	}
	
	/*
	 * lca를 찾는 함수
	 * */
	static int findLCA(int a, int b) {
		// 깊이를 조절
		if (level[a] < level[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		int diff = level[a] - level[b];
		for (int i = 0; diff > 0; i++) {
			if (diff % 2 != 0) a = parent[a][i];
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
		level = new int[N + 1];
		Arrays.fill(level, -1);
		distance = new long[N + 1];
		parent = new int[N + 1][LOG];
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(parent[i], -1);
			graph.add(new ArrayList<>());
		}
		
		int u, v, w;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new int[] {v, w});
			graph.get(v).add(new int[] {u, w});
		}
		
		dfs(1, 0, 0);
		setParent();
		
		M = Integer.parseInt(br.readLine());
		int x, k, lca;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			lca = findLCA(u, v);
			if (x == 1) { // 경로의 비용
				if (lca == u) bw.write(distance[v] - distance[lca] + "\n");
				else if (lca == v) bw.write(distance[u] - distance[lca] + "\n");
				else bw.write(distance[u] + distance[v] - 2 * distance[lca] + "\n");
			} else { // k번째 정점 찾기
				k = Integer.parseInt(st.nextToken()) - 1; // 자기 자신을 포함하기 위해 -1
				int diff1 = level[u] - level[lca]; // u -> lca의 차이 
				int diff2 = level[v] - level[lca]; // v -> lca의 차이
				if (k <= diff1) { // k가 u -> lca까지 가는 노드 개수보다 작으면 u의 k번째 부모를 구하면 됨
					for (int j = 0; k > 0; j++) {
						if (k % 2 != 0) u = parent[u][j];
						k /= 2;
					}
					bw.write(u + "\n");
				} else { // k가 u -> lca보다 크다면 v -> lca에서 남은 k를 뺀 v의 k번째 부모를 구하면 됨
					k -= diff1;
					k = diff2 - k;
					for (int j = 0; k > 0; j++) {
						if (k % 2 != 0) v = parent[v][j];
						k /= 2;
					}
					bw.write(v + "\n");
				}
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}