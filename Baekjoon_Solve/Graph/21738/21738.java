// 얼음깨기 펭귄 (21738번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, S, P;
	static int[] distance;
	static boolean[] holder, visited;
	static ArrayList<Integer>[] graph;
	
	static void dfs(int cur, int d) {
		visited[cur] = true;
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i);
			if (!visited[nxt]) {
				distance[nxt] = d + 1;
				dfs(nxt, d + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 얼음 블록의 수
		S = Integer.parseInt(st.nextToken()); // 지지대의 수
		P = Integer.parseInt(st.nextToken()); // 펭귄의 위치
		
		holder = new boolean[N + 1];
		visited = new boolean[N + 1];
		distance = new int[N + 1];
		for (int i = 1; i < S + 1; i++) holder[i] = true;
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		dfs(P, 0);
		ArrayList<Integer> results = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			if (holder[i]) {
				results.add(distance[i]);
			}
		}
		
		Collections.sort(results);
		System.out.println(N - 1 - results.get(0) - results.get(1));
	}
}

