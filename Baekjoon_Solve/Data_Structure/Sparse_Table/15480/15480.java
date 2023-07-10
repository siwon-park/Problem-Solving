// LCA와 쿼리 (15480번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int LOG = 18; // 2 ^ 17 = 13만
	static int N, M;
	static int[] depth;
	static int[][] parent;
	static ArrayList<ArrayList<Integer>> graph;
	
	static void dfs(int cur, int d) {
		depth[cur] = d;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i);
			if (depth[nxt] == -1) {
				parent[nxt][0] = cur; // nxt의 2^0번째 부모는 cur
				dfs(nxt, d + 1);
			}
		}
	}
	
	static void setParent() {
		parent[1][0] = 1;
		for (int k = 0; k < LOG - 1; k++) {
			for (int n = 1; n < N + 1; n++) {
				if (parent[n][k] != -1) parent[n][k + 1] = parent[parent[n][k]][k];
			}
		}
	}
	
	static int findLCA(int a, int b) {
		// 깊이가 다르면 깊이를 맞춰줌 -> a가 더 깊은 깊이를 가지게 함
		if (depth[a] < depth[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		// 깊이 차를 0으로 만들면서 노드를 위로 올림
		int diff = depth[a] - depth[b];
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

		N = Integer.parseInt(br.readLine()); // 노드의 수
		graph = new ArrayList<>();
		depth = new int[N + 1];
		parent = new int[N + 1][LOG]; // n의 2^k번째 부모
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
			Arrays.fill(parent[i], -1);
			depth[i] = -1;
		}
		
		StringTokenizer st;
		int u, v;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		dfs(1, 0); // 1을 루트로 하는 트리의 깊이를 찾음
		setParent(); // 희소 배열을 세팅
		
		M = Integer.parseInt(br.readLine()); // 쿼리의 수
		int r, lca1, lca2, lca3; // 루트, lca1, lca2, lca3
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			lca1 = findLCA(r, u); // r과 u의 최소 공통 조상
			lca2 = findLCA(r, v); // r와 v의 최소 공통 조상			
			lca3 = findLCA(u, v); // u와 v의 최소 공통 조상
			// 3개의 lca 중 1과 가장 멀리 떨어져 있는 lca가 r을 루트로 했을 때 u와 v의 lca가 됨.
			if (depth[lca2] >= depth[lca1]) lca1 = lca2;
			if (depth[lca3] >= depth[lca1]) lca1 = lca3;
			
			bw.write(lca1 + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}