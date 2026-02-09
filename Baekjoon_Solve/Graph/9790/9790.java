// Elephant Show (9790번)
import java.io.*;
import java.util.*;

public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int W, H;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (W == 0 && H == 0) break;
            graph = new int[H][W];
            visited = new boolean[H][W];
            int ans = 0;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    char c = line.charAt(j);
                    if (c == '.' || c == 'A') {
                        graph[i][j] = 1;
                        if (c == 'A') {
                            queue.add(new int[] {i, j});
                            visited[i][j] = true;
                            ans += 1;
                        }
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int y = cur[0];
                int x = cur[1];
                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if (ny < 0 || ny >= H || nx < 0 || nx >= W || visited[ny][nx] || graph[ny][nx] == 0) continue;
                    visited[ny][nx] = true;
                    ans += 1;
                    queue.add(new int[] {ny, nx});
                }
            }
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

