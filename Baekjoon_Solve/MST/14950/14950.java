// 정복자 (14950번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, T;
	static int[] parent;
	
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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
		
		ArrayList<int[]> arrayList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			arrayList.add(new int[] {A, B, C});
		}
		
		Collections.sort(arrayList, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		int cost = 0;
		int m = 0; // 간선의 수
		int t = 0;
		for (int i = 0; i < M; i++) {
			int[] pair = arrayList.get(i);
			int a = pair[0];
			int b = pair[1];
			int c = pair[2];
			if (find(a) != find(b)) {
				union(a, b);
				cost += c + t;
				m += 1;
				t += T;
				if (m == N - 1) break;
			}
		}
		
		bw.write(cost + "");
		bw.flush();
		bw.close();
		br.close();
	}
}