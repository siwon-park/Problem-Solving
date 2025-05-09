import java.io.*;
import java.util.*;

// 국기 색칠하기 (30702번)
public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int N, M;
    static String[] map1, map2;
    static int[][] visited1, visited2;

    static void bfs(int y, int x, int[][] visited, String[] map, int mrk) {
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = mrk;
        queue.add(new int[] {y, x, mrk});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k];
                int nx = cur[1] + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] != -1) continue;
                if (map[cur[0]].charAt(cur[1]) == map[ny].charAt(nx)) {
                    visited[ny][nx] = mrk;
                    queue.add(new int[] {ny, nx, mrk});
                }
            }
        }
    }

    static boolean isSame(int[][] visited1, int[][] visited2) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited1[i][j] != visited2[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map1 = new String[N];
        map2 = new String[N];
        visited1 = new int[N][M];
        visited2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            map1[i] = br.readLine();
            Arrays.fill(visited1[i], -1);
        }
        for (int i = 0; i < N; i++) {
            map2[i] = br.readLine();
            Arrays.fill(visited2[i], -1);
        }

        int mrk= 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited2[i][j] == -1) {
                    bfs(i, j, visited2, map2, mrk);
                    mrk++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited1[i][j] == -1) {
                    bfs(i, j, visited1, map1, visited2[i][j]);
                }
            }
        }

        boolean result = isSame(visited1, visited2);
        System.out.println(result ? "YES" : "NO");

    }
}
