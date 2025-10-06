// Thread Tree (16975번)
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] tree;
    static String[] messages;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        messages = new String[N];
        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();

        // i번째 게시글이 ki번째 게시글의 답글이다
        int k = Integer.parseInt(br.readLine());
        messages[0] = br.readLine();
        for (int i = 1; i < N; i++) {
            k = Integer.parseInt(br.readLine()) - 1;
            messages[i] = br.readLine();
            tree[k].add(i);
        }

        visited = new boolean[N];
        dfs(0, 0);
    }

    private static void dfs(int cur, int rpt) {
        visited[cur] = true;
        System.out.println(".".repeat(rpt) + messages[cur]);
        for (int nxt : tree[cur]) {
            if (!visited[nxt]) {
                dfs(nxt, rpt + 1);
            }
        }
    }
}

