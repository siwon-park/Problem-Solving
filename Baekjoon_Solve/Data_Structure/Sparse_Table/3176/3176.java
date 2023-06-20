// 도로 네트워크 (3176번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int LOG = 18;
	static int N, K, min, max; // 도시의 수, 쿼리의 수
	static int[] level;
	static int[][] parent, minDist, maxDist; // 부모 배열, 최소 경로, 최대 경로
	static ArrayList<ArrayList<int[]>> graph; // 그래프
	
	static void setParent() {
		parent[1][0] = 1;
		for (int k = 0; k < LOG - 1; k++) {
			for (int n = 1; n < N + 1; n++) {
				if (parent[n][k] != -1) parent[n][k + 1] = parent[parent[n][k]][k];
			}
		}
	}
	
	static void setDistance() {
		for (int k = 0; k < LOG - 1; k++) {
			for (int n = 1; n < N + 1; n++) {
				if (parent[n][k] != -1) {
					minDist[n][k + 1] = Math.min(minDist[parent[n][k]][k], minDist[n][k]);
					maxDist[n][k + 1] = Math.max(maxDist[parent[n][k]][k], maxDist[n][k]);
				}
			}
		}
		minDist[1][0] = 0;
		maxDist[1][0] = 0;
	}
	
	static void dfs(int cur, int lv) {
		level[cur] = lv;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i)[0];
			int cost = graph.get(cur).get(i)[1];
			if (level[nxt] == -1) {
				parent[nxt][0] = cur;
				minDist[nxt][0] = cost;
				maxDist[nxt][0] = cost;
				dfs(nxt, lv + 1);
			}
		}
	}
	
	static int findLCA(int a, int b) {
		if (level[a] < level[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		int diff = level[a] - level[b];
		for (int i = 0; diff > 0; i++) {
			if (diff % 2 != 0) {
				min = Math.min(min, minDist[a][i]);
				max = Math.max(max, maxDist[a][i]);
				a = parent[a][i];
			}
			diff /= 2;
		}
		
		if (a == b) return a;
		if (a != b) {
			for (int i = LOG - 1; i >= 0; i--) {
				if (parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
					min = Math.min(min, Math.min(minDist[a][i], minDist[b][i]));
					max = Math.max(max, Math.max(maxDist[a][i], maxDist[b][i]));
					a = parent[a][i];
					b = parent[b][i];
				}
			}
		}
		
		min = Math.min(min, Math.min(minDist[a][0], minDist[b][0]));
		max = Math.max(max, Math.max(maxDist[a][0], maxDist[b][0]));
		return parent[a][0];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		level = new int[N + 1];
		Arrays.fill(level, -1);
		minDist = new int[N + 1][LOG];
		maxDist = new int[N + 1][LOG];
		parent = new int[N + 1][LOG];
		
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
			Arrays.fill(minDist[i], Integer.MAX_VALUE);
			Arrays.fill(maxDist[i], Integer.MIN_VALUE);
			Arrays.fill(parent[i], -1);
		}
		
		int A, B, C;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			graph.get(A).add(new int[] {B, C});
			graph.get(B).add(new int[] {A, C});
		}
		
		dfs(1, 0);
		setParent();
		setDistance();
		
		K = Integer.parseInt(br.readLine());
		int D, E, LCA;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			LCA = findLCA(D, E);

			bw.write(min + " " + max + "\n");	
		}
		
		bw.flush();
		br.close();
		bw.close();
	}	
}