import java.io.*;
import java.util.*;

// 미술 시간 (29618번)
public class Main {

    static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        LazyPropagation lazyPropagation = new LazyPropagation(N);
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            lazyPropagation.update(1, N, 1, a, b, x);
        }

        lazyPropagation.result(1, N, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(lazyPropagation.arr[i]);
            sb.append(" ");
        }
        sb.append(lazyPropagation.arr[N]);

        System.out.println(sb.toString());
    }
}

class LazyPropagation {
    int[] arr;
    int[] tree;
    int[] lazy;

    LazyPropagation(int n) {
        this.arr = new int[n + 1];
        this.tree = new int[n * 4];
        this.lazy = new int[n * 4];
    }

    void prop(int s, int e, int n) {
        if (lazy[n] != 0) {
            if (tree[n] == 0) tree[n] = lazy[n];
            if (s != e) { // 자식 lazy의 값이 0이 아닐 때만 전파
                if (lazy[n * 2] == 0) lazy[n * 2] = lazy[n];
                if (lazy[n * 2 + 1] == 0) lazy[n * 2 + 1] = lazy[n];
            }
            // 구간에 색칠을 이미 했으면 전파하면 안되기 때문에 lazy 초기화 X
        }
    }

    void result(int s, int e, int n) {
        prop(s, e, n);
        if (s == e) {
            arr[s] = tree[n]; // 전파된 값을 업데이트
            return;
        }
        int mid = (s + e) >> 1;
        result(s, mid, n * 2);
        result(mid + 1, e, n * 2 + 1);
    }

    void update(int s, int e, int n, int l, int r, int x) {
        prop(s, e, n);
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            if (lazy[n] == 0) { // 색칠한 구간이 아니면 전파
                lazy[n] = x;
                prop(s, e, n);
            }
            return;
        }
        int mid = (s + e) >> 1;
        update(s, mid, n * 2, l, r, x);
        update(mid + 1, e, n * 2 + 1, l, r, x);
        return;
    }

}
