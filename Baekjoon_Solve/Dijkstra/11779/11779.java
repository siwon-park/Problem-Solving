import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Pair implements Comparable<Pair>{
        int n;
        int c;
        Pair(int n, int c) {
            this.n = n;
            this.c = c;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.c, o.c);
        }
    }

    /*
    * 다익스트라 최단거리를 구하는 함수
    * */
    static void dijkstra(int s) {
        dist[s] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Pair::compareTo);
        pq.add(new Pair(s, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (dist[pair.n] < pair.c) {
                continue;
            }
            for (int i=0; i<graph.get(pair.n).size(); i++) {
                Pair nxt = graph.get(pair.n).get(i);
                if (pair.c + nxt.c < dist[nxt.n]) {
                    dist[nxt.n] = pair.c + nxt.c;
                    path[nxt.n] = pair.n; // 이동 경로를 기록 nxt.n에 가기 전에 pair.n을 먼저 갔음
                    pq.add(new Pair(nxt.n, pair.c + nxt.c));
                }
            }
        }
    }

    /*
    * 길을 찾아주는 함수
    * */
    static ArrayList<Integer> findPath(int e) {
        ArrayList<Integer> route = new ArrayList<>(); // 최단 경로를 기록하기 위한 배열
        while(e != 0) {
            route.add(e);
            e = path[e];
        }
        return route;
    }

    static int N; // 도시의 개수
    static int M; // 버스의 개수
    static ArrayList<ArrayList<Pair>> graph; // 그래프
    static int[] dist; // 최단 거리 배열
    static int[] path; // 지나온 경로를 기록하기 위한 배열

    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        path = new int[N + 1];

        // 그래프 입력
        graph = new ArrayList<>();
        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
            dist[i] = MAX;
        }

        // 연결 관계 입력
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Pair(v, c));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        dijkstra(S);
        ArrayList<Integer> route = findPath(E);
        System.out.println(dist[E]);
        System.out.println(route.size());

        StringBuffer sb = new StringBuffer();
        for (int i=route.size()-1; i>=0; i--) {
            sb.append(route.get(i) + " ");
        }
        System.out.println(sb);
    }
}