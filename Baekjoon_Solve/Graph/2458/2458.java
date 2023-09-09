// 키 순서 (2458번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] graph;
	
	static void floyd() {
		for (int k = 1; k < N + 1; k++) {
			for (int a = 1; a < N + 1; a++) {
				for (int b = 1; b < N + 1; b++) {
					if (graph[a][k] == -1 || graph[k][b] == -1) continue;
					graph[a][b] = 1; // 거쳐갈 수 있으면 1로 마킹
				}
			}
		}
	}
	
	static boolean findOrder(int n) { // 정확한 순서를 찾을 수 있는지 확인하는 함수
		int cnt = 1;
		for (int i = 1; i < N + 1; i++) {
			if (i == n) continue; // 자기 자신이면 제외
			if (graph[n][i] == -1) { // 자기 자신보다 작은 경우
				if (graph[i][n] != -1) cnt += 1; // 작은 노드에서 자기 자신으로 올 수 있으면 += 1 
			} else cnt += 1; // 자기 자신보다 큰 노드인 경우 += 1
		}
		if (cnt == N) return true; // 합이 정확히 N이면 순서를 알 수 있음
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; i++) Arrays.fill(graph[i], -1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
		}
		
		floyd();
		
		int ans = 0;
		for (int i = 1; i < N + 1; i++) {
			boolean flag = findOrder(i);
			if (flag) ans += 1;
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}