import java.io.*;
import java.util.*;

// 두 단계 최단 경로 1 (23793번)
public class Main {

    static final int MAX = Integer.MAX_VALUE;
    static int N, M;
    static ArrayList<int[]>[] graph;

    static int dijkstra(int s, int e, int y, boolean flag) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, MAX);
        distance[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        pq.add(new int[]{0, s});
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int d = pair[0];
            int cur = pair[1];
            if (distance[cur] < d) continue;
            if (cur == e) return distance[cur];
            for (int i = 0; i < graph[cur].size(); i++) {
                int[] nextPair = graph[cur].get(i);
                int nxt = nextPair[0];
                int nxtD = nextPair[1];
                if (flag && nxt == y) continue; // 갈 수 없음
                if (d + nxtD < distance[nxt]) {
                    distance[nxt] = d + nxtD;
                    pq.add(new int[]{d + nxtD, nxt});
                }
            }
        }
        return MAX;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, w}); // 단방향 u -> v
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        int ans1 = -1;
        int d1 = dijkstra(x, y, y, false); // x -> y
        if (d1 != MAX) {
            int d2 = dijkstra(y, z, y, false); // y -> z
            if (d2 != MAX) {
                ans1= d1 + d2;
            }
        }

        int ans2 = -1;
        int d3 = dijkstra(x, z, y, true); // x -> z (단, y는 못 지나감)
        if (d3 != MAX) ans2 = d3;

        System.out.println(ans1 + " " + ans2);
    }
}

