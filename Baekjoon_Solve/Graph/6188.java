// Clear Cold Water (6188번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static int[][] tree;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        tree = new int[N + 1][2];
        distance = new int[N + 1];
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            tree[e][0] = b1;
            tree[e][1] = b2;
        }

        dfs(1, 1);

        for (int i = 1; i <= N; i++) {
            bw.write(distance[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int cur, int depth) {
        distance[cur] = depth;
        for (int nxt : tree[cur]) {
            if (nxt != 0) {
                dfs(nxt, depth + 1);
            }
        }
    }
}

