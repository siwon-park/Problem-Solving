// Escape Wall Maria (24819번)
import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = Integer.MAX_VALUE;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int T, N, M;
    static String[] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[N];
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                if (graph[i].charAt(j) == 'S') {
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int ans = MAX;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int t = cur[2];
            if (t > T) continue;
            if (y == 0 || y == N - 1 || x == 0 || x == M - 1) {
                ans = Math.min(ans, t);
                continue;
            }
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || graph[ny].charAt(nx) == '1') continue;
                boolean moveable = isMoveable(ny, nx, k);
                if (moveable) {
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx, t + 1});
                }
            }
        }
        System.out.println(ans == MAX ? "NOT POSSIBLE" : ans);
    }

    private static boolean isMoveable(int ny, int nx, int k) {
        if (graph[ny].charAt(nx) == 'U' && k == 2) { // from above
            return true;
        } else if (graph[ny].charAt(nx) == 'D' && k == 0) { // from bottom
            return true;
        } else if (graph[ny].charAt(nx) == 'L' && k == 1) { // from left
            return true;
        } else if (graph[ny].charAt(nx) == 'R' && k == 3) { // from right
            return true;
        } else return graph[ny].charAt(nx) == '0' || graph[ny].charAt(nx) == 'S';
    }
}

