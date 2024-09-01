// Networking (3803번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int P, R;
	static int[] parent;
	static int[][] arr;
	
	static void init(int n, int m) {
		parent = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}
		
		arr = new int[m + 1][3];
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
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			if (P == 0) break;
			R = Integer.parseInt(st.nextToken());
			init(P, R);
			
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[2], o2[2]));
			
			int ans = 0;
			int edges = 0;
			for (int i = 0; i < R; i++) {
				int u = arr[i][0];
				int v = arr[i][1];
				int cost = arr[i][2];
				if (find(u) != find(v)) {
					union(u, v);
					ans += cost;
					edges += 1;
					if (edges == P - 1) break;
				}
			}
			
			bw.write(ans + "\n");
			st = new StringTokenizer(br.readLine()); // 입력 중간에 있는 공백 처리를 위한 코드
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

