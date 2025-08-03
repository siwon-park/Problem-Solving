import java.io.*;
import java.util.*;

// Pirates’ Path (5297번)
public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, B, S, E;
    static ArrayList<int[]>[] graph;

    static int bfs(int s, int e) {
        int ans = INF;
        int[] visited = new int[N];
        Deque<int[]> deque = new LinkedList<>();
        deque.addFirst(new int[] {s, 0});
        visited[s] = 0;
        while (!deque.isEmpty()) {
            int[] pair = deque.pollFirst();
            int cur = pair[0];
            int d = pair[1];
            if (cur == e) ans = Math.min(ans, d);
            for (int i = 0; i < graph[cur].size(); i++) {
                int[] nxtPair = graph[cur].get(i);
                int nxt = nxtPair[0];
                int cost = nxtPair[1];
                if (d + cost < visited[nxt]) {
                    visited[nxt] = d + cost;
                    if (cost == 0) deque.addFirst(new int[] {nxt, d});
                    else deque.addLast(new int[] {nxt, d + 1});
                }
            }
        }
        return INF;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 섬의 수
        B = Integer.parseInt(st.nextToken()); // 다리의 수 (간선의 수)
        S = Integer.parseInt(st.nextToken()); // 시작점
        E = Integer.parseInt(st.nextToken()); // 도착점

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 0: 없음, 1: 있음
            graph[a].add(new int[] {b, c});
            graph[b].add(new int[] {a, c});
        }

        int ans = bfs(S, E);
        if (ans == INF) bw.write("It's over with Captain Jack. At least till Pirates of the Caribbean 3.");
        else bw.write(String.format("%s native(s) on the easiest way for Captain Jack.", ans));

        bw.flush();
        bw.close();
        br.close();
    }
}

