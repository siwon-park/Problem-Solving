// 도시 건설 (21924번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] parent;
	static ArrayList<int[]> arrayList = new ArrayList<>();
	
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
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) parent[i] = i;
		
		long totalCost = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arrayList.add(new int[] {a, b, c});
			totalCost += c;
		}
		
		arrayList.sort((o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		int cnt = 0; // 간선의 수
		long cost = 0;
		for (int i = 0; i < M; i++) {
			int[] info = arrayList.get(i);
			if (find(info[0]) != find(info[1])) {
				union(info[0], info[1]);
				cost += info[2];
				cnt += 1;
				if (cnt == N - 1) break;
			}
		}
		
		if (cnt != N - 1) bw.write(-1 + "");
		else bw.write((totalCost - cost) + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}