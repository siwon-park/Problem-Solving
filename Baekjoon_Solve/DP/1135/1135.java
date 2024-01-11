// 뉴스 전하기 (1135번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] dp;
	static boolean[] visited;

	static void init(int n) {
		graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();
	}
	
	static void recur(int cur) {
		visited[cur] = true;
		
		ArrayList<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i);
			if (!visited[nxt]) {
				recur(nxt);
				tmp.add(dp[nxt] + 1);
			}
		}
		
		tmp.sort(Collections.reverseOrder()); // 역순 정렬 -> 비용이 가장 많이드는 것부터 먼저 처리
		int max = 0;
		int cnt = 0; // 순차적으로 처리하는데 드는 순서만큼 시간 누적
		for (int i = 0; i < tmp.size(); i++) {
			max = Math.max(max, tmp.get(i) + cnt++);
		}
		dp[cur] = max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		init(N);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if (p == -1) continue;
			else {
				graph[i].add(p);
				graph[p].add(i);
			}
		}

		dp = new int[N + 1];
		visited = new boolean[N + 1];
		recur(0);
		bw.write(dp[0] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}