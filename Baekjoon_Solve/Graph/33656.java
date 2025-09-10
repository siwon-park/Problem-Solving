import java.io.*;
import java.util.*;

// Island Exploration (33656번)
public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int R, C;
    static String[] graph;
    static boolean[][] visited;

    static int bfs(int r, int c) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int y = pair[0];
            int x = pair[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || graph[ny].charAt(nx) == '.') continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx});
                cnt += 1;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new String[R];
        visited = new boolean[R][C];

        int r = 0;
        int c = 0;
        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine();
            for (int j = 0; j < C; j++) {
                if (graph[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                }
            }
        }

        int ret = bfs(r, c);
        System.out.println(ret);
    }
}
