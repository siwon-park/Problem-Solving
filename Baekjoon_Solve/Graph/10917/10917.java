// Your life (10917번)
import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = Integer.MAX_VALUE;
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visited = new int[N + 1];
        Arrays.fill(visited, MAX);
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph[cur]) {
                if (visited[nxt] > visited[cur] + 1) {
                    visited[nxt] = visited[cur] + 1;
                    queue.add(nxt);
                }
            }
        }

        if (visited[N] == MAX) System.out.println(-1);
        else System.out.println(visited[N]);

    }
}
