// Salary Inequity (10565번)
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int preOrder(int cur) {
        preOrd[cur] = ++ord;
        int last = cur;
        int size = graph.get(cur).size();
        for (int i = 0; i < size; i++) {
            int nxt = graph.get(cur).get(i);
            last = preOrder(nxt);
        }
        subTree[cur] = last;
        return subTree[cur];
    }

    static int T, N, Q, ord; // 테스트 케이스의 수, 노드의 수, 쿼리의 수, 방문 순서
    static int[] arr, preOrd, subTree; // 초기 배열, 전위 순회, 서브 트리상 마지막 노드
    static ArrayList<ArrayList<Integer>> graph; // 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        int t = 0;
        while (t++ < T) {
            N = Integer.parseInt(br.readLine());
            graph = new ArrayList<>();
            for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            for (int i = 2; i < N + 1; i++) {
                int p = Integer.parseInt(st.nextToken());
                graph.get(p).add(i); // p의 자식 i
            }

            int[] orgArr = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) orgArr[i] = Integer.parseInt(st.nextToken());

            ord = 0;
            preOrd = new int[N + 1];
            arr = new int[N + 1];
            subTree = new int[N + 1];
            preOrder(1);
            for (int i = 1; i < N + 1; i++) arr[preOrd[i]] = orgArr[i];

            SegmentTree segmentTree = new SegmentTree(N, arr);
            segmentTree.init(1, N, 1);

            Q = Integer.parseInt(br.readLine());
            String cmd;
            int a, b;
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                cmd = st.nextToken();
                a = Integer.parseInt(st.nextToken());
                if (cmd.equals("R")) {
                    b = Integer.parseInt(st.nextToken());
                    segmentTree.update(1, N, 1, preOrd[a], preOrd[subTree[a]], b);
                } else {
                    long max = segmentTree.max(1, N, 1, preOrd[a], preOrd[subTree[a]]);
                    long min = segmentTree.min(1, N, 1, preOrd[a], preOrd[subTree[a]]);
                    bw.write(max - min + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    long[][] tree; // 0: 최댓값, 1: 최솟값
    long[] lazy;
    int[] arr;

    SegmentTree(int n, int[] arr) {
        this.tree = new long[n * 4][2];
        this.lazy = new long[n * 4];
        this.arr =  arr;
    }

    void init(int s, int e, int n) {
        if (s == e) {
            tree[n][0] = arr[s];
            tree[n][1] = arr[s];
            return;
        }
        int mid = (s + e) / 2;
        init(s, mid, n * 2);
        init(mid + 1, e, n * 2 + 1);
        tree[n][0] = Math.max(tree[n * 2][0], tree[n * 2 + 1][0]);
        tree[n][1] = Math.min(tree[n * 2][1], tree[n * 2 + 1][1]);
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {
            tree[n][0] += lazy[n];
            tree[n][1] += lazy[n];
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 + 1] += lazy[n];
            }
            lazy[n] = 0;
        }
    }

    void update(int s, int e, int n, int l, int r, int w) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            lazy[n] += w;
            lazyPropagation(s, e, n);
            return;
        }
        int mid = (s + e) / 2;
        update(s, mid, n * 2, l, r, w);
        update(mid + 1, e, n * 2 + 1, l, r, w);
        tree[n][0] = Math.max(tree[n * 2][0], tree[n * 2 + 1][0]);
        tree[n][1] = Math.min(tree[n * 2][1], tree[n * 2 + 1][1]);
    }

    long max(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return Long.MIN_VALUE;
        if (l <= s && e <= r) return tree[n][0];
        int mid = (s + e) / 2;
        return Math.max(max(s, mid, n * 2, l, r), max(mid + 1, e, n * 2 + 1, l, r));
    }

    long min(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return Long.MAX_VALUE;
        if (l <= s && e <= r) return tree[n][1];
        int mid = (s + e) / 2;
        return Math.min(min(s, mid, n * 2, l, r), min(mid + 1, e, n * 2 + 1, l, r));
    }
}