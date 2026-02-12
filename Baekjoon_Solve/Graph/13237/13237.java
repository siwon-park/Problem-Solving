// Binary tree (13237번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, root;
    static int[] level;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        level = new int[N + 1];
        graph = new ArrayList[N + 1];
        graph[0] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        root = 0;
        for (int i = 1; i <= N; i++) {
            int node = Integer.parseInt(br.readLine());
            if (node == -1) {
                root = i;
            } else {
                graph[node].add(i);
            }
        }

        dfs(root, 0);
        for (int i = 1; i <= N; i++) {
            bw.write(level[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int cur, int depth) {
        level[cur] = depth;
        for (int nxt : graph[cur]) {
            dfs(nxt, depth + 1);
        }
    }
}

