// 수열과 쿼리 16 (14428번)

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), i);
        }

        SegmentTree segmentTree = new SegmentTree(N, arr);
        segmentTree.init(1, N, 1);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (x == 1) {
                segmentTree.update(1, N, 1, a, b);
            } else if (x == 2) {
                int ret = segmentTree.findMinIdxPair(1, N, 1, a, b).idx;
                bw.write(ret + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    Pair[] arr;
    Pair[] tree;
    int MAX = Integer.MAX_VALUE;

    SegmentTree(int N, Pair[] arr) {
        this.tree = new Pair[N * 4];
        this.arr = arr;
    }

    Pair minIdxPair(Pair o1, Pair o2) {
        int minIdx = MAX;
        int minVal = MAX;
        if (o1.val <= o2.val) {
            minVal = o1.val;
            minIdx = o1.idx;
        } else {
            minVal = o2.val;
            minIdx = o2.idx;
        }
        return new Pair(minVal, minIdx);
    }

    Pair init(int s, int e, int n) {
        if (s == e) {
            tree[n] = arr[s];
            return tree[n];
        }
        int mid = (s + e) / 2;
        Pair o1 = init(s, mid, n * 2);
        Pair o2 = init(mid + 1, e, n * 2 + 1);
        return tree[n] = minIdxPair(o1, o2);
    }

    Pair update(int s, int e, int n, int idx, int val) {
        if (idx < s || e < idx) {
            return tree[n];
        }
        if (idx == s && e == idx) {
            tree[n].val = val;
            return tree[n];
        }
        int mid = (s + e) / 2;
        Pair o1 = update(s, mid, n * 2, idx, val);
        Pair o2 = update(mid + 1, e, n * 2 + 1, idx, val);
        return tree[n] = minIdxPair(o1, o2);
    }

    Pair findMinIdxPair(int s, int e, int n, int l, int r) {
        if (r < s || e < l) return new Pair(MAX, MAX);
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        Pair o1 = findMinIdxPair(s, mid, n * 2, l, r);
        Pair o2 = findMinIdxPair(mid + 1, e, n * 2 + 1, l, r);
        return minIdxPair(o1, o2);
    }

}

class Pair {
    int val;
    int idx;
    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
