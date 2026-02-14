// Coast Length (11183번)
import java.io.*;
import java.util.*;

public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int N, M, ans;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];
        visited = new boolean[N + 2][M + 2];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = line.charAt(j) - '0';
                if (map[i][j + 1] == 1) queue.add(new int[] {i, j + 1});
            }
        }

        floodFill();
        countCoast(queue);
        System.out.println(ans);
    }

    private static void floodFill() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k];
                int nx = cur[1] + dx[k];
                if (ny < 0 || ny > N + 1 || nx < 0 || nx > M + 1 || visited[ny][nx]) continue;
                if (map[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx});
                }
            }
        }
    }

    private static void countCoast(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k];
                int nx = cur[1] + dx[k];
                if (ny < 0 || ny > N + 1 || nx < 0 || nx > M + 1) continue;
                if (map[ny][nx] == 0 && visited[ny][nx]) ans += 1;
            }
        }
    }

}

