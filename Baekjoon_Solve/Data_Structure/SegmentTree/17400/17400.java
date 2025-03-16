import java.io.*;
import java.util.*;

// 깃발춤 (17400번)
public class Main {

    static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        int[] odd = new int[N + 1];
        int[] even = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 1) odd[i] = Integer.parseInt(st.nextToken());
            else even[i] = Integer.parseInt(st.nextToken());
        }

        SegTree oddSegTree = new SegTree(N, odd);
        SegTree evenSegTree = new SegTree(N, even);
        oddSegTree.init(1, N, 1);
        evenSegTree.init(1, N, 1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if (op == 1) { // 1 L R: 구간 [L, R]의 균일도를 구한다.
                int r = Integer.parseInt(st.nextToken());
                long ans = Math.abs(oddSegTree.sum(1, N, 1, l, r) - evenSegTree.sum(1, N, 1, l, r));
                bw.write(ans + "\n");
            } else if (op == 2) { // 2 L X: 구간 [L, L]의 카리스마를 X만큼 증가시킨다.
                int x = Integer.parseInt(st.nextToken());
                if (l % 2 == 0) evenSegTree.update(1, N, 1, l, x);
                else oddSegTree.update(1, N, 1, l, x);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class SegTree {
    long[] tree;
    int[] arr;

    SegTree(int n, int[] arr) {
        this.arr = arr;
        tree = new long[n * 4];
    }

    void init(int s, int e, int n) {
        if (s == e) {
            tree[n] = arr[s];
            return;
        }
        int mid = (s + e) >> 1;
        init(s, mid, n * 2);
        init(mid + 1, e, n * 2 + 1);
        tree[n] = tree[n * 2] + tree[n * 2 + 1];
    }

    void update(int s, int e, int n, int idx, int x) {
        if (idx < s || e < idx) return;
        if (s == idx && idx == e) {
            tree[n] += x;
            return;
        }
        int mid = (s + e) >> 1;
        update(s, mid, n * 2, idx, x);
        update(mid + 1, e, n * 2 + 1, idx, x);
        tree[n] = tree[n * 2] + tree[n * 2 + 1];
    }

    long sum(int s, int e, int n, int l, int r) {
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) >> 1;
        return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
    }
}

