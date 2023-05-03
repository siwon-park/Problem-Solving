// XOR (12844번)
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N, arr);
        segmentTree.init(0, N - 1, 1);

        int M = Integer.parseInt(br.readLine());
        int x, a, b, k;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); // 쿼리의 종류
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int l = Math.min(a, b);
            int r = Math.max(a, b);
            if (x == 1) {
                k = Integer.parseInt(st.nextToken());
                segmentTree.update(0, N - 1, 1, l, r, k);
            } else if (x == 2) {
                int ret = segmentTree.xor(0, N - 1, 1, l, r);
                bw.write(ret + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    int[] arr;
    int[] tree;
    int[] lazy;

    SegmentTree(int N, int[] arr) {
        this.tree = new int[N * 4];
        this.lazy = new int[N * 4];
        this.arr = arr;
    }

    int init(int s, int e, int n) {
        if (s == e) return tree[n] = arr[s];
        int mid = (s + e) / 2;
        return tree[n] = init(s, mid, n * 2) ^ init(mid + 1, e, n * 2 + 1);
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {
            if ((e - s + 1) % 2 == 1) {
                tree[n] ^= lazy[n];
            }
            if (s != e) {
                lazy[n * 2] ^= lazy[n];
                lazy[n * 2 + 1] ^= lazy[n];
            }
            lazy[n] = 0;
        }
    }

    int update(int s, int e, int n, int l, int r, int k) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return tree[n];
        if (l <= s && e <= r) {
            lazy[n] ^= k;
            lazyPropagation(s, e, n);
            return tree[n];
        }
        int mid = (s + e) / 2;
        return tree[n] = update(s, mid, n * 2, l, r, k) ^ update(mid + 1, e, n * 2 + 1, l, r, k);
    }

    int xor(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0; // tree[n] ^ 0 = tree[n]
        if (l <= s && e <= r) {
            return tree[n];
        }
        int mid = (s + e) / 2;
        return xor(s, mid, n * 2, l, r) ^ xor(mid + 1, e, n * 2 + 1, l, r);
    }
}