// 집배원 한상덕 (2842번) - 이분 탐색
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0, -1, 1, 1, -1};
	static final int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
	static int N, K;
	static int[][] height;
	static String[] graph;
	static Pair P;
	
	static boolean bfs(int min, int max) {
		if (height[P.y][P.x] < min || height[P.y][P.x] > max) return false;
		boolean[][] visited = new boolean[N][N];
		Queue<Pair> queue = new LinkedList<>();
		queue.add(P);
		visited[P.y][P.x] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			for (int k = 0; k < 8; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if (!visited[ny][nx] && min <= height[ny][nx] && height[ny][nx] <= max) {
					visited[ny][nx] = true;
					queue.add(new Pair(ny, nx));
					if (graph[ny].charAt(nx) == 'K') cnt += 1;
					if (cnt == K) return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		K = 0; // k의 개수
		graph = new String[N];
		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine();
			for (int j = 0; j < N; j++) {
				if (graph[i].charAt(j) == 'P') {
					P = new Pair(i, j);
				} else if (graph[i].charAt(j) == 'K') {
					K += 1;
				}
			}
		}
		
		height = new int[N][N];
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				hashSet.add(height[i][j]);
			}
		}
		
		ArrayList<Integer> H = new ArrayList<>(hashSet);
		Collections.sort(H, (o1, o2) -> Integer.compare(o1, o2));
		int M = H.size();
		
		// 최솟값을 고정하고 매개변수 탐색 실시
		int ans = H.get(M - 1);
		for (int i = 0; i < M; i++) {
			int min = H.get(i);
			int s = i;
			int e = M - 1;
			while (s <= e) {
				int mid = (s + e) >> 1;
				boolean flag = bfs(min, H.get(mid));
				if (flag) {
					e = mid - 1;
					ans = Math.min(ans, H.get(mid) - min);
				} else {
					s = mid + 1;
				}
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int y, x;
	Pair() {}
	
	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}