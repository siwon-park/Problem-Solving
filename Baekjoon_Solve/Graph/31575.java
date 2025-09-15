import java.io.*;
import java.util.*;

// 도시와 비트코인 (31575번)
public class Main {

    static final int[] dy = {0, 1};
    static final int[] dx = {1, 0};
    static int R, C;
    static int[][] graph;
    static boolean[][] visited;

    static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int y = pair[0];
            int x = pair[1];
            if (y == R - 1 && x == C - 1) return true;
            for (int k = 0; k < 2; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || graph[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx});
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean flag = bfs();
        if (flag) System.out.println("Yes");
        else System.out.println("No");
    }
}
