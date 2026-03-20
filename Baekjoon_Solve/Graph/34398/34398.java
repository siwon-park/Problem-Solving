// Lost On Campus (34398번)
import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = Integer.MAX_VALUE;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int W, H;
    static String[] graph;
    static Deque<int[]> deque = new LinkedList<>();
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        graph = new String[H];
        visited = new int[H][W];
        for (int i = 0; i < H; i++) {
            graph[i] = br.readLine();
            Arrays.fill(visited[i], MAX);
            for (int j = 0; j < W; j++) {
                if (graph[i].charAt(j) == '*') {
                    deque.add(new int[] {i, j});
                    visited[i][j] = 0;
                }
            }
        }

        int ans = MAX;
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int y = cur[0];
            int x = cur[1];
            if (graph[y].charAt(x) == 'E') {
                ans = Math.min(ans, visited[y][x]);
            }
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= H || nx < 0 || nx >= W || graph[ny].charAt(nx) == '#') continue;
                if (graph[ny].charAt(nx) == 'D') {
                    if (visited[ny][nx] > visited[y][x] + 1) {
                        visited[ny][nx] = visited[y][x] + 1;
                        deque.addLast(new int[] {ny, nx});
                    }
                } else {
                    if (visited[ny][nx] > visited[y][x]) {
                        visited[ny][nx] = visited[y][x];
                        deque.addFirst(new int[] {ny, nx});
                    }
                }
            }
        }
        System.out.println(ans == MAX ? "NOT POSSIBLE" : ans);
    }
}
