// 트리의 독립집합 (2213번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr;
	static int[][] dp;
	static boolean[] visited;
	static ArrayList<Integer> subSet = new ArrayList<>();
	static ArrayList<Integer>[] graph;
	
	
	static void dfs(int cur) {
		visited[cur] = true;
		dp[cur][0] = arr[cur]; // 현재 노드 선택 -> 다음 노드 선택 불가
		dp[cur][1] = 0; // 현재 노드 선택 x -> 다음 노드 선택 유무는 모름
		for (int i = 0; i < graph[cur].size(); i++) {
			int nxt = graph[cur].get(i);
			if (!visited[nxt]) {
				dfs(nxt);
				dp[cur][0] += dp[nxt][1];
				dp[cur][1] += Math.max(dp[nxt][0], dp[nxt][1]); // 다음 노드를 선택한 값과 선택하지 않았을 때의 값 중 최댓값 택
			}
		}		
		return;
	}
	
	static void trace(int cur, boolean pre) {
		visited[cur] = true;
		if (pre) { // 이전 노드를 부분집합에 포함시켰음 -> 현재노드 포함 불가능, 다음 노드 포함
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i);
				if (!visited[nxt]) {
					trace(nxt, false);
				}
			}
		} else { // 포함시키지 않음 -> 현재 노드 삽입 가능 (체크 후 삽입)
			if (dp[cur][0] > dp[cur][1]) { // 현재 노드를 포함했을 때가 더 크면 현재 노드를 부분 집합에 추가
				subSet.add(cur);
				for (int i = 0; i < graph[cur].size(); i++) {
					int nxt = graph[cur].get(i);
					if (!visited[nxt]) {
						trace(nxt, true);
					}
				}
			} else {
				for (int i = 0; i < graph[cur].size(); i++) {
					int nxt = graph[cur].get(i);
					if (!visited[nxt]) {
						trace(nxt, false);
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1][2];
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		graph[0] = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		dfs(1);
		visited = new boolean[N + 1];
		trace(1, false);
		Collections.sort(subSet);
		
		bw.write(Math.max(dp[1][0], dp[1][1]) + "\n");
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < subSet.size(); i++) {
			sb.append(subSet.get(i));
			sb.append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
