import java.io.*;
import java.util.*;

// 첫 차 타기 (31829번)
public class Main {

    static final long INF = Long.MAX_VALUE;
    static int N, K, X, Y;
    static ArrayList<Pair>[][] graph;
    static long[][] dist;

    static long dijkstra() {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.cost));
        pq.add(new Pair(1, 0, 0)); // (현재 위치, 2차원 인덱스, 비용; 시간)
        dist[0][1] = 0; // 인도에서 시작
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int cur = p.cur;
            int z = p.z; // 0: 인도, 1: 버스
            long curCost = p.cost;
            if (dist[z][cur] < curCost) continue; // 이미 더 짧은 경로가 있음
            if (z == 1) { // 이미 버스 시간을 초과한 상태
                for (int i = 0; i < graph[1][cur].size(); i++) {
                    Pair nxtPair = graph[1][cur].get(i);
                    int nxt = nxtPair.cur;
                    long nxtCost = curCost + nxtPair.cost;
                    if (nxtCost < dist[1][nxt]) {
                        dist[1][nxt] = nxtCost;
                        pq.add(new Pair(nxt, 1, nxtCost));
                    }
                }
            } else {
                // 인도로 이동
                for (int i = 0; i < graph[0][cur].size(); i++) {
                    Pair nxtPair = graph[0][cur].get(i);
                    int nxt = nxtPair.cur;
                    long nxtCost = curCost + nxtPair.cost;
                    if (nxtCost < dist[0][nxt]) {
                        dist[0][nxt] = nxtCost;
                        if (nxtCost < K) { // K 이전의 시간에는 인도에서만 이동
                            pq.add(new Pair(nxt, 0, nxtCost));
                        } else {
                            pq.add(new Pair(nxt, 1, nxtCost)); // K 이후의 시간에는 상태공간 그래프 이동하여 이동
                        }
                    }
                }

                // K까지 기다린 다음 버스 노선 포함하여 이동
                if (curCost < K) {
                    for (int i = 0; i < graph[1][cur].size(); i++) {
                        Pair nxtPair = graph[1][cur].get(i);
                        int nxt = nxtPair.cur;
                        long nxtCost = K + nxtPair.cost; // K까지 기다린 후 이동
                        if (nxtCost < dist[1][nxt]) {
                            dist[1][nxt] = nxtCost;
                            pq.add(new Pair(nxt, 1, nxtCost));
                        }
                    }
                }
            }
        }

        return Math.min(dist[0][N], dist[1][N]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        dist = new long[2][N + 1];
        graph = new ArrayList[2][N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[0][i] = new ArrayList<>();
            graph[1][i] = new ArrayList<>();
            dist[0][i] = INF;
            dist[1][i] = INF;
        }

        // 인도
        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Pair p1 = new Pair(e, d);
            Pair p2 = new Pair(s, d);
            graph[0][s].add(p1);
            graph[0][e].add(p2);
            graph[1][s].add(p1); // K 이후의 시간에는 상태공간 그래프 이동하여 이동
            graph[1][e].add(p2);
        }

        // 버스
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[1][s].add(new Pair(e, d));
            graph[1][e].add(new Pair(s, d));
        }

        long ans = dijkstra();
        System.out.println(ans);

    }
}

class Pair {
    int cur;
    int z;
    long cost;
    Pair() {}
    Pair(int cur, long cost) {
        this.cur = cur;
        this.cost = cost;
    }
    Pair(int cur, int z, long cost) {
        this.cur = cur;
        this.z = z;
        this.cost = cost;
    }
}
