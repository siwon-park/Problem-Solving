// 에바쿰 (15967번)
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); // N, Q1, Q2
        int N = Integer.parseInt(st.nextToken()); // 맞은 날 수
        int Q1 = Integer.parseInt(st.nextToken()); // 2번 쿼리의 수
        int Q2 = Integer.parseInt(st.nextToken()); // 1번 쿼리의 수

        st = new StringTokenizer(br.readLine()); // 각 일자별 맞은 수치
        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N, arr);
        segmentTree.init(1, N, 1);

        int x, n, m, l; // 쿼리의 종류, n일, m일, 충격
        for (int i = 0; i < Q1 + Q2; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (x == 1) {
                bw.write(segmentTree.count(1, N, 1, n, m) + "\n");
            } else {
                l = Integer.parseInt(st.nextToken());
                segmentTree.update(1, N, 1, n, m, l);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {

    long[] tree;
    long[] lazy;
    int[] arr;

    SegmentTree(int n, int[] arr) {
        this.tree = new long[n * 4];
        this.lazy = new long[n * 4];
        this.arr = arr;
    }

    long init(int s, int e, int n) {
        if (s == e) return tree[n] = arr[s];
        int mid = (s + e) / 2;
        return tree[n] = init(s, mid, n * 2) + init(mid + 1, e, n * 2 + 1);
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {
            tree[n] += (e - s + 1) * lazy[n];
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 + 1] += lazy[n];
            }
            lazy[n] = 0;
        }
    }

    long update(int s, int e, int n, int l, int r, int w) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return tree[n];
        if (l <= s && e <= r) {
            lazy[n] += w;
            lazyPropagation(s, e, n);
            return tree[n];
        }
        int mid = (s + e) / 2;
        return tree[n] = update(s, mid, n * 2, l, r, w) + update(mid + 1, e, n * 2 + 1, l, r, w);
    }

    long count(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return count(s, mid, n * 2, l, r) + count(mid + 1, e, n * 2 + 1, l, r);
    }
}