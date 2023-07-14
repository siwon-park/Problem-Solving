// 가장 가까운 공통 조상 (3584번)
import java.io.*;
import java.util.*;

public class Main {

	static final int LOG = 15; // 2 ^ 14 = 16384 > 10000
	static int T, N, A, B;
	static int[] depth, P;
	static int[][] parent;
	static ArrayList<ArrayList<Integer>> graph;
	
	
	static void dfs(int cur, int d) {
		depth[cur] = d;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i);
			if (depth[nxt] == -1) {
				parent[nxt][0] = cur;
				dfs(nxt, d + 1);
			}
		}
	}
	
	
	static void setParent(int p) {
		parent[p][0] = p;
		for (int k = 0; k < LOG - 1; k++) {
			for (int n = 1; n < N + 1; n++) {
				if (parent[n][k] != -1) parent[n][k + 1] = parent[parent[n][k]][k];
			}
		}
	}
	
	
	static int findLCA(int a, int b) {
		if (depth[a] < depth[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
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
		
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			depth = new int[N + 1];
			Arrays.fill(depth, -1);
			parent = new int[N + 1][LOG];
			graph = new ArrayList<>();
			P = new int[N + 1];
			for (int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
				Arrays.fill(parent[i], -1);
			}
			
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
				graph.get(A).add(B);
				graph.get(B).add(A);
				P[B] = A;
			}
			
			
			int pn = 1;
			for (int i = 1; i < N + 1; i++) {
				if (P[i] == 0) pn = i;
			}
			
			dfs(pn, 0);
			setParent(pn);
			
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			bw.write(findLCA(A, B) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}