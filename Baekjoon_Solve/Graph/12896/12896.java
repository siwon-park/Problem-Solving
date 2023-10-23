// 스크루지 민호 (12896번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	static void dfs(int cur, int d, int[] dist) {
		if (dist[cur] >= 0) return;
		dist[cur] = d;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i);
			dfs(nxt, d + 1, dist);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		int[] dist1 = new int[N + 1];
		Arrays.fill(dist1, -1);
		// 거리가 가장 먼 노드와 거리를 찾음
		dfs(1, 0, dist1);		
		int d = 0; // 거리
		int fn = 0; // 가장 먼 노드
		for (int i = 1; i < N + 1; i++) {
			if (dist1[i] > d) {
				d = dist1[i];
				fn = i;
			}
		}
		
		// 가장 먼 노드에서 다시 가장 멀리 떨어진 노드를 찾음 -> 트리의 지름
		int[] dist2 = new int[N + 1];
		Arrays.fill(dist2, -1);
		dfs(fn, 0, dist2);
		d = 0;
		for (int i = 1; i < N + 1; i++) {
			if (dist2[i] > d) {
				d = dist2[i];
			}
		}
		
		int ans = 0;
		if (d % 2 == 0) {
			ans = d / 2;
		} else {
			ans = d / 2 + 1;
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}