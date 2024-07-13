// 거리가 k이하인 트리 노드에서 사과 수확하기 (25516번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static ArrayList<Integer>[] graph; 
	static int[] apples;
	static boolean[] visited;
	
	static int bfs(int root, int k) {
		int cnt = 0;
		if (apples[root] == 1) cnt += 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {root, 0});
		visited[root] = true;
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int cur = pair[0];
			int d = pair[1];
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i);
				if (d + 1 <= k && !visited[nxt]) {
					visited[nxt] = true;
					if (apples[nxt] == 1) cnt += 1;
					queue.add(new int[] {nxt, d + 1});
				}
			}
		}
		return cnt;
	}
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		visited = new boolean[N];
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[p].add(c);
		}
		
		apples = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) apples[i] = Integer.parseInt(st.nextToken());
		
		int ans = bfs(0, K);
		System.out.println(ans + "");
	}
}
