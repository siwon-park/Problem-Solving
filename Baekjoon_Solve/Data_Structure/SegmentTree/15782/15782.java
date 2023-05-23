// Calculate! 2 (15782번)
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int preOrder(int cur) {
        preOrd[cur] = ++ord;
        int last = cur;
        int size = graph.get(cur).size();
        for (int i = 0; i < size; i++) {
            int nxt = graph.get(cur).get(i);
            if (preOrd[nxt] == 0) last = preOrder(nxt);
        }
        subTree[cur] = last;
        return subTree[cur];
    }

    static int N, M, ord; // 정점의 수, 쿼리의 수, 방문 순서
    static int[] D; // 초기 배열
    static int[] parent, preOrd, subTree; // 부모 배열, 전위 순회 순서, 서브 트리 상 마지막 노드 번호
    static ArrayList<ArrayList<Integer>> graph; // 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = new int[N + 1];
        parent = new int[N + 1];
        preOrd = new int[N + 1];
        subTree = new int[N + 1];

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        int a, b;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ord = 0;
        preOrder(1);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) D[i] = Integer.parseInt(st.nextToken());

        // 전위 순회 순서에 맞게 D배열을 재배치
        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) arr[preOrd[i]] = D[i];

        SegmentTree segmentTree = new SegmentTree(N, arr);
        segmentTree.init(1, N, 1);

        int op, x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            op = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            if (op == 1) { // XOR 연산
                bw.write(segmentTree.xor(1, N, 1, preOrd[x], preOrd[subTree[x]]) + "\n");
            } else { // update
                y = Integer.parseInt(st.nextToken());
                segmentTree.update(1, N, 1, preOrd[x], preOrd[subTree[x]], y);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}


class SegmentTree {
    int[] tree;
    int[] lazy;
    int[] arr;

    SegmentTree(int n, int[] arr) {
        this.tree = new int[n * 4];
        this.lazy = new int[n * 4];
        this.arr = arr;
    }

    int init(int s, int e, int n) {
        if (s == e) return tree[n] = arr[s];
        int mid = (s + e) / 2;
        return tree[n] = init(s, mid, n * 2) ^ init(mid + 1, e, n * 2 + 1);
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {
            if ((e - s + 1) % 2 != 0) tree[n] ^= lazy[n];
            if (s != e) {
                lazy[n * 2] ^= lazy[n];
                lazy[n * 2 + 1] ^= lazy[n];
            }
            lazy[n] = 0;
        }
    }

    int update(int s, int e, int n, int l, int r, int w) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return tree[n];
        if (l <= s && e <= r) {
            lazy[n] ^= w;
            lazyPropagation(s, e, n);
            return tree[n];
        }
        int mid = (s + e) / 2;
        return tree[n] = update(s, mid, n * 2, l, r, w) ^ update(mid + 1, e, n * 2 + 1, l, r, w);
    }

    int xor(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0; // tree[n] ^ 0 = tree[n]
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return xor(s, mid, n * 2, l, r) ^ xor(mid + 1, e, n * 2 + 1, l, r);
    }
}