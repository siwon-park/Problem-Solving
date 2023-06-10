// 은하철도 (17250번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) {
			parent[b] = a;
			planet[a] += planet[b];
			planet[b] = 0;
		}
		else {
			parent[a] = b;
			planet[b] += planet[a];
			planet[a] = 0;
		}
	}
	
	static int N, M; // 은하의 개수, 철도의 개수
	static int[] parent;
	static long[] planet;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		planet = new long[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
			planet[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (find(a) != find(b)) { // 서로 연결되어 있지 않으면 연결함
				union(a, b);
			}
			bw.write(planet[find(a)] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}