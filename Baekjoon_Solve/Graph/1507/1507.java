// 궁금한 민호 (1507번)
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] path;
	
	static int floyd() {
		boolean[][] unUsed = new boolean[N + 1][N + 1];
		for (int k = 1; k <= N; k++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					if (a == b || b == k || a == k) continue;
					// a -> k -> b == a -> b이면 a -> b 간선을 사용하지 않음; a -> k -> b 간선을 사용하겠다
					if (path[a][k] + path[k][b] == path[a][b]) {
						unUsed[a][b] = true;
					} else if (path[a][b] > path[a][k] + path[k][b]) { // 최단 경로 조건에 위배되면 -1 리턴
						return -1;
					}
				}
			}
		}
		
		// a < b인 정점 간 삭제되지 않은 경로의 합의 값들만 더 함
		int ans = 0;
		for (int a = 1; a <= N; a++) {
			for (int b = a + 1; b <= N; b++) {
				if (!unUsed[a][b]) ans += path[a][b];
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		path = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				path[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = floyd();
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();	
	}
}

