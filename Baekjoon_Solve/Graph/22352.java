// 항체 인식(22352번)
/////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/22352
  // BFS
  // 그래프1과 그래프2가 다른 지점에서 BFS를 돌리고 visited 배열에 현재의 그래프2 값을 기록한다.
  // 결과적으로 나온 visited 배열에서 0이 아닌 좌표의 그래프1 위치에 visited 배열에 쓰여 있는 값을 기록한다.
  // 이를 그래프1과 그래프2 비교를 통해 같은지 다른지 판별하여 최종적으로 결과를 출력한다.
/////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int y;
        int x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs(int r, int c, int value) {
        Queue<Pair> queue = new LinkedList<>();
        Pair pair = new Pair(r, c);
        queue.add(pair);
        visited[r][c] = value;
        while (!queue.isEmpty()) {
            Pair curPair = queue.poll();
            int y = curPair.y;
            int x = curPair.x;
            for (int k=0; k<4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0 <= ny && ny < N && 0<= nx && nx < M) {
                    if (visited[ny][nx] == 0 && graph1[y][x] == graph1[ny][nx]) {
                        Pair nextPair = new Pair(ny, nx);
                        queue.add(nextPair);
                        visited[ny][nx] = value;
                    }
                }
            }
        }
    }

    static void check() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (graph1[i][j] != graph2[i][j]) {
                    bfs(i, j, graph2[i][j]);
                    return;
                }
            }
        }
    }

    static int N;
    static int M;
    static int[][] graph1;
    static int[][] graph2;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph1 = new int[N][M];
        graph2 = new int[N][M];
        visited = new int[N][M];

        // graph1에 대한 입력
        for (int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                graph1[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        
        // graph2에 대한 입력
        for (int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                graph2[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        check();

        String ret = "YES";

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (visited[i][j] != 0) {
                    graph1[i][j] = visited[i][j];
                }
                if (graph1[i][j] != graph2[i][j]) {
                    ret = "NO";
                }
            }
        }
        System.out.println(ret);
    }
}
