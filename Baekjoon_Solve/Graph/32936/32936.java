import java.io.*;
import java.util.*;

// 타임머신 (32936번)
public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, M, a, b, c;

    static ArrayList<Integer>[] graph;
    static int[][] visited;

    static void bfs(int s, int idx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s, 0}); // 노드, 거리
        visited[s][idx] = 0;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int cur = pair[0];
            int d = pair[1];
            for (Integer nxt : graph[cur]) {
                // 아직 방문하지 않은 곳이면 방문
                if (visited[nxt][idx] == INF) {
                    visited[nxt][idx] = d + 1;
                    queue.add(new int[] {nxt, d + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken()); // 타임 머신이 있는 노드
        b = Integer.parseInt(st.nextToken()); // a -> b
        c = Integer.parseInt(st.nextToken()); // -c

        graph = new ArrayList[N + 1];
        visited = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            visited[i][0] = INF;
            visited[i][1] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }


        bfs(1, 0);
        bfs(b, 1);
        int ans = visited[N][0]; // 1 -> N까지의 거리

        if (visited[a][0] != INF && visited[N][1] != INF) {
            if (visited[a][1] < c) { // a -> b까지의 거리가 c보다 작으면 타임머신 사용 시 음수 무한 만들기 가능
                ans = -INF;
            }
            ans = Math.min(ans, visited[a][0] + visited[N][1] - c);
        }

        if (ans == INF) {
            System.out.println("x");
        } else if (ans == -INF) {
            System.out.println("-inf");
        } else {
            System.out.println(ans);
        }

    }
}
