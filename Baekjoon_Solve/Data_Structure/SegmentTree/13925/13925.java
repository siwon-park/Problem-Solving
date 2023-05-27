// 수열과 쿼리 13 (13925번)
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N, arr);
        segmentTree.init(1, N, 1);

        int M = Integer.parseInt(br.readLine()); // 쿼리의 수
        int cmd, x, y, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (cmd == 4) {
              bw.write(segmentTree.sum(1, N, 1, x, y) + "\n");
            } else {
                v = Integer.parseInt(st.nextToken());
                segmentTree.update(1, N, 1, x, y, v, cmd);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    long[] tree;
    long[][] lazy; //
    int[] arr; // 초기 배열
    int MOD = 1_000_000_007;

    SegmentTree(int n, int[] arr) {
        this.tree = new long[n * 4];
        this.lazy = new long[2][n * 4];
        Arrays.fill(lazy[0], 1);
        this.arr = arr;
    }

    void init(int s, int e, int n) {
        if (s == e) {
            tree[n] = arr[s];
            return;
        }
        int mid = (s + e) / 2;
        init(s, mid, n * 2);
        init(mid + 1, e, n * 2 + 1);
        tree[n] = (tree[n * 2] + tree[n * 2 + 1]) % MOD;
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[0][n] != 0 || lazy[1][n] != 0) {
            tree[n] = ((e - s + 1) * lazy[1][n] + lazy[0][n] * tree[n]) % MOD;
            if (s != e) {
                lazy[0][n * 2] = (lazy[0][n * 2] * lazy[0][n]) % MOD;
                lazy[0][n * 2 + 1] = (lazy[0][n * 2 + 1] * lazy[0][n]) % MOD;
                lazy[1][n * 2] = (lazy[1][n * 2] * lazy[0][n] + lazy[1][n]) % MOD;
                lazy[1][n * 2 + 1] = (lazy[1][n * 2 + 1] * lazy[0][n] + lazy[1][n]) % MOD;
            }
            lazy[0][n] = 1;
            lazy[1][n] = 0;
        }
    }

    void update(int s, int e, int n, int l, int r, int w, int q) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            if (q == 1) {
                lazy[0][n] *= 1;
                lazy[1][n] = (lazy[1][n] + w) % MOD;
            } else if (q == 2) {
                lazy[0][n] = (lazy[0][n] * w) % MOD;
                lazy[1][n] = (lazy[1][n] * w) % MOD;
            } else {
                lazy[0][n] = 0;
                lazy[1][n] = w;
            }
            lazyPropagation(s, e, n);
            return;
        }
        int mid = (s + e) / 2;
        update(s, mid, n * 2, l, r, w, q);
        update(mid + 1, e, n * 2 + 1, l, r, w, q);
        tree[n] = (tree[n * 2] + tree[n * 2 + 1]) % MOD;
    }

    long sum(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n] % MOD;
        int mid = (s + e) / 2;
        return (sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r)) % MOD;
    }

}