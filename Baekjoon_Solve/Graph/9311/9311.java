// Robot in a Maze (9311번)
import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static int T, N, M, ans;
    static String[] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new String[N];
            int sr = 0, sc = 0;
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (map[i].charAt(j) == 'S') {
                        sr = i;
                        sc = j;
                    }
                }
            }
            ans = bfs(sr, sc);
            if (ans == -1) bw.write("No Exit\n");
            else bw.write("Shortest Path: " + ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int sr, int sc) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];
        queue.add(new int[] {sr, sc, 0});
        visited[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            if (map[r].charAt(c) == 'G') return d;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr].charAt(nc) == 'X' || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.add(new int[] {nr, nc, d + 1});
            }
        }
        return -1;
    }

}

