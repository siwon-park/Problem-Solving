import java.io.*;
import java.util.*;

// Hotel (29634번)
public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int size = -1;
    static int N, M;
    static String[] graph;
    static boolean[][] visited;

    static int bfs(int r, int c) {
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
                if (graph[ny].charAt(nx) == '.') {
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx});
                    area++;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[N];
        visited = new boolean[N][M];
        ArrayList<int[]> vertex = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                if (graph[i].charAt(j) == '.') vertex.add(new int[] {i, j});
            }
        }

        if (vertex.isEmpty()) {
            System.out.println(size);
        } else {
            for (int[] v : vertex) {
                if (visited[v[0]][v[1]]) continue;
                visited[v[0]][v[1]] = true;
                size = Math.max(size, bfs(v[0], v[1]));
            }
            System.out.println(size);
        }

    }
}
