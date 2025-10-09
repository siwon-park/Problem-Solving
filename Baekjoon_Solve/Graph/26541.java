// Field Navigation (26541번)
import java.io.*;
import java.util.*;

public class Main {

    static final String RGB = "RGB";
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int N;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            int sr = 0, sc = 0, tr = 0, tc = 0;
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    char ch = line.charAt(j);
                    if (ch == 'S') {
                        sr = i;
                        sc = j;
                        graph[i][j] = 0;
                    } else if (ch == 'X') {
                        tr = i;
                        tc = j;
                        graph[i][j] = 0;
                    } else if (ch == '.') {
                        graph[i][j] = 0;
                    } else { // R, G, B
                        graph[i][j] = RGB.indexOf(ch) + 1;
                    }
                }
            }

            int ans = bfs(sr, sc, tr, tc);
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int r, int c, int tr, int tc) {
        Queue<int[]> queue = new LinkedList<>();
        int[][][] visited = new int[N][N][1 << 3]; // 000
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[i][j], 3);
            }
        }
        queue.offer(new int[]{r, c, 0, 0}); // y, x, dist, bit
        visited[r][c][0] = 0;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int y = pair[0];
            int x = pair[1];
            int d = pair[2];
            int bit = pair[3];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (graph[ny][nx] == 0 && d < visited[ny][nx][bit]) {
                    visited[ny][nx][bit] = d;
                    queue.add(new int[] {ny, nx, d, bit});
                } else if (graph[ny][nx] != 0) {
                    int bitopr = bit & (1 << (graph[ny][nx] - 1));
                    if (bitopr != 0 && d < visited[ny][nx][bit]) { // 비트 일치
                        visited[ny][nx][bit] = d;
                        queue.add(new int[] {ny, nx, d, bit});
                    } else if (bitopr == 0 && d + 1 < visited[ny][nx][bit | (1 << (graph[ny][nx] - 1))]) { // 비트 불일치
                        int nbit = bit | (1 << (graph[ny][nx] - 1));
                        visited[ny][nx][nbit] = d + 1;
                        queue.add(new int[] {ny, nx, d + 1, nbit});
                    }
                }
            }
        }
        int ret = 3;
        for (int i = 0; i < (1 << 3); i++) ret = Math.min(ret, visited[tr][tc][i]);
        return ret;
    }
}

