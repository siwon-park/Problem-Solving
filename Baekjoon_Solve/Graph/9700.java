// RAINFOREST CANOPY (9700번)
import java.io.*;
import java.util.*;

public class Main {

    static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N;
    static String[] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String S = "";
        int tc = 1;
        while ((S = br.readLine()) != null && !S.isEmpty()) {
            N = Integer.parseInt(S);
            graph = new String[N];
            for (int i = 0; i < N; i++) graph[i] = br.readLine();
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i].charAt(j) == '1' && !visited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            bw.write(String.format("Case #%s: %s\n", tc, cnt));
            tc ++;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int y = pair[0];
            int x = pair[1];
            for (int k = 0; k < 8; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || graph[ny].charAt(nx) == '0') continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx});
            }
        }
    }
}

