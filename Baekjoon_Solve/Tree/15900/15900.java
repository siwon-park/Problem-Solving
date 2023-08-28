// 나무 탈출 (15900번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	
	static long dfs(int cur, int d) {
		long dist = 0;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i);
			if (!visited[nxt]) {
				visited[nxt] = true;
				dist += dfs(nxt, d + 1);
			}
		}
		dist = Math.max(dist, d);
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine()); // 정점의 개수
		visited = new boolean[N + 1];
		
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
		
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		visited[1] = true;
		long d = dfs(1, 0);
		
		// 리프 -> 루트까지 거리의 합이 짝수면 No, 홀수면 Yes
		if (d % 2 == 0) bw.write("No");
		else bw.write("Yes");
		bw.flush();
		bw.close();
		br.close();
	}
}