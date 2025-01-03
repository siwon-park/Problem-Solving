// Explorace (15835번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] parent;
	static ArrayList<int[]> arrayList;
	
	static void init(int n) {
		parent = new int[n + 1];
		for (int i = 0; i < n + 1; i++) parent[i] = i;
		arrayList = new ArrayList<>();
	}
	
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
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // TC의 수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			init(N);
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				arrayList.add(new int[] {d, a, b});
			}
			
			arrayList.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));
			int ans = 0;
			int v = 0;
			for (int[] pair : arrayList) {
				int d = pair[0];
				int a = pair[1];
				int b = pair[2];
				if (find(a) != find(b)) {
					union(a, b);
					ans += d;
					v += 1;
					if (v == N - 1) {
						break;
					}
				}
			}
			
			bw.write("Case #" + t + ": " + ans + " meters\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
