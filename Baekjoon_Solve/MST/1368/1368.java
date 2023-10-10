// 물대기 (1368번)
import java.io.*;
import java.util.*;

public class Main {

	static int N;
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
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		ArrayList<Pair> pairList = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
			// i번 노드에 우물을 판다 -> 0번 노드와 i번 노드를 연결한다
			pairList.add(new Pair(0, i, Integer.parseInt(br.readLine())));
		}
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if (i < j) {
					pairList.add(new Pair(i, j, cost));
				}
			}
		}
		
		Collections.sort(pairList, (o1, o2) -> Integer.compare(o1.cost, o2.cost));
		
		int M = 0; // 간선의 수 -> 그러나 0번 노드까지 연결하므로 노드 수는 N + 1로, MST의 간선 수는 N임
		int totalCost = 0;
		for (Pair pair : pairList) {
			if (find(pair.a) != find(pair.b)) {
				union(pair.a, pair.b);
				totalCost += pair.cost;
				M += 1;
				if (M == N) break;
			}
		}
		
		bw.write(totalCost + "");
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pair {
	int a, b, cost;
	
	Pair(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
}