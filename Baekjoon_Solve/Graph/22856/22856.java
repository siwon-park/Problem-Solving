// 트리 순회 (22856번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, cnt, end;
	static boolean[] visited;
	static int[] parent;
	static int[][] bTree;
	
	// 중위 순회의 마지막 노드 찾기
	static void recur(int cur) {
		if (cur == -1) return;
		recur(bTree[cur][0]);
		end = cur;
		recur(bTree[cur][1]);
	}
	
	// 유사 중위 순회 
	static void inOrder(int cur) {
		int left = bTree[cur][0];
		int right = bTree[cur][1];
		if (left != -1 && !visited[left]) {
			visited[left] = true;
			cnt += 1;
			inOrder(left);
		} else if (right != -1 && !visited[right]) {
			visited[right] = true;
			cnt += 1;
			inOrder(right);
		} else if (cur == end) {
			return;
		} else if (parent[cur] != 0) {
			cnt += 1;
			inOrder(parent[cur]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		bTree = new int[N + 1][2];
		parent = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			bTree[a][0] = b;
			bTree[a][1] = c;
			if (b != -1) parent[b] = a;
			if (c != -1) parent[c] = a;
		}
		
		cnt = 0;
		visited = new boolean[N + 1];
		
		recur(1);
		visited[1] = true;
		inOrder(1);
		System.out.println(cnt);
	}
}