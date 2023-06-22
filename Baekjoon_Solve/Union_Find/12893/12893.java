// 적의 적 (12893번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M; // 사람 수, 적대 관계 수
	static int[] parent; // 부모 배열
	static ArrayList<HashSet<Integer>> rel; // 관계도
	
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
		rel = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			rel.add(new HashSet<>());
			parent[i] = i;
		}
		
		int a, b;
		int[][] queries = new int[M][2]; // 쿼리 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			// 어차피 union하게 되면 양방향 관계가 될 수 있어 한 쪽으로만 관계를 연결해도 됨
			rel.get(a).add(b);
			queries[i][0] = a;
			queries[i][1] = b;
		}
		
		// 적대 관계의 적대 관계에 있는 사람들을 우호 관계로 묶어 줌
		for (int i = 1; i < N + 1; i++) {
			HashSet<Integer> enemies = rel.get(i);
			if (rel.isEmpty()) continue;
			for (Integer e : enemies) {
				HashSet<Integer> friends = rel.get(e);
				for (Integer f : friends) union(i, f); // i와 f를 우호 관계로 병합
			}
		}
		
		boolean flag = true;
		for (int i = 0; i < M; i++) {
			a = queries[i][0];
			b = queries[i][1];
			if (find(a) == find(b)) { // 적대 관계로 주어졌는데 우호 관계이면 모순
				flag = false;
				break;
			}
		}
		
		System.out.println(flag ? 1 : 0);
	}
}