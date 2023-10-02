// 퍼레이드 (16168번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int V, E;
	static int[] parent, indegree; // 부모 배열, 진입 차수
	
	static void init() {
		parent = new int[V + 1];
		indegree = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parent[i] = i;
		}	
	}
	
	static boolean check(int n) {
		if (n != 1) return false;
		
		boolean flag = true;
		int cnt = 0;
		// 모든 노드의 진입 차수가 짝수이거나, 두 노드만 진입 차수가 홀수이고 나머지 노드는 짝수이면 true
		for (int i = 1; i < V + 1; i++) {
			if (indegree[i] % 2 != 0) {
				cnt += 1;
				flag = false;
			}
		}
		if (cnt == 2) return true;
		return flag;
	}
	
	
	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
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
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		init();
		
		int n = V;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			indegree[a] += 1;
			indegree[b] += 1;
			if (find(a) != find(b)) {
				union(a, b);
				n -= 1;
			}
		}
		
		boolean flag = check(n);
		if (flag) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}