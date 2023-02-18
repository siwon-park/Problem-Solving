// 지금 만나러 갑니다 (18235번)
///////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/18235
  // BFS
  // 파이썬 풀이법 참조
  // 확실히 java가 Pypy보다 빠르다...
///////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int d;
        int cur;

        Pair(int d, int cur) {
            this.d = d;
            this.cur = cur;
        }
    }

    static boolean[][] bfs(int s) {
        boolean[][] visited = new boolean[N + 1][20];
        visited[s][0] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, s));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int d = pair.d;
            int cur = pair.cur;

            for (int k=0; k<2; k++) {
                int nxt = cur + dx[k] * (int) Math.pow(2, d);
                if ( 0 < nxt && nxt < N + 1 && d + 1 < 20 && !visited[nxt][d + 1]) {
                    visited[nxt][d + 1] = true;
                    queue.add(new Pair(d + 1, nxt));
                }
            }
        }

        return visited;
    }

    static int isPossible(boolean[][] v1, boolean[][] v2) {
        for (int j=0; j<20; j++) {
            for (int i=1; i<N+1; i++) {
                if (v1[i][j] == true && v2[i][j] == true) {
                    return j;
                }
            }
        }

        return -1;
    }

    static int N, A, B;
    static int[] dx = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        boolean[][] v1 = bfs(A);
        boolean[][] v2 = bfs(B);

        int ret = isPossible(v1, v2);

        System.out.println(ret);
        br.close();
    }
}
