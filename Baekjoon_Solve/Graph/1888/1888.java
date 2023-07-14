// 곰팡이 (1888번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int M, N, cnt; // 행, 열, 컴포넌트 수
	static int[] parent; // 부모 배열
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] graph, component, fungus; // 그래프, 컴포넌트 집합군, 곰팡이의 자라는 속도
	
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
	
	static void findComponent(int r, int c, int area) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		component[r][c] = area;
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			for (int k = 0; k < 4; k++) {
				int ny = pair[0] + dy[k];
				int nx = pair[1] + dx[k];
				if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
				if (graph[ny][nx] != 0 && component[ny][nx] == 0) {
					component[ny][nx] = area;
					queue.add(new int[] {ny, nx});
				}
			}
		}
	}
	
	static int bfs(Queue<int[]> queue) {
		int t = 0;
		while (true) {

//			System.out.println("-----");
//			
//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(graph[i][j]);
//				}
//				System.out.println();
//			}
			
			if (cnt == 1) {
				return t;
			}
			

			Queue<int[]> nextQueue = new LinkedList<>();
			if (queue.isEmpty()) break;
			int size = queue.size();
			int r, c, k;
			for (int i = 0; i < size; i++) {
				int[] pair = queue.poll();
				r = pair[0];
				c = pair[1];
				k = pair[2];
				// 주변 2 * k + 1 크기의 격자판으로 퍼짐
				for (int y = r - k; y < r + k + 1; y++) {
					for (int x = c - k; x < c + k + 1; x++) {
						if (y < 0 || y >= M || x < 0 || x >= N) continue;
						if (graph[y][x] == 0) { // 빈 칸이면 해당 곰팡이가 퍼짐
							graph[y][x] = k;
							component[y][x] = pair[3];
							nextQueue.add(new int[] {y, x, k, pair[3]});
						} else if (graph[y][x] <= k) { // 빈 칸이 아닌데, 해당 곰팡이의 퍼지는 속도가 작고
							if (find(component[y][x]) != find(pair[3])) { // 같은 종이 아니면 퍼짐
								component[y][x] = pair[3];
								graph[y][x] = k;
								nextQueue.add(new int[] {y, x, k, pair[3]});
							}
						}
					}
				}
			}
			
			while (!nextQueue.isEmpty()) {
				int[] pair = nextQueue.poll();
				r = pair[0];
				c = pair[1];
				k = pair[2];
				if (k < graph[r][c]) continue;
				// 인접한 주변이 곰팡이면 연결
				for (int i = 0; i < 4; i++) {
					int ny = r + dy[i];
					int nx = c + dx[i];
					if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
					if (graph[ny][nx] != 0) {
						if (find(component[ny][nx]) != find(pair[3])) {
							union(component[ny][nx], pair[3]);
							cnt -= 1; // 집합을 1개 감소
						}
					}
				}
				queue.add(pair);
			}
			t += 1;
		}
		return t;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st  = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new int[M][N];
		fungus = new int[M][N];
		component = new int[M][N];
		
		String line;
		for (int i = 0; i < M; i++) {
			line = br.readLine();
			for (int j = 0; j < N; j++) graph[i][j] = Integer.parseInt(line.charAt(j) + "");
		}
		
		// 연결 컴포넌트의 개수를 찾음
		cnt = 0;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] != 0) {
					if (component[i][j] == 0) findComponent(i, j, ++cnt);
					queue.add(new int[] {i, j, graph[i][j], component[i][j]});
				}
			}
		}
		
		// 컴포넌트의 수 크기만큼 부모 배열 선언
		parent = new int[cnt + 1];
		for (int i = 0; i < cnt + 1; i++) parent[i] = i;
		
		int t = bfs(queue);
		bw.write(t + "");
		bw.flush();
		bw.close();
		br.close();
	}
}