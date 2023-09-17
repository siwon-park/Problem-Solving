// 구슬 찾기 (2617번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] graph;
	
	static void floyd() {
		for (int k = 1; k < N + 1; k++) {
			for (int a = 1; a < N + 1; a++) {
				for (int b = 1; b < N + 1; b++) {
					// 경유지 k를 통해 갈 수 없으면 무시하고, 갈 수 있으면 a -> b를 갈 수 있음(1)로 마킹 
					if (graph[a][k] == -1 || graph[k][b] == -1) continue;
					graph[a][b] = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; i++) Arrays.fill(graph[i], -1);
		
		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// a가 b보다 무겁다 -> b에서 a로 갈 수 있다
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[b][a] = 1; 
		}
		
		floyd();
		
		int ans = 0;
		for (int i = 1; i < N + 1; i++) {
			int cnt1 = 0; // 자신보다 작은 구슬의 갯수
			int cnt2 = 0; // 자신보다 큰 구슬의 갯수
			for (int j = 1; j < N + 1; j++) {
				if (i == j) continue;
				if (graph[j][i] == 1) cnt1++; // 자신보다 작다면 j -> i로 갈 수 있어야 함
				else if (graph[i][j] == 1) cnt2++;
			}
			if (cnt1 > N / 2 || cnt2 > N / 2) ans++;
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}