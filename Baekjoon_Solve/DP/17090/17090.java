// 미로 탈출하기 (17090번)
import java.io.*;
import java.util.*;

public class Main {
	
	static HashMap<Character, int[]> hashMap;
	static int N, M;
	static String[] graph;
	static int[][] memo;
	static void init(int n, int m) {
		hashMap = new HashMap<>();
		hashMap.put('U', new int[] {-1, 0});
		hashMap.put('R', new int[] {0, 1});
		hashMap.put('D', new int[] {1, 0});
		hashMap.put('L', new int[] {0, -1});		
		memo = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(memo[i], -1);
		}
		graph = new String[n];
	}
	
	static int recur(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return 1;
		}
		if (memo[r][c] != -1) {
			return memo[r][c];
		}
		int cnt = 0;
		memo[r][c] = cnt; // 무한 루프 방지
		int nr = r + hashMap.get(graph[r].charAt(c))[0];
		int nc = c + hashMap.get(graph[r].charAt(c))[1];
		cnt = recur(nr, nc);
		memo[r][c] = cnt;
		return memo[r][c];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init(N, M);
		
		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine();
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cnt += recur(i, j);
			}
		}
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}