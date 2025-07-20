import java.io.*;
import java.util.*;

// 야쿠르트 아줌마 야쿠르트 주세요 (20160번)
public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int V, E, R;
    static int[] yakult;
    static Map<Integer, Integer>[] graph;

    static long[] dijkstra(int s) {
        long[] dist = new long[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.d, o2.d));
        pq.add(new Pair(s, 0));
        dist[s] = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int cur = pair.cur;
            long d = pair.d;
            if (dist[cur] < d) continue;
            for (int nxt : graph[cur].keySet()) {
                int cost = graph[cur].get(nxt);
                if (d + cost < dist[nxt]) {
                    dist[nxt] = d + cost;
                    pq.add(new Pair(nxt, dist[nxt]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new Map[V + 1];
        for (int i = 0; i < V + 1; i++) graph[i] = new HashMap<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].computeIfPresent(v, (key, value) -> Math.min(value, w));
            graph[u].putIfAbsent(v, w);
            graph[v].computeIfPresent(u, (key, value) -> Math.min(value, w));
            graph[v].putIfAbsent(u, w);
        }

        yakult = new int[11];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> indexMap = new HashMap<>();
        int idx = 0;
        for (int i = 1; i < 11; i++) {
            yakult[i] = Integer.parseInt(st.nextToken());
            if (indexMap.containsKey(yakult[i])) continue;
            indexMap.put(yakult[i], idx++);
        }

        R = Integer.parseInt(br.readLine()); // 내가 출발하는 정점
        if (!indexMap.containsKey(R)) indexMap.put(R, idx++);

        Map<Integer, long[]> distanceMap = new HashMap<>();
        for (int s : indexMap.keySet()) {
            distanceMap.put(indexMap.get(s), dijkstra(s));
        }

        long[] yakultDist = new long[11];
        yakultDist[0] = 0;
        yakultDist[1] = 0;
        int s = yakult[1]; // 야쿠르트 아줌마 시작점
        long[] dist = distanceMap.get(indexMap.get(s)); // s에서 모든 정점까지의 거리
        for (int i = 2; i < 11; i++) {
            int e = yakult[i]; // s -> e
            yakultDist[i] = dist[e]; // s에서 e까지의 거리
            if (dist[e] != INF) {
                s = e;
                dist = distanceMap.get(indexMap.get(s));
            }
        }

        long last = 0;
        for (int i = 1; i < 11; i++) {
            if (yakultDist[i] != INF) {
                yakultDist[i] += last;
                last = yakultDist[i];
            }
        }

        dist = distanceMap.get(indexMap.get(R));
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            if (yakultDist[i] != INF && dist[yakult[i]] <= yakultDist[i]) {
                candidates.add(yakult[i]);
            }
        }

        Collections.sort(candidates);
        if (candidates.isEmpty()) {
            bw.write("-1\n");
        } else {
            bw.write(candidates.get(0) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Pair {
    int cur;
    long d;
    Pair(int cur, long d) {
        this.cur = cur;
        this.d = d;
    }
}
