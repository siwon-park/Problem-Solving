// Milk Scheduling (5847번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] indegree, time;
    static long[] dp;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        time = new int[N + 1];

        graph = new ArrayList[N + 1];
        graph[0] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            time[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b] += 1;
        }

        dp = new long[N + 1];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(new Pair(i, time[i]));
                dp[i] = time[i];
            }
        }

        long ans = 0;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int nxt : graph[cur.node]) {
                indegree[nxt] -= 1;
                dp[nxt] = Math.max(dp[nxt], dp[cur.node] + time[nxt]);
                if (indegree[nxt] == 0) {
                    queue.add(new Pair(nxt, dp[nxt]));
                }
            }
            ans = Math.max(ans, cur.cost);
        }
        System.out.println(ans);
    }
}

class Pair {
    int node;
    long cost;
    Pair(int node, long cost) {
        this.node = node;
        this.cost = cost;
    }
}
