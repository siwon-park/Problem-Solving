import java.io.*;
import java.util.*;

// Tractor (5890번)
public class Main {

    static final int MAX = Integer.MAX_VALUE;
    static final int[] dy = new int[] {-1, 0, 1, 0};
    static final int[] dx = new int[] {0, 1, 0, -1};
    static int[][] graph, visited;
    static int n;

    static int bfs(int sy, int sx) {
        for (int i = 0; i < 1002; i++) Arrays.fill(visited[i], MAX);
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[] {sy, sx, 0});
        visited[sy][sx] = 0;
        while (!deque.isEmpty()) {
            int[] pair = deque.pollFirst();
            int y = pair[0];
            int x = pair[1];
            int d = pair[2];
            if (y == 0 || x == 0 || y == 1001 || x == 1001) return d;
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny > 1001 || nx < 0 || nx > 1001 || visited[ny][nx] != MAX) continue;
                if (graph[ny][nx] == 1) {
                    visited[ny][nx] = d + 1;
                    deque.addLast(new int[] {ny, nx, d + 1});
                } else {
                    visited[ny][nx] = d;
                    deque.addFirst(new int[] {ny, nx, d});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[1002][1002];
        visited = new int[1002][1002];
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[r][c] = 1;
        }

        int ans = bfs(y, x);
        System.out.println(ans);

    }
}
