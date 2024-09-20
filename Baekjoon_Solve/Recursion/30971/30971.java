// 육회비빔밥 (30971번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] A, B, C;
	static boolean[] visited;
	static int ans = -1;
	
	static void backtrack(int last, int cur, int cnt, int total) {
		int k = C[last] * C[cur];
		if (k > K) {
			return;
		}
		total += (A[last] * B[cur]);
		if (cnt == N) {
			ans = Math.max(ans, total);
			return;
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				backtrack(cur, i, cnt + 1, total);
				visited[i] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1];
		B = new int[N + 1];
		C = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) B[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) C[i] = Integer.parseInt(st.nextToken());
	
		visited = new boolean[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			visited[i] = true;
			backtrack(0, i, 1, 0);
			visited[i] = false;
		}
		
		System.out.println(ans);
	}
}
