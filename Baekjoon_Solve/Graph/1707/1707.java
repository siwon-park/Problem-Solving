// 이분 그래프 (1707번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int K, V, E;
	static int[] check;
	static ArrayList<ArrayList<Integer>> graph;
	
	static void init(int n) {
		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) graph.add(new ArrayList<>());
		check = new int[n + 1];
		Arrays.fill(check, -1);
	}
	
	static boolean bfs(int s, int c) {
		check[s] = c;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(s, c));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			for (int i = 0; i < graph.get(pair.n).size(); i++) {
				int nxt = graph.get(pair.n).get(i);
				if (check[nxt] == -1) {
					check[nxt] = pair.c ^ 1;
					queue.add(new Pair(nxt, pair.c ^ 1));
				} else if (check[nxt] == pair.c) return false; // 같은 색으로 색칠되어 있으면 false
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < K; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			init(V);
			
			int u, v;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			
			boolean flag = true;
			for (int i = 1; i < V + 1; i++) {
				if (check[i] == -1) {
					flag = bfs(i, 0);
					if (!flag) break;
				}
			}
			
			if (flag) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair {
	int n;
	int c;
	Pair() {}
	Pair(int n, int c) {
		this.n = n;
		this.c = c;
	}
}