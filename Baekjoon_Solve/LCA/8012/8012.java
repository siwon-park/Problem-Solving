// 한동이는 영업사원! (8012번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M; // 도시 숫자, 방문할 도시 숫자
	static final int LOG = 16; // 2 ^ 15 = 32768
	static int[] depth;
	static int[][] parent;
	static ArrayList<ArrayList<Integer>> graph;
	
	/*
	 * 희소 배열을 세팅함
	 * */
	static void setParent() {
		parent[1][0] = 1; // 1번의 첫번째 부모는 1
		for (int k = 0; k < LOG - 1; k++) {
			for (int n = 1; n < N + 1; n++) {
				if (parent[n][k] != -1) parent[n][k + 1] = parent[parent[n][k]][k];
			}
		}
	}
	
	/*
	 * 깊이를 구하는 dfs
	 * */
	static void dfs(int cur, int d) {
		depth[cur] = d;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i);
			if (depth[nxt] == -1) {
				parent[nxt][0] = cur; // nxt의 첫번째 부모는 cur
				dfs(nxt, d + 1);
			}
		}
	}
	
	/*
	 * LCA를 찾는 함수
	 * */
	static int findLCA(int a, int b) {
		// a의 깊이를 더 깊게 함
		if (depth[a] < depth[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		int diff = depth[a] - depth[b];
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
		// 배열 & 그래프 초기화
		graph = new ArrayList<>();
		depth = new int[N + 1];
		parent = new int[N + 1][LOG];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(parent[i], -1);
			graph.add(new ArrayList<>());
		}
		Arrays.fill(depth, -1);
		
		// 그래프 연결
		int a, b;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		// 방문해야할 도시들이 순서대로 주어짐
		M = Integer.parseInt(br.readLine());
		int[] arr = new int[M + 1];
		arr[0] = 1; // 1번 도시부터 항상 출발함
		for (int i = 1; i < M + 1; i++) arr[i] = Integer.parseInt(br.readLine());
		
		dfs(1, 0); // 1번 정점에서 출발, 1번 정점의 깊이는 0
		setParent(); // 희소 배열을 세팅
		
		int ret = 0;
		for (int i = 0; i < M; i++) {
			int cur = arr[i];
			int nxt = arr[i + 1];
			int lca = findLCA(cur, nxt); // cur와 nxt의 공통 조상
			// cur -> lca -> nxt로 가는 시간을 구함
			if (lca != cur && lca != nxt) {
				ret += depth[cur] + depth[nxt] - 2 * depth[lca]; 
			} else if (lca == cur) {
				ret += depth[nxt] - depth[lca];
			} else if (lca == nxt) {
				ret += depth[cur] - depth[lca];
			}
		}
		
		System.out.println(ret);
	}
}