import java.io.*;
import java.util.*;

// Heat Wave (5996번)
public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int T, C, Ts, Te;
    static ArrayList<int[]>[] graph;
    static int[] distance;

    static int dijkstra(int s, int e) {
        distance[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        pq.add(new int[]{0, s}); // {거리, 노드}
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int d = pair[0];
            int cur = pair[1];
            if (distance[cur] < d) continue;
            if (cur == e) return distance[e];
            for (int[] node : graph[cur]) {
                int nxt = node[0];
                int cost = node[1];
                if (d + cost < distance[nxt]) {
                    distance[nxt] = d + cost;
                    pq.add(new int[] {distance[nxt], nxt});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Ts = Integer.parseInt(st.nextToken());
        Te = Integer.parseInt(st.nextToken());
        graph = new ArrayList[T + 1];
        distance = new int[T + 1];
        for (int i = 0; i <= T; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 양방향
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        System.out.println(dijkstra(Ts, Te));

    }
}
