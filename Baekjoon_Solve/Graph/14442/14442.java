import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Pair {
        int y;
        int x;
        int d;
        int cnt;
        Pair (int y, int x, int d, int cnt) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.cnt = cnt;
        }
    }

    /*
    * BFS 탐색 후 최단 거리를 반환하는 함수
    * (0, 0) 출발 -> (N - 1, M - 1) 도착
    * */
    static int bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 1, 0)); // y좌표, x좌표, 이동거리, 벽 부순 횟수
        for (int k=0; k<K+1; k++) {
            visited[0][0][0] = 1;
        }
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int w=0; w<4; w++) {
                int ny = pair.y + dy[w];
                int nx = pair.x + dx[w];
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    // 벽을 부수지 않고 가는 경우
                    if (graph[ny].charAt(nx) == '0') {
                        if (visited[ny][nx][pair.cnt] > pair.d + 1) {
                            visited[ny][nx][pair.cnt] = pair.d + 1;
                            queue.add(new Pair(ny, nx, pair.d + 1, pair.cnt));
                        }
                    } else { // 벽을 만난 경우
                        if (pair.cnt + 1 <= K) {
                            if (visited[ny][nx][pair.cnt + 1] > pair.d + 1) {
                                visited[ny][nx][pair.cnt + 1] = pair.d + 1;
                                queue.add(new Pair(ny, nx, pair.d + 1, pair.cnt + 1));
                            }
                        }
                    }
                }
            }
        }
        int ret = MAX;
        for (int k=0; k<K+1; k++) {
            ret = Math.min(ret, visited[N - 1][M - 1][k]);
        }
        return (ret == MAX) ? -1 : ret;
    }

    static int N, M, K; // 격자판 세로 길이, 격자판 가로 길이, 벽을 최대로 부술 수 있는 횟수
    static String[] graph; // 격자판
    static int[][][] visited; // 방문 체크 배열
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new String[N];
        visited = new int[N][M][K + 1];

        for (int i=0; i<N; i++) {
            graph[i] = br.readLine();
        }
        
        // 방문 배열 최댓값으로 초기화
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                for (int k=0; k<K+1; k++) {
                    visited[i][j][k] = MAX;
                }
            }
        }

        int ret = bfs();
        System.out.println(ret);
    }
}