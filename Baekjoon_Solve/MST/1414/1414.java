import java.util.*;
import java.io.*;

public class Main {

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
	
	static int N; // 컴퓨터의 수
	static int ans; // 기부할 수 있는 최대 비용
	static final int MAX = 53;
	static int[] parent; // 부모 배열
	static Pair[] pairs;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i; // 부모 배열 초기화
        pairs = new Pair[N * N];
        
        int k = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
        	String line = br.readLine();
        	for (int j = 0; j < N; j++) {
        		char c = line.charAt(j);
        		if (c == '0') pairs[k++] = new Pair(MAX, i, j); // 0이면 최대비용으로 연결함(전체 비용엔 가산 X)
        		else if ('a' <= c && c <= 'z') {
        			pairs[k++] = new Pair(c - 'a' + 1, i, j);
        			ans += c - 'a' + 1;
        		} else if ('A' <= c && c <= 'Z') {
        			pairs[k++] = new Pair(c - 'A' + 27, i, j);
        			ans += c - 'A' + 27;
        		}
        	}
        }
        
        Arrays.sort(pairs, (o1, o2) -> Integer.compare(o1.c, o2.c)); // 비용을 기준으로 오름차순 정렬
        
        int m = 0; // 간선의 개수
        for (int i = 0; i < k; i++) {
        	Pair pair = pairs[i];
        	if (find(pair.a) != find(pair.b) && pair.c != MAX) { // 두 노드의 부모가 다르고, 연결 비용이 MAX가 아니면 연결
        		union(pair.a, pair.b);
        		m += 1;
        		ans -= pair.c; // 전체 비용에서 최소 연결 비용을 차감
        		if (m == N - 1) break; // 최소 스패닝 트리를 연결했으면 차감
        	}
        }
        
        if (m != N - 1) System.out.println(-1);
        else System.out.println(ans);
    }
}

class Pair {
	
	int c;
	int a;
	int b;
	
	Pair(int c, int a, int b) {
		this.c = c;
		this.a = a;
		this.b = b;
	}
}