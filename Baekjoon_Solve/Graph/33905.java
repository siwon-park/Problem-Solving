import java.io.*;
import java.util.*;

// 영일 마을에 살고 있는 엄은 친구의 집에 가고 싶다 (33905번)
public class Main {

    static int N, M, K;
    static Set<Integer> blockedSet = new HashSet<>();
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 2];
        for (int i = 0; i <= N + 1; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) blockedSet.add(Integer.parseInt(st.nextToken()));

        int ans = bfs();
        System.out.println(ans);
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[N + 2];
        visited[1] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph[cur]) {
                if (visited[nxt] || blockedSet.contains(nxt)) continue; // 이미 방문했거나 막힌 곳이면 방문 불가
                visited[nxt] = true;
                queue.add(nxt);
                cnt += 1;
            }
        }
        return cnt;
    }
}

