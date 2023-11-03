// 옥수수밭 (30024번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N, M, K;
	static int[][] graph;
	static boolean[][] visited;
	
	static StringBuilder bfs(PriorityQueue<Pair> pq) {
		StringBuilder sb = new StringBuilder();
		int kCnt = K;
		while (!pq.isEmpty() && kCnt > 0) {
			Pair pair = pq.poll();
			visited[pair.y][pair.x] = true;
			sb.append((pair.y + 1) + " " + (pair.x + 1) + "\n");			
			kCnt--;
			for (int k = 0; k < 4; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					pq.add(new Pair(ny, nx, graph[ny][nx]));
				}
			}
		}
		return sb;
	}
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.v, o1.v));
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        		// 가장 자리에 있는 옥수수들을 우선순위 큐에 담음
        		if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
        			pq.add(new Pair(i, j, graph[i][j]));
        			visited[i][j] = true;
        		}
        	}
        }
        
        K = Integer.parseInt(br.readLine());
        
        StringBuilder sb = bfs(pq);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}


class Pair {
	int y, x, v;
	Pair() {}
	Pair(int y, int x, int v) {
		this.y = y;
		this.x = x;
		this.v = v;
	}
}