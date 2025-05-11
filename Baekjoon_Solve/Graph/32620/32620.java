import java.io.*;
import java.util.*;

// 점령 (32620번)
public class Main {

    static int N, M, r;
    static ArrayList<Integer>[] graph;
    static int[] A, B;

    static long bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]); // 역순정렬
            }
            return Integer.compare(o1[0], o2[0]);
        });
        pq.add(new int[] {A[r], B[r], r});
        boolean[] visited = new boolean[N + 1];
        visited[r] = true;
        long ans = 0L;

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int a = pair[0];
            int b = pair[1];
            int cur = pair[2];
            if (a <= ans) { // 점령 가능하면 점령함
                ans += b;
                for (int nxt : graph[cur]) {
                    if (!visited[nxt]) { // 우선 이웃하면 방문을 해봄
                        visited[nxt] = true;
                        pq.add(new int[] {A[nxt], B[nxt], nxt});
                    }
                }
            } else {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        B = new int[N + 1];
        graph = new ArrayList[N + 1];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        long ans = bfs();
        System.out.println(ans);

    }
}
