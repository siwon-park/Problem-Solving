// Treasure Cave (6125번)
import java.io.*;
import java.util.*;

public class Main {

    static int P, NS, T, D;
    static ArrayList<Integer>[] graph;
    static Deque<Integer> path = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        NS = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        graph = new ArrayList[P + 1];
        graph[0] = new ArrayList<>();
        for (int i = 1; i <= P; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < NS; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            graph[n].add(b1);
            graph[n].add(b2);
        }
        dfs(1);
        bw.write(D + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int cur) {
        path.addFirst(cur);
        if (cur == T) {
            D = path.size();
            while (!path.isEmpty()) {
                sb.append(path.pollLast()).append("\n");
            }
            return;
        }
        for (int nxt : graph[cur]) {
            dfs(nxt);
        }
        if (!path.isEmpty()) path.pollFirst();
    }

}

