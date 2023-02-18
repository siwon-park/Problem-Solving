// Oil Deposits(4677번)
////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/4677
  // BFS
  // 가로, 세로, 대각선 방향으로 "@"으로 구성된 연결 컴포넌트의 개수가 주어진 그래프에서 몇 개 있는지 찾는 문제이다.
  // 단순 BFS로 해결 
////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
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

    static int bfs(int n, int m, String[][] graph) {
        int cnt = 0;
        int[][] visited = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {

                if (visited[i][j] == 0 && graph[i][j].equals("@")) {
                    visited[i][j] = 1;
                    cnt ++;
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j));

                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        int y = pair.y;
                        int x = pair.x;

                        for (int k=0; k<8; k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];

                            if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                                if (graph[ny][nx].equals("@") && visited[ny][nx] == 0) {
                                    visited[ny][nx] = 1;
                                    queue.add(new Pair(ny, nx));
                                }
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }

    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (m == 0) {
                break;
            }

            String[][] graph = new String[n][m];
            for (int i=0; i<n; i++) {
                graph[i] = br.readLine().split("");
            }

            int ret = bfs(n, m, graph);
            bw.write(ret + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
