// 수열과 쿼리 21 (16975번)
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N, arr);
        segmentTree.init(1, N, 1);

        int M = Integer.parseInt(br.readLine()); // 쿼리의 개수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken()); // 쿼리의 종류
            if (q == 1) { // 1번 쿼리 -> 구간을 업데이트
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                segmentTree.update(1, N, 1, l, r, k);
            } else if (q == 2) { // 2번 쿼리 -> 인덱스의 값을 출력
                int x = Integer.parseInt(st.nextToken());
                long ret = segmentTree.sum(1, N, 1, x, x);
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
    long[] tree;
    long[] lazy;

    SegmentTree(int n, int[] arr) {
        this.tree = new long[n * 4];
        this.lazy = new long[n * 4];
        this.arr = arr;
    }

    long init(int s, int e, int n) {
        if (s == e) return tree[n] = arr[s];
        int mid = (s + e) / 2;
        return tree[n] = init(s, mid, n * 2) + init(mid + 1, e, n * 2 + 1);
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) { // 구간의 lazy 배열에 값이 남아있으면 처리
            tree[n] += (e - s + 1) * lazy[n];
            if (s != e) { // 리프 노드가 아니면 자식에게 lazy 배열의 값을 전파
                lazy[n * 2] += lazy[n];
                lazy[n * 2 + 1] += lazy[n];
            }
            lazy[n] = 0; // 현재 구간의 lazy 배열의 값을 0으로 처리
        }
    }

    long update(int s, int e, int n, int l, int r, int val) {
        lazyPropagation(s, e, n); // 업데이트 하기 전에 현재 구간의 lazy 배열을 확인하고 전파
        if (r < s || e < l) return tree[n];
        if (l <= s && e <= r) {
            lazy[n] += val; // 현재 구간의 lazy 배열의 값에 val을 누적
            lazyPropagation(s, e, n); // lazy propagation
            return tree[n];
        }
        int mid = (s + e) / 2;
        return tree[n] = update(s, mid, n * 2, l, r, val) + update(mid + 1, e, n * 2 + 1, l, r, val);
    }

    long sum(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n); // 구간 합을 구하기 전에 현재 구간의 lazy 배열을 확인하고 전파
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
    }
}