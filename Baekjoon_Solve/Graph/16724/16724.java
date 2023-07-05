// 피리 부는 사나이 (16724번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M; // 행, 열
	static String[] graph; // 격자판
	static int[] parent; // 부모 배열
	static HashMap<Character, int[]> hashMap; // 방향
	
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
		
		hashMap = new HashMap<>();
		hashMap.put('U', new int[] {-1, 0});
		hashMap.put('D', new int[] {1, 0});
		hashMap.put('L', new int[] {0, -1});
		hashMap.put('R', new int[] {0, 1});
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N * M];
		for (int i = 0; i < N * M; i++) parent[i] = i;
		
		graph = new String[N];
		for (int i = 0; i < N; i++) graph[i] = br.readLine();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				char way = graph[i].charAt(j);
				int cur = i * M + j;
				int nxt = (i + hashMap.get(way)[0]) * M + j + hashMap.get(way)[1];
				if (find(cur) != find(nxt)) union(cur, nxt);
			}
		}
		
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < N * M; i++) {
			find(i);
			hashSet.add(parent[i]);
		}
		
		System.out.println(hashSet.size());
	}
}