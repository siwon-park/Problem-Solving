import java.io.*;
import java.util.*;

// RUN (18402번)
public class Main {

    static int N, M, E, T;
    static ArrayList<int[]>[] graph;

    static int[] dijkstra(int s) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, T + 1);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[] {s, 0});
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int cur = pair[0];
            int d = pair[1];
            if (dist[cur] < d) continue;
            for (int[] nxtPair : graph[cur]) {
                int nxt = nxtPair[0];
                int nd = d + nxtPair[1];
                if (nd <= T && nd < dist[nxt]) {
                    dist[nxt] = nd;
                    pq.add(new int[] {nxt, nd});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine().trim()); // 노드 수
        E = Integer.parseInt(br.readLine().trim()); // 출구 번호
        T = Integer.parseInt(br.readLine().trim()); // 시간 제한
        M = Integer.parseInt(br.readLine().trim()); // 간선 수(단방향)

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        String[] splits;
        for (int i = 0; i < M; i++) {
            // 입력에 불필요한 공백이 있어서 공백 처리함
            splits = br.readLine().trim().split("\\s+");
            int a = Integer.parseInt(splits[0]);
            int b = Integer.parseInt(splits[1]);
            int t = Integer.parseInt(splits[2]);
            graph[b].add(new int[] {a, t}); // 역방향 그래프
        }

        int[] distance = dijkstra(E);
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= T) cnt++;
        }

        System.out.println(cnt);

    }
}
