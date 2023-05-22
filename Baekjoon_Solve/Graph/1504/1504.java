// 특정한 최단 경로 (1504번)
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] dijkstra(int s) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, MAX);
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Pair(s, 0));
        while (!pq.isEmpty()) {
            Pair curPair = pq.poll();
            if (distance[curPair.node] < curPair.cost) continue;
            for (int i = 0; i < graph.get(curPair.node).size(); i++) {
                Pair nxtPair = graph.get(curPair.node).get(i);
                int newCost = curPair.cost + nxtPair.cost;
                if (newCost < distance[nxtPair.node]) {
                    distance[nxtPair.node] = newCost;
                    pq.add(new Pair(nxtPair.node, newCost));
                }
            }
        }
        return distance;
    }

    static int N, E; // 정점의 개수, 간선의 개수
    static final int MAX = 200_000 * 1_000; // 간선수 x 가중치 최댓값
    static ArrayList<ArrayList<Pair>> graph; // 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        int a, b, c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Pair(b, c));
            graph.get(b).add(new Pair(a, c));
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int v1 = Math.min(a, b);
        int v2 = Math.max(a, b);

        int[] dist1 = dijkstra(1);
        int[] dist2 = dijkstra(v1);
        int[] dist3 = dijkstra(v2);

        int path1 = dist1[v1] + dist2[v2] + dist3[N]; // 1 -> v1, v1 -> v2, v2 -> N
        int path2 = dist1[v2] + dist3[v1] + dist2[N]; // 1 -> v2, v2 -> v1, v1 -> N
        int min_dist = Math.min(path1, path2);
        if (v1 == 1 && v2 == N) min_dist = Math.min(min_dist, dist1[N]);
        System.out.println(min_dist >= MAX ? -1 : min_dist);
    }
}

class Pair {
    int node;
    int cost;
    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}