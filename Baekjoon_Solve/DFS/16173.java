// 점프왕 쩰리(small) (16173번)
//////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/16173
  // 그래프 탐색
  // 아주 기본적인 그래프 탐색으로 (0, 0)에서 (N-1, N-1)까지 갈 수 있는지 확인하는 문제이다.
  // DFS로 구현하였다.
//////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void dfs(int y, int x) {
        if (y == N - 1 && x == N - 1) {
            isPossible = "HaruHaru";
            return;
        }
        int k = graph[y][x];
        for (int d=0; d<2; d++) {
            int dy = yd[d];
            int dx = xd[d];
            int ny = y + dy * k;
            int nx = x + dx * k;
            if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }

    static int N;
    static int[][] graph;
    static int[] yd = {1, 0};
    static int[] xd = {0, 1};
    static boolean[][] visited;
    static String isPossible = "Hing";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        visited[0][0] = true;
        dfs(0, 0);
        System.out.println(isPossible);
        br.close();
    }
}



