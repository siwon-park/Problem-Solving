// Hotel Rooms (32322번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        SegmentTree segTree = new SegmentTree(N);
        segTree.init(1, N, 1);
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            if ("A".equals(type)) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long ans = segTree.sum(1, N, 1, l, r);
                bw.write(ans + "\n");
            } else {
                int idx = Integer.parseInt(st.nextToken());
                segTree.update(1, N, 1, idx);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static class SegmentTree {

        long[] tree;
        int size;

        public SegmentTree(int n) {
            this.size = n;
            this.tree = new long[n * 4];
        }

        public void init(int s, int e, int n) {
            if (s == e) {
                tree[n] = 1;
                return;
            }
            int mid = (s + e) >> 1;
            init(s, mid, n * 2);
            init(mid + 1, e, n * 2 + 1);
            tree[n] = tree[n * 2] + tree[n * 2 + 1];
        }

        public void update(int s, int e, int n, int idx) {
            if (idx < s || e < idx) return;
            if (idx <= s && e <= idx) {
                tree[n] -= 1; // idx번째 방을 예약함
                return;
            }
            int mid = (s + e) >> 1;
            update(s, mid, n * 2, idx);
            update(mid + 1, e, n * 2 + 1, idx);
            tree[n] = tree[n * 2] + tree[n * 2 + 1];
        }

        public long sum(int s, int e, int n, int l, int r) {
            if (r < s || e < l) return 0;
            if (l <= s && e <= r) return tree[n];
            int mid = (s + e) >> 1;
            return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
        }
    }
}

