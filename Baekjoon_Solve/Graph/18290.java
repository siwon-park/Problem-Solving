// NM과 K (1) (18290번)
/*
 문제: https://www.acmicpc.net/problem/18290
 브루트포스, 백트랙킹
 실수 때문에 많은 시간을 투자한 문제다.
 ans값을 -MAX_VALUE로 초기화해줬어야 했는데, 0으로 초기화하는 바람에 배열이 전부 음수면 0을 출력하고 있었다.
 백트랙킹으로 최종 return한 다음, 방문한 곳과 인접한 곳의 방문 배열을 다시 원상태로 되돌리는 과정에서 실수가 있었다.
 내 코드의 방문 체크 방식에서는 예를 들어, 3 x 3 배열에서 (1, 0)을 방문하고, 마지막에 (2, 1)을 방문하고 나서 백트랙킹으로 return할 때,
 (2, 1)과 인접 위치의 방문 체크 상태를 false로 바꿔주는 과정에서 문제가 발생했다.
 (2, 1)의 인접 위치에는 (1, 0)과도 인접한 위치가 있는데((2, 1)과, (1, 1)이라는 공통 인접 위치가 있음),
 문제 조건에 의하면 해당 위치를 선택할 수 없음에도 불구하고, 잘못 초기화하는 바람에 방문을 하고 있었다.
 백트랙킹 및 인접 위치 방문 체크 방식을 바꾸려다가, 방문 배열을 int형으로 바꾸고 count형식으로 바꿔서 해결할 수 있었다.
 조합 및 백트랙킹 정공법으로 풀었으면 그리 많이 헤매지 않았을 텐데 정말 많이 헤맸던 것 같다.
*/

import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static void combinations(int k, int s, int ret) {
        if (k == K) {
            ans = Math.max(ans, ret);
            return;
        }
        for (int i=s; i<N*M; i++) {
            int y = i / M;
            int x = i % M;
            if (visited[y][x] == 0) {
                check(y, x, 1);
                combinations(k + 1, i + 1, ret + graph[y][x]);
                check(y, x, -1);
            }
        }
    }

    static void check(int y, int x, int n) {
        visited[y][x] += n;
        for (int w=0; w<4; w++) {
            int ny = y + dy[w];
            int nx = x + dx[w];
            if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                visited[ny][nx] += n;
            }
        }
    }

    static int N, M, K;
    static int ans = -Integer.MAX_VALUE;
    static int[][] graph;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combinations(0, 0, 0);
        System.out.println(ans);
    }
}
