// Bucket Brigade(17198번)
////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/17198
  // BFS
  // 일반적인 최단 경로 BFS 문제. "B"에서 "L"까지의 최단 경로를 반환하면 된다.
////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Pair {
        int d;
        int y;
        int x;

        Pair(int d, int y, int x) {
            this.d = d;
            this.y = y;
            this.x = x;
        }
    }

    static int bfs(int sy, int sx) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, sy, sx));
        boolean[][] visited = new boolean[10][10];
        visited[sy][sx] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int d = pair.d;
            int y = pair.y;
            int x = pair.x;

            if (y == ey && x == ex) {
                return d - 1;
            }

            for (int k=0; k<4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0 <= ny && ny < 10 && 0 <= nx && nx < 10) {
                    if (!graph[ny][nx].equals("R") && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new Pair(d + 1, ny, nx));
                    }
                }
            }
        }

        return 0;
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static String[][] graph;

    static int sy;
    static int sx;
    static int ey;
    static int ex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new String[10][10];

        for (int i=0; i<10; i++) {
            graph[i] = br.readLine().split("");
            for (int j=0; j<10; j++) {
                if (graph[i][j].equals("B")) {
                    sy = i;
                    sx = j;
                } else if (graph[i][j].equals("L")) {
                    ey = i;
                    ex = j;
                }
            }
        }

        int ret = bfs(sy, sx);
        System.out.println(ret);
        br.close();
    }
}
