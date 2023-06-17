// Watering the Fields (10021번)
import java.io.*;
import java.util.*;

public class Main {
	
	/*
	 * 두 점 간 비용을 계산하는 함수
	 * */
	static int calculateCost(Pair o1, Pair o2) {
		return (o1.x - o2.x) * (o1.x - o2.x) + (o1.y - o2.y) * (o1.y - o2.y);
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
	
	static int N, C; // 노드의 수, 최소 파이프 비용
	static int[] parent; // 부모 배열
	static Pair[] pairs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pairs = new Pair[N];
		parent = new int[N];
		
		int x, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair(x, y);
			parent[i] = i;
		}
		
		ArrayList<Pair> pairList = new ArrayList<>();
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				pairList.add(new Pair(i, j, calculateCost(pairs[i], pairs[j])));
			}
		}
		
		pairList.sort((Pair o1, Pair o2) -> Integer.compare(o1.c, o2.c));
		
		int totalCost = 0;
		int cnt = 0;
		for (Pair pair : pairList) {
			if (pair.c >= C) { // 최소 비용보다 크면 연결
				if (find(pair.x) != find(pair.y)) {
					union(pair.x, pair.y);
					totalCost += pair.c;
					cnt += 1;
					if (cnt == N - 1) break;
				}
			}
		}
		
		if (cnt == N - 1) System.out.println(totalCost);
		else System.out.println(-1);
	}
}


class Pair {
	int x;
	int y;
	int c;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Pair(int x, int y, int c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}