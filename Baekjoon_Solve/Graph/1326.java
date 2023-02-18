// 폴짝폴짝(1326번)
//////////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1326
  // BFS
  // 실수하나 때문에 시간을 좀 잡아먹혔다.
  // 문제에서 역방향으로 갈 수도 있는 것을 눈치를 못 챘다. 질문 게시판을 통해서 알 수 있었다.
  // 점프를 한다고 했으니 역방향도 갈 수 있다.
  // 저질렀던 실수는 아래 주석에 달아놓았다.
//////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int jump = graph[cur];
            int i = 1;
            while (0 < cur + jump * i && cur + jump * i <= N) {
                if (visited[cur] + 1 < visited[cur + jump * i]) {
                    visited[cur + jump * i] = visited[cur] + 1;
                    queue.add(cur + jump * i);
                }
                i += 1;
            }

            int j = 1; // 여기서 j를 1로 선언하지 않고, cur - jump * i를 계속하고 있었다. 이는 틀린 것으로 i가 초기화되지 않았으니, 음수방향 점프가 잘못 계산된다.
            while (0 < cur - jump * j && cur - jump * j <= N) {
                if (visited[cur] + 1 < visited[cur - jump * j]) {
                    visited[cur - jump * j] = visited[cur] + 1;
                    queue.add(cur - jump * j);
                }
                j += 1;
            }
        }
    }

    static int N;
    static int a;
    static int b;
    static long[] visited;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new long[N + 1];
        long INF = 1000000000;
        graph = new int[N + 1];
        String[] tmp = br.readLine().split(" ");

        for (int i=1; i<N+1; i++) {
            graph[i] = Integer.parseInt(tmp[i - 1]);
            visited[i] = INF;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        bfs(a);
        if (visited[b] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(visited[b]);
        }
        br.close();
    }
}
