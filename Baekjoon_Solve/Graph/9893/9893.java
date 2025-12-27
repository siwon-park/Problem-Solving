// Paths (9893번)
import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static ArrayList<int[]>[] graph;
    static int[][] distance; // distance[i][j]: 0에서 i까지 j번 링크로 갔을 때의 최소 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, w});
        }

        distance = new int[N][M + 1];
        for (int i = 0; i < N; i++) Arrays.fill(distance[i], INF);
        distance[0][0] = 0;

        int ans = dijkstra(0, 1);
        System.out.println(ans);
    }

    // 최소 링크, 최소 비용의 경로 찾기
    private static int dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] o) -> o[2])
                    .thenComparingInt(o -> o[1])
                    .thenComparingInt(o -> o[0])
        );
        pq.add(new int[] {start, 0, 0}); // {노드, 비용, 링크 수}
        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int cur = curNode[0];
            int curCost = curNode[1];
            int curLinks = curNode[2];
            if (distance[cur][curLinks] < curCost) continue;
            for (int[] nxtNode : graph[cur]) {
                int nxt = nxtNode[0];
                int nxtCost = nxtNode[1];
                if (curLinks + 1 > M) continue;
                if (distance[nxt][curLinks + 1] > curCost + nxtCost) {
                    distance[nxt][curLinks + 1] = curCost + nxtCost;
                    pq.add(new int[] {nxt, distance[nxt][curLinks + 1], curLinks + 1});
                }
            }
        }
        for (int i = 0; i <= M; i++) {
            if (distance[end][i] != INF) return distance[end][i];
        }
        return -1;
    }

}
