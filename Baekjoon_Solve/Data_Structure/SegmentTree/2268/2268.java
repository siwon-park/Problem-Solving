import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N); // 처음에 A[1] = A[2] = ... = A[N] = 0

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (x == 0) { // sum 함수 수행
                // a > b인 경우에 대해 a < b로 변화
                int l = Math.min(a, b);
                int r = Math.max(a, b);
                long ret = segmentTree.sum(1, N, 1, l, r);
                bw.write(ret + "\n");
            } else if (x == 1) { // modify 함수 수행
                segmentTree.update(1, N, 1, a, b);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

class SegmentTree {
    long[] tree;

    SegmentTree(int n) {
        this.tree = new long[n * 4];
    }

    long sum(int s, int e, int n, int l, int r) {
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
    }

    long update(int s, int e, int n, int idx, int val) {
        if (idx < s || e < idx) return tree[n];
        if (idx == s && idx == e) {
            tree[n] = val;
            return tree[n];
        }
        int mid = (s + e) / 2;
        tree[n] = update(s, mid, n * 2, idx, val) + update(mid + 1, e, n * 2 + 1, idx, val);
        return tree[n];
    }
}