import java.io.*;
import java.util.*;

// 수열과 쿼리 26 (17474번)
public class Main {

    static int[] arr;

    static class SegmentTree {
        Node[] tree;

        SegmentTree(int n) {
            this.tree = new Node[n * 4];
            for (int i = 0; i < n * 4; i++) {
                tree[i] = new Node(-1, -1, 0L, 0);
            }
        }

        void updateNode(Node parent, Node left, Node right) {
            if (left.max1 == right.max1) {
                parent.max1 = left.max1;
                parent.max2 = Math.max(left.max2, right.max2);
                parent.maxCnt = left.maxCnt + right.maxCnt;
                parent.sum = left.sum + right.sum;
            } else if (left.max1 > right.max1) {
                parent.max1 = left.max1;
                parent.max2 = Math.max(left.max2, right.max1);
                parent.maxCnt = left.maxCnt;
                parent.sum = left.sum + right.sum;
            } else {
                parent.max1 = right.max1;
                parent.max2 = Math.max(left.max1, right.max2);
                parent.maxCnt = right.maxCnt;
                parent.sum = left.sum + right.sum;
            }
        }

        void lazyProp (int s, int e, int n) {
            if (s != e) {
                if (tree[n].max1 < tree[n * 2].max1) {
                    tree[n * 2].sum -= (long) tree[n * 2].maxCnt * (tree[n * 2].max1 - tree[n].max1);
                    tree[n * 2].max1 = tree[n].max1;
                }
                if (tree[n].max1 < tree[n * 2 + 1].max1) {
                    tree[n * 2 + 1].sum -= (long) tree[n * 2 + 1].maxCnt * (tree[n * 2 + 1].max1 - tree[n].max1);
                    tree[n * 2 + 1].max1 = tree[n].max1;
                }
            }
        }

        void init(int s, int e, int n) {
            if (s == e) {
                tree[n].max1 = arr[s];
                tree[n].max2 = -1;
                tree[n].sum = arr[s];
                tree[n].maxCnt = 1;
                return;
            }
            int mid = (s + e) >> 1;
            init(s, mid, n * 2);
            init(mid + 1, e, n * 2 + 1);
            updateNode(tree[n], tree[n * 2], tree[n * 2 + 1]);
        }

        void update(int s, int e, int n, int l, int r, int x) {
            if (r < s || e < l || tree[n].max1 <= x) return;
            lazyProp(s, e, n);
            if (l <= s && e <= r && tree[n].max2 < x) {
                tree[n].sum -= (long) tree[n].maxCnt * (tree[n].max1 - x);
                tree[n].max1 = x;
                lazyProp(s, e, n);
                return;
            }
            int mid = (s + e) >> 1;
            update(s, mid, n * 2, l, r, x);
            update(mid + 1, e, n * 2 + 1, l, r, x);
            updateNode(tree[n], tree[n * 2], tree[n * 2 + 1]);
        }

        int getMax(int s, int e, int n, int l, int r) {
            lazyProp(s, e, n);
            if (r < s || e < l) return -1;
            if (l <= s && e <= r) return tree[n].max1;
            int mid = (s + e) >> 1;
            return Math.max(getMax(s, mid, n * 2, l, r), getMax(mid + 1, e, n * 2 + 1, l, r));
        }

        long getSum(int s, int e, int n, int l, int r) {
            lazyProp(s, e, n);
            if (r < s || e < l) return 0L;
            if (l <= s && e <= r) return tree[n].sum;
            int mid = (s + e) >> 1;
            return getSum(s, mid, n * 2, l, r) + getSum(mid + 1, e, n * 2 + 1, l, r);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        SegmentTree segTree = new SegmentTree(N);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        segTree.init(1, N, 1);
        int M = Integer.parseInt(br.readLine()); // 쿼리의 수
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int x = Integer.parseInt(st.nextToken());
                segTree.update(1, N, 1, l, r, x);
            } else if (q == 2) {
                int max = segTree.getMax(1, N, 1, l, r);
                sb.append(max).append("\n");
            } else if (q == 3) {
                long sum = segTree.getSum(1, N, 1, l, r);
                sb.append(sum).append("\n");
            }
        }

        System.out.println(sb);
        bw.close();
        br.close();
    }
}


class Node {
    int max1, max2, maxCnt; // 현재 구간의 max 값, 차기 max값
    long sum;

    Node() {
    }

    Node(int max1, int max2, long sum, int maxCnt) {
        this.max1 = max1;
        this.max2 = max2;
        this.sum = sum;
        this.maxCnt = maxCnt;
    }
}

