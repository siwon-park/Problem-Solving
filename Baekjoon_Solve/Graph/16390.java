// Sheba’s Amoebas (16390번)
/*
  문제: https://www.acmicpc.net/problem/16390
  DFS, BFS
  기본적인 DFS, BFS 문제
  연결 컴포넌트의 개수를 출력하면 된다.
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void dfs(int y, int x) {
        for (int k=0; k<8; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                if (!visited[ny][nx] && graph[ny].charAt(nx) == '#') {
                    visited[ny][nx] = true;
                    dfs(ny, nx);
                }
            }
        }
    }

    static int N, M, ans;
    static String[] graph;
    static boolean[][] visited;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[N];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            graph[i] = br.readLine();
        }

        ans = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!visited[i][j] && graph[i].charAt(j) == '#') {
                    visited[i][j] = true;
                    ans += 1;
                    dfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }
}
