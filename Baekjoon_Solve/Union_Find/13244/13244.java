// Tree (13244번)
import java.io.*;
import java.util.*;

public class Main {

	static int T, N, M; // 테스트 케이스, 노드 수, 간선 수
	static int[] parent; // 부모
	
	static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			parent = new int[N + 1];
			for (int i = 0; i < N + 1; i++) parent[i] = i;
			
			StringTokenizer st;
			int a, b;
			boolean flag = true; // 트리 유무 -> true: 트리, false: 그래프
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if (find(a) == find(b)) flag = false;
				else union(a, b);
			}
			
			// true일 경우 모두 연결되어 있는지 확인
			if (flag) {
				for (int i = 1; i < N + 1; i++) {
					find(i);
					if (parent[i] != 1) {
						flag = false;
						break;
					}
				}
			}
			
			bw.write((flag) ? "tree" + "\n" : "graph" + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}