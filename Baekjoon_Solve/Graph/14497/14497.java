import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int dijkstra(int y, int x) {
        int[][] distance = new int[N][M];

        for (int i = 0; i < N; i++) Arrays.fill(distance[i], MAX);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Pair::compareTo);
        pq.add(new Pair(y, x, 0));
        distance[y][x] = 0;

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (pair.y == x2 - 1 && pair.x == y2 - 1) return distance[pair.y][pair.x];
            if (distance[pair.y][pair.x] < pair.jump) continue;
            for (int k = 0; k < 4; k++) {
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (graph[ny].charAt(nx) != '0') {
                    if (pair.jump + 1 < distance[ny][nx]) {
                        distance[ny][nx] = pair.jump + 1;
                        pq.add(new Pair(ny, nx, pair.jump + 1));
                    }
                } else {
                    if (pair.jump < distance[ny][nx]) {
                        distance[ny][nx] = pair.jump;
                        pq.add(new Pair(ny, nx, pair.jump));
                    }
                }
            }
        }
        return distance[x2 - 1][y2 - 1];
    }

    static int N, M; // 교실의 크기
    static int x1, y1, x2, y2; // 주난의 위치, 범인의 위치
    static int MAX = Integer.MAX_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static String[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        graph = new String[N];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
        }

        int ret = dijkstra(x1 - 1, y1 - 1);
        System.out.println(ret);
    }
}

class Pair implements Comparable<Pair> {
    int y;
    int x;

    int jump; // 점프

    Pair(int y, int x, int jump) {
        this.y = y;
        this.x = x;
        this.jump = jump;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.jump, o.jump);
    }
}