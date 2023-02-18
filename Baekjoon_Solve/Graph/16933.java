// 벽 부수고 이동하기 3 (16933번)
/////////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/16933
  // BFS
  // 이 문제의 포인트는 큐의 길이 동안 낮과 밤을 처리해주는 것이다.
  // 그냥 매번 요소에서 뽑았을 때 그게 낮인지 밤인지를 판별에서 로직을 구현하면 시간초과가 난다.
  // 그리고 낮에만 벽을 부수고 갈 수 있으므로, 밤일 때만 기다리는 것을 처리해준다.
  // 이 때 사방에 벽이 2개 이상일 경우, 기다리는 곳의 좌표가 중복해서 삽입되므로,
  // 해당 위치에서 기다리지 않았다면, 큐에 삽입하고, 기다렸다면 무시한다.
  // 그리고 현재 위치의 기다린 표시를 false로 다시 바꿔준다. 그렇게 하지 않으면 해당 위치에서 기다려야하는데, 기다리지 못하는 경우가 발생하기 때문이다.
/////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int w;
        int d;
        int y;
        int x;
        Pair(int w, int d, int y, int x) {
            this.w = w;
            this.d = d;
            this.y = y;
            this.x = x;
        }
    }

    static int bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 1, 0, 0));
        visitied[0][0][0] = true;
        boolean day = false;
        while (!queue.isEmpty()) {
            int ql = queue.size();
            for (int i=0; i<ql; i++) {
                Pair pair = queue.poll();
                int w = pair.w;
                int d = pair.d;
                int y = pair.y;
                int x = pair.x;
                if (y == N - 1 && x == M - 1) {
                    return d;
                }

                for (int k=0; k<4; k++) {
                    int dy = DY[k];
                    int dx = DX[k];
                    int ny = y + dy;
                    int nx = x + dx;
                    if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if (graph[ny][nx].equals("1")) {
                            if (!day && w + 1 <= K && !visitied[ny][nx][w + 1]) {
                                visitied[ny][nx][w + 1] = true;
                                queue.add(new Pair(w + 1, d + 1, ny, nx));
                            } else if (day && !waited[y][x]) {
                                waited[y][x] = true;
                                queue.add(new Pair(w, d + 1, y, x));
                            }
                        } else if (graph[ny][nx].equals("0") && !visitied[ny][nx][w]) {
                            visitied[ny][nx][w] = true;
                            queue.add(new Pair(w, d + 1, ny, nx));
                        }
                    }
                }
                if (waited[y][x]) {
                    waited[y][x] = false;
                }
            }
            day = !day;
        }

        return -1;
    }

    static int[] DY = {-1, 0, 1, 0};
    static int[] DX = {0, 1, 0, -1};
    static int N;
    static int M;
    static int K;
    static boolean[][][] visitied;
    static String[][] graph;
    static boolean[][] waited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new String[N][M];
        visitied = new boolean[N][M][K + 1];
        waited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            graph[i] = br.readLine().split("");
        }

        int ret = bfs();

        System.out.println(ret);
        br.close();
    }
}
