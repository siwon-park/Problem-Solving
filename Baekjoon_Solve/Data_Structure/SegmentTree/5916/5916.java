// 농장 관리 (5916번)
import java.io.*;
import java.util.*;

public class Main {

    static final int LOG = 21; // 2 ^ 20 = 100만
    static int N, M, ord; // 농장의 수, 쿼리의 수, 순서
    static int[] depth; // 깊이 배열
    static int[][] parent, preOrd; // 부모 배열
    static ArrayList<ArrayList<Integer>> graph; // 그래프 (트리의 루트를 1로 가정함)

    /*
     * 전위순회 결과와 깊이를 구하는 함수
     * */
    static void dfs(int cur, int d) {
        depth[cur] = d;
        preOrd[cur][0] = ++ord;
        for (int i = 0; i < graph.get(cur).size(); i++) {
            int nxt = graph.get(cur).get(i);
            if (depth[nxt] == -1) {
                parent[nxt][0] = cur;
                dfs(nxt, d + 1);
            }
        }
        preOrd[cur][1] = ord;
    }

    /*
     * 부모 배열을 세팅하는 함수
     * */
    static void setParent() {
//        parent[1][0] = 1;
        for (int k = 0; k < LOG - 1; k++) {
            for (int n = 1; n < N + 1; n++) {
                if (parent[n][k] != -1) parent[n][k + 1] = parent[parent[n][k]][k];
            }
        }
    }


    /*
     * LCA를 구하는 함수
     * */
    static int findLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        int diff = depth[a] - depth[b];
        for (int i = 0; diff > 0; i++) {
            if (diff % 2 == 1) a = parent[a][i];
            diff /= 2;
        }

        if (a == b) return a;
        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ord = 0;
        depth = new int[N + 1];
        Arrays.fill(depth, -1);
        preOrd = new int[N + 1][2];
        parent = new int[N + 1][LOG];

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(parent[i], -1);
            graph.add(new ArrayList<>());
        }

        int u, v;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1 , 0);
        setParent();
        SegmentTree segmentTree = new SegmentTree(N);

        String cmd;
        int lca;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            lca = findLCA(u, v);
            if (cmd.equals("P")) { // PLANT
                segmentTree.update(1, N, 1, preOrd[lca][0], -2);
                segmentTree.update(1, N, 1, preOrd[u][0], 1);
                segmentTree.update(1, N, 1, preOrd[v][0], 1);
            } else { // QUANTITY
                int nxt;
                if (preOrd[u][0] < preOrd[v][0]) nxt = v;
                else nxt = u;
                bw.write(segmentTree.sum(1, N, 1, preOrd[nxt][0], preOrd[nxt][1]) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    long[] tree;

    SegmentTree(int n) {
        this.tree = new long[n * 4];
    }

    void update(int s, int e, int n, int idx, int w) {
        if (idx < s || e < idx) return;
        if (idx == s && e == idx) {
            tree[n] += w;
            return;
        }
        int mid = (s + e) / 2;
        update(s, mid, n * 2, idx, w);
        update(mid + 1, e, n * 2 + 1, idx, w);
        tree[n] = tree[n * 2] + tree[n * 2 + 1];
    }

    long sum(int s, int e, int n, int l, int r) {
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
    }
}