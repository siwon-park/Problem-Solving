// 트리의 기둥과 가지 (20924번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, R, G;
	static int[][] arr;
	static boolean[] visited;
	static ArrayList<int[]>[] graph;
	static ArrayList<Integer> leafNodes;
	
	static void init(int n) {
		arr = new int[N + 1][2];
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
		leafNodes = new ArrayList<>();
		G = -1;
	}

	static void dfs(int cur) {
		visited[cur] = true;
		boolean isLeaf = true;
		int cnt = 0; // 자식의 수
		int _max = 0;
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i)[0];
			int d = graph[cur].get(i)[1];
			if (!visited[nxt]) {
				isLeaf = false;
				cnt++;
				dfs(nxt);
				arr[cur][0] += (arr[nxt][0] + d);
				_max = Math.max(_max, arr[nxt][1] + d);
			}
		}
		if (cnt > 1) G = cur;
		if (isLeaf) leafNodes.add(cur);
		arr[cur][1] += _max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		init(N);
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, d});
			graph[b].add(new int[] {a, d});
		}
	
		dfs(R);
		if (G == -1) G = leafNodes.get(0);
		bw.write(Math.abs(arr[R][0] - arr[G][0]) + " " + arr[G][1]);
		bw.flush();
		bw.close();
		br.close();
	}
}