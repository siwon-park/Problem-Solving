import java.io.*;
import java.util.*;

// 벽 (10070번)
public class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N);
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            segmentTree.update(op,1, N, 1, left + 1, right + 1, height);
        }

        segmentTree.flush(1, N, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(segmentTree.arr[i]);
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();

    }
}

class SegmentTree {
    int MAX = Integer.MAX_VALUE;
    int[][] lazy;
    int[] arr;

    SegmentTree(int n) {
        this.lazy = new int[n * 4][2]; // lower, upper
        this.arr = new int[n + 1];
    }

    void lazyPropagation(int op, int n, int v) {
        if (op == 1) {
            lazy[n * 2][0] = Math.max(lazy[n * 2][0], v);
            lazy[n * 2][1] = Math.max(lazy[n * 2][1], v);
            lazy[n * 2 + 1][0] = Math.max(lazy[n * 2 + 1][0], v);
            lazy[n * 2 + 1][1] = Math.max(lazy[n * 2 + 1][1], v);
        } else {
            lazy[n * 2][0] = Math.min(lazy[n * 2][0], v);
            lazy[n * 2][1] = Math.min(lazy[n * 2][1], v);
            lazy[n * 2 + 1][0] = Math.min(lazy[n * 2 + 1][0], v);
            lazy[n * 2 + 1][1] = Math.min(lazy[n * 2 + 1][1], v);
        }
    }

    void update(int op, int s, int e, int n, int l, int r, int h) {
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            if (op == 1) {
                lazy[n][0] = Math.max(lazy[n][0], h);
                lazy[n][1] = Math.max(lazy[n][1], h);
            } else {
                lazy[n][0] = Math.min(lazy[n][0], h);
                lazy[n][1] = Math.min(lazy[n][1], h);
            }
            return;
        }
        int mid = (s + e) >> 1;
        lazyPropagation(1, n, lazy[n][0]);
        lazyPropagation(2, n, lazy[n][1]);
        lazy[n][0] = 0;
        lazy[n][1] = MAX;
        update(op, s, mid, n * 2, l, r, h);
        update(op, mid + 1, e, n * 2 + 1, l, r, h);
    }
    

    void flush(int s, int e, int n) {
        if (s == e) {
            arr[s] = lazy[n][0];
            return;
        }
        lazyPropagation(1, n, lazy[n][0]);
        lazyPropagation(2, n, lazy[n][1]);
        lazy[n][0] = 0;
        lazy[n][1] = MAX;
        int mid = (s + e) >> 1;
        flush(s, mid, n * 2);
        flush(mid + 1, e, n * 2 + 1);
    }

}
