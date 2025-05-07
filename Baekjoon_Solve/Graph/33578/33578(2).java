import java.io.*;
import java.util.*;

// 누가 이름 안 적고 나갔어 (33578번)
public class Main {

    static final int INF = Integer.MAX_VALUE;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int N, M;
    static String[] graph;
    static int[][][] visited;

    static int dijkstra(int r, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] < o2[0]) return -1;
            else if (o1[0] > o2[0]) return 1;
            else return Integer.compare(o1[3], o2[3]);
        });
        pq.add(new int[] {0, r, c, 2});
        visited[r][c][1] = 0;
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int d = pair[0];
            int y = pair[1];
            int x = pair[2];
            int t = pair[3];
            if (graph[y].charAt(x) == 'S') {
                return visited[y][x][t - 1];
            }
            if (visited[y][x][t - 1] < d) continue;
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || graph[ny].charAt(nx) == '#') continue;
                int nd = d + t;
                if (nd < visited[ny][nx][t - 1]) {
                    visited[ny][nx][t - 1] = nd;
                    if (graph[ny].charAt(nx) == 'T') {
                        pq.add(new int[] {nd, ny, nx, 1});
                    } else {
                        pq.add(new int[] {nd, ny, nx, t});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int sr = 0;
        int sc = 0;
        graph = new String[N];
        visited = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            graph[i] = line;
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'J') {
                    sr = i;
                    sc = j;
                }
                visited[i][j][0] = INF;
                visited[i][j][1] = INF;
            }
        }

        int ans = dijkstra(sr, sc);
        System.out.println(ans);

    }
}
