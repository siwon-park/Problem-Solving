import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair { // 좌표를 나타내기 위한 Pair 클래스
        int y;
        int x;
        Pair (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs(int r, int c) { // 너비 우선 탐색 함수
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r, c));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int k=0; k<4; k++) {
                // 계산 결과가 음수이면 IndexOfOutBound 예외가 발생하므로 N, M을 더해야함
                int ny = (pair.y + dy[k] + N) % N; // 0 ~ N - 1
                int nx = (pair.x + dx[k] + M) % M; // 0 ~ M - 1
                if (!visited[ny][nx] && graph[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.add(new Pair(ny, nx));
                }
            }
        }
    }

    static int N, M, ans;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) { // 0이고 아직 방문하지 않았으면 bfs 탐색
                    visited[i][j] = true;
                    ans += 1;
                    bfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }
}