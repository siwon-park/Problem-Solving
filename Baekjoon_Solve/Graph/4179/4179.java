import java.util.*;
import java.io.*;

public class Main {

    static void spreadFire(ArrayList<Pair> arrayList) {
        Queue<Pair> queue = new LinkedList<>();
        for (Pair pair : arrayList) {
            visited[pair.y][pair.x] = pair.d;
            queue.add(pair);
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                if (graph[ny].charAt(nx) != '#' && pair.d + 1 < visited[ny][nx]) {
                    visited[ny][nx] = pair.d + 1;
                    queue.add(new Pair(ny, nx, pair.d + 1));
                }
            }
        }
    }

    static int bfs(ArrayList<Pair> arrayList) {
        Queue<Pair> queue = new LinkedList<>();
        for (Pair pair : arrayList) {
            visited[pair.y][pair.x] = pair.d;
            queue.add(pair);
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (ny < 0 || ny >= R || nx < 0 || nx >= C) return pair.d + 1;
                if (graph[ny].charAt(nx) != '#' && pair.d + 1 < visited[ny][nx]) {
                    visited[ny][nx] = pair.d + 1;
                    queue.add(new Pair(ny, nx, pair.d + 1));
                }
            }
        }
        return -1;
    }


    static int R, C; // 행, 열
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static String[] graph; // 격자판
    static int[][] visited; // 방문 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new int[R][C];
        graph = new String[R];

        ArrayList<Pair> fires = new ArrayList<>();
        ArrayList<Pair> jihoon = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine();
            for (int j = 0; j < C; j++) {
                visited[i][j] = 1_000_001;
                if (graph[i].charAt(j) == 'J') {
                    jihoon.add(new Pair(i, j, 0));
                } else if (graph[i].charAt(j) == 'F') {
                    fires.add(new Pair(i, j, 0));
                }
            }
        }

        spreadFire(fires);
        int ret = bfs(jihoon);
        System.out.println(ret == -1 ? "IMPOSSIBLE" : ret);
    }
}

class Pair {
    int y;
    int x;
    int d;
    Pair(int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}