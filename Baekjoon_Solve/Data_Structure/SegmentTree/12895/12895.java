// 화려한 마을 (12895번)
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 수
        int T = Integer.parseInt(st.nextToken()); // 사용할 색의 개수
        int Q = Integer.parseInt(st.nextToken()); // 쿼리의 수

        int MAX_T = (1 << (T - 1));
        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(1, N, 1);

        String cmd;
        int x, y, z, a, b;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            y = Math.max(a, b);
            x = Math.min(a, b);
            if (cmd.equals("C")) {
                z = Integer.parseInt(st.nextToken());
                segmentTree.update(1, N, 1, x, y, z);
            } else {
                int ret = segmentTree.count(1, N, 1, x, y);
                // ret에 1이 몇개 있는지 확인
                int ans = 0;
                while (ret > 0) {
                    ans += ret & 1;
                    ret >>= 1;
                }
                bw.write(ans + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    int[] tree;
    int[] lazy;

    SegmentTree(int n) {
        this.tree = new int[n * 4];
        this.lazy = new int[n * 4];
    }

    void init(int s, int e, int n) {
        if (s == e) {
            tree[n] = 1;
            return;
        }
        int mid = (s + e) / 2;
        init(s, mid, n * 2);
        init(mid + 1, e, n * 2 + 1);
        tree[n] = tree[n * 2] | tree[n * 2 + 1];
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {
            tree[n] = lazy[n];
            if (s != e) {
                lazy[n * 2] = lazy[n];
                lazy[n * 2 + 1] = lazy[n];
            }
            lazy[n] = 0;
        }
    }

    void update(int s, int e, int n, int l, int r, int z) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            lazy[n] = (1 << (z - 1));
            lazyPropagation(s, e, n);
            return;
        }
        int mid = (s + e) / 2;
        update(s, mid, n * 2, l, r, z);
        update(mid + 1, e, n * 2 + 1, l, r, z);
        tree[n] = tree[n * 2] | tree[n * 2 + 1];
    }

    int count(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return count(s, mid, n * 2, l, r) | count(mid + 1, e, n * 2 + 1, l, r);
    }
}