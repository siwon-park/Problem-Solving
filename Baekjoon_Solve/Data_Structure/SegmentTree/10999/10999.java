// 구간 합 구하기 2 (10999번)
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 업데이트 쿼리의 수
        int K = Integer.parseInt(st.nextToken()); // 구간 합을 구하는 쿼리의 수

        long[] arr = new long[N + 1];
        for (int i = 1; i < N + 1; i++) arr[i] = Long.parseLong(br.readLine());

        SegmentTree segmentTree = new SegmentTree(N, arr);
        segmentTree.init(1, N, 1);

        int a, b, c;
        long d;
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            if (a == 1) { // 구간을 업데이트
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Long.parseLong(st.nextToken());
                segmentTree.update(1, N, 1, b, c, d);
            } else if (a == 2) { // 구간의 합을 반환
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                long ret = segmentTree.sum(1, N, 1, b, c);
                bw.write(ret + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {

    long[] arr;
    long[] tree;
    long[] lazy;

    SegmentTree(int n, long[] arr) {
        this.arr = arr;
        this.tree = new long[n * 4];
        this.lazy = new long[n * 4];
    }

    // 구간 합 세그먼트 트리를 초기화
    void init(int s, int e, int n) {
        if (s == e) {
            tree[n] = arr[s];
            return;
        }
        int mid = (s + e) / 2;
        init(s, mid, n * 2);
        init(mid + 1, e, n * 2 + 1);
        tree[n] = tree[n * 2] + tree[n * 2 + 1];
    }

    // propagation
    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) { // 구간에 전파해야할 일이 있으면 전파
            tree[n] += (e - s + 1) * lazy[n];
            if (s != e) { // 루트 노드가 아니면 자식에게 lazy를 전파
                lazy[n * 2] += lazy[n];
                lazy[n * 2 + 1] += lazy[n];
            }
            lazy[n] = 0; // 현재 구간의 lazy 배열 값을 0으로 함
        }
    }

    // 구간에 일정 값을 일괄 업데이트
    void update(int s, int e, int n, int l, int r, long val) {
        lazyPropagation(s, e, n); // 현재 구간의 lazy를 전파
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            lazy[n] += val;
            lazyPropagation(s, e, n);
            return;
        }
        int mid = (s + e) / 2;
        update(s, mid, n * 2, l, r, val);
        update(mid + 1, e, n * 2 + 1, l, r, val);
        tree[n] = tree[n * 2] + tree[n * 2 + 1];
    }

    // 구간 합을 계산
    long sum(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
    }
}