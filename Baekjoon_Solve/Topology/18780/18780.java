// Timeline (18780번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, M, C;
    static int[] indegree;
    static long[] dp;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        dp = new long[N + 1];
        graph = new ArrayList[N + 1];
        graph[0] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            indegree[b]++;
            graph[a].add(new int[] {b, x});
        }

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.add(new Pair(i, dp[i]));
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int[] nxt : graph[pair.cur]) {
                int next = nxt[0];
                int x = nxt[1];
                dp[next] = Math.max(dp[next], pair.x + x);
                indegree[next]--;
                if (indegree[next] == 0) queue.add(new Pair(next, dp[next]));
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write(dp[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Pair {
    int cur;
    long x;

    public Pair(int cur, long x) {
        this.cur = cur;
        this.x = x;
    }
}

