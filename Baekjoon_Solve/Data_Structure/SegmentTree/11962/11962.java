// Counting Haybales (11962번)
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N, arr);
        segmentTree.init(1, N, 1);

        String q; // 쿼리 종류
        int a, b, c; // 구간 [A, B], 값 C
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            q = st.nextToken();
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (q.equals("M")) { // 구간 최솟값 출력
                long ret = segmentTree.min(1, N, 1, a, b);
                bw.write(ret + "\n");
            } else if (q.equals("S")) { // 구간 합 출력
                long ret = segmentTree.sum(1, N, 1, a, b);
                bw.write(ret + "\n");
            } else { // 구간 업데이트
                c = Integer.parseInt(st.nextToken());
                segmentTree.update(1, N, 1, a, b, c);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
 * 구간 합과 구간 최솟값을 저장하고 있는 세그먼트 트리
 * */
class SegmentTree {

    long[][] tree;
    long[] lazy;
    int[] arr;

    SegmentTree(int n, int[] arr) {
        this.tree = new long[n * 4][2];
        this.lazy = new long[n * 4];
        this.arr = arr;
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
        tree[n][0] = tree[n * 2][0] + tree[n * 2 + 1][0];
        tree[n][1] = Math.min(tree[n * 2][1], tree[n * 2 + 1][1]);
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {
            tree[n][0] += (e - s + 1) * lazy[n];
            tree[n][1] += lazy[n]; // 어차피 최솟값에 값을 더해도 최소임
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 + 1] += lazy[n];
            }
            lazy[n] = 0;
        }
    }

    void update(int s, int e, int n, int l, int r, int c) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            lazy[n] += c;
            lazyPropagation(s, e, n);
            return;
        }
        int mid = (s + e) / 2;
        update(s, mid, n * 2, l, r, c);
        update(mid + 1, e, n * 2 + 1, l, r, c);
        tree[n][0] = tree[n * 2][0] + tree[n * 2 + 1][0];
        tree[n][1] = Math.min(tree[n * 2][1], tree[n * 2 + 1][1]);
    }

    long min(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return Long.MAX_VALUE;
        if (l <= s && e <= r) return tree[n][1];
        int mid = (s + e) / 2;
        return Math.min(min(s, mid, n * 2, l, r), min(mid + 1, e, n * 2 + 1, l, r));
    }

    long sum(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n][0];
        int mid = (s + e) / 2;
        return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
    }
}