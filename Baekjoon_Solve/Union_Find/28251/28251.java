// 나도리합 (28251번)
import java.util.*;
import java.io.*;

public class Main {

	static int N, Q; // 나도리 수, 쿼리 수
	static int[] parent;
 	static long[][] results; // 0: 그룹의 누적 합, 1: 그룹의 나도리합
	
 	static int find(int x) {
 		if (parent[x] != x) parent[x] = find(parent[x]);
 		return parent[x];
 	}
 	
 	static void union(int a, int b) {
 		a = find(a);
 		b = find(b);
 		parent[b] = a;
 	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		results = new long[N + 1][2];
		parent = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
			results[i][0] = Integer.parseInt(st.nextToken()); 
		}
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int pa = find(a);
			int pb = find(b);
			if (pa != pb) {
				long nadoSum1 = results[pa][1];
				long nadoSum2 = results[pb][1];
				long prefixSum1 = results[pa][0];
				long prefixSum2 = results[pb][0];
				results[pa][0] = prefixSum1 + prefixSum2;
				results[pb][0] = results[pa][0];
				results[pa][1] = prefixSum1 * prefixSum2 + nadoSum1 + nadoSum2;
				results[pb][1] = results[pa][1];
				union(a, b);
			}
			bw.write(results[pa][1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}

