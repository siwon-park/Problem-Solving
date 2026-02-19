// Best Grass (6186번)
import java.io.*;
import java.util.*;

public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int N, M, ans;
    static String[] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];
        map = new String[N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                if (map[i].charAt(j) == '#') {
                    queue.add(new int[] {i, j});
                }
            }
        }

        ans = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            if (visited[y][x]) continue;
            visited[y][x] = true;
            ans += 1;
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
                if (map[ny].charAt(nx) == '#') {
                    visited[ny][nx] = true;
                }
            }
        }
        System.out.println(ans);
    }
}

