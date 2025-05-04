import java.io.*;
import java.util.*;

// 동굴 (32983번)
public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int N, M, C;
    static int[][] graph;
    static int[] dist;
    static boolean[][] visited;

    static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, 0});
        visited[r][c] = true;
        if (graph[r][c] == -1) return;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int y = pair[0];
            int x = pair[1];
            int d = pair[2];
            dist[d] += graph[y][x];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 1 || ny > N || nx < 1 || nx > M || visited[ny][nx] || graph[ny][nx] == -1) continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx, d + 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        dist = new int[N * M + 1];
        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(sr, sc);
        int profit = Math.max(0, dist[0]);
        for (int i = 1; i <= N * M; i++) {
            dist[i] += dist[i - 1];
            profit = Math.max(profit, dist[i] - C * i);
        }
        System.out.println(profit);
    }
}

