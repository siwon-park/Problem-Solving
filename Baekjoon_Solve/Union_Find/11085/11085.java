// 군사 이동 (11085번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int P, W, C, V;
	static int[] parent = new int[1001];
	static ArrayList<int[]> arrayList;
	
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
		P = Integer.parseInt(st.nextToken()); // 노드 수
		W = Integer.parseInt(st.nextToken()); // 간선의 수
		
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken()); // 백준 월드
		V = Integer.parseInt(st.nextToken()); // 큐브 월드
		
		// 부모 배열을 초기화
		for (int i = 0; i < P; i++) {
			parent[i] = i;
		}
		
		arrayList = new ArrayList<>();
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			int ws = Integer.parseInt(st.nextToken());
			int we = Integer.parseInt(st.nextToken());
			int ww = Integer.parseInt(st.nextToken());
			arrayList.add(new int[] {ws, we, ww});
		}
		
		// 경로 상의 너비가 큰 순으로 내림차순 정렬
		Collections.sort(arrayList, (o1, o2) -> Integer.compare(o2[2], o1[2]));
		
		int minW = 1_001;
		for (int[] arr : arrayList) {
			int a = arr[0];
			int b = arr[1];
			int c = arr[2];
			if (find(a) != find(b)) {
				union(a, b);
				minW = Math.min(minW, c); // 가장 좁은 너비를 갱신
			}
			if (find(C) == find(V)) break; // 두 노드의 부모가 같으면 break
		}
		
		bw.write(minW + "");
		bw.flush();
		bw.close();
		br.close();
	}
}