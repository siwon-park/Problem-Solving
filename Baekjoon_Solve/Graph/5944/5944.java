import java.io.*;
import java.util.*;

// Apple Delivery (5944번)
public class Main {

    static final long MAX = Long.MAX_VALUE;
    static int C, P, PB, PA1, PA2;
    static ArrayList<int[]>[] graph;

    static long[] dijkstra(int s) {
        long[] distance = new long[P + 1];
        Arrays.fill(distance, MAX);
        distance[s] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));
        pq.add(new Pair(s, 0));
        Pair pair;
        int[] nxt;
        while (!pq.isEmpty()) {
            pair = pq.poll();
            int cur = pair.cur;
            long d = pair.dist;
            if (distance[cur] < d) {
                continue;
            }
            for (int i = 0; i < graph[cur].size(); i++) {
                nxt = graph[cur].get(i);
                int nxtP = nxt[0];
                int nxtD = nxt[1];
                if (d + nxtD < distance[nxtP]) {
                    distance[nxtP] = d + nxtD;
                    pq.add(new Pair(nxtP, d + nxtD));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        PB = Integer.parseInt(st.nextToken());
        PA1 = Integer.parseInt(st.nextToken());
        PA2 = Integer.parseInt(st.nextToken());

        graph = new ArrayList[P + 1];
        for (int i = 0; i <= P; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            // 양방향
            graph[p1].add(new int[] {p2, d});
            graph[p2].add(new int[] {p1, d});
        }

        long[] dist1 = dijkstra(PA1);
        long[] dist2 = dijkstra(PA2);

        long ans = MAX;
        long p1ToP2 = dist1[PA2]; // PA1 -> PA2
        long p2ToP1 = dist2[PA1]; // PA2 -> PA1
        ans = Math.min(p1ToP2 + dist2[PB], p2ToP1 + dist1[PB]);
        System.out.println(ans);
    }
}

class Pair {
    int cur;
    long dist;
    Pair(int cur, long dist) {
        this.cur = cur;
        this.dist = dist;
    }
}
