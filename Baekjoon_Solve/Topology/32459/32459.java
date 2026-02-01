// Kingdom’s Development Plan (32459번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] graph;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b] += 1;
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder result = topologicSort();
        System.out.println(result.toString().trim());
        bw.close();
        br.close();

    }

    private static StringBuilder topologicSort() {
        StringBuilder sb = new StringBuilder();
        int complete = 0;
        while (!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now).append(" ");
            complete += 1;
            for (int nxt : graph[now]) {
                indegree[nxt] -= 1;
                if (indegree[nxt] == 0) {
                    pq.add(nxt);
                }
            }
        }
        if (complete == N) {
            return sb;
        } else {
            return new StringBuilder("IMPOSSIBLE");
        }
    }
}
