// 자동차 공장 (2820번)
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ord; // 직원 수, 쿼리 수, 방문 번호
    static int[] parent, subTree, arr, preOrd; // 부모 배열, 서브 트리 상 마지막 노드, 월급 배열, 전위 순회 결과
    static ArrayList<ArrayList<Integer>> graph; // 그래프

    /*
     * 전위 순회 결과와 서브 트리 상의 마지막 노드를 갱신하는 함수
     * */
    static int preOrder(int cur) {
        preOrd[cur] = ++ord;
        int last = cur;
        int size = graph.get(cur).size();
        for (int i = 0; i < size; i++) {
            int nxt = graph.get(cur).get(i);
            last = preOrder(nxt);
        }
        subTree[cur] = last;
        return subTree[cur];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        parent = new int[N + 1];
        subTree = new int[N + 1];
        preOrd = new int[N + 1];

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        arr[1] = Integer.parseInt(br.readLine()); // 상근이
        for (int i = 2; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken()); // 직원의 월급
            int p = Integer.parseInt(st.nextToken()); // 상사
            parent[i] = p;
            graph.get(p).add(i); // p의 자식이 i
        }

        ord = 0;
        preOrder(1);
        int[] pay = new int[N + 1]; // 전위 순회 순서에 해당하는 월급 배열의 인덱스 위치의 값이 다를 수 있기 때문에
        for (int i = 1; i < N + 1; i++) pay[preOrd[i]] = arr[i]; // 전위 순회 순서에 맞게 월급 배열을 조정

        SegmentTree segmentTree = new SegmentTree(N, pay);
        segmentTree.init(1, N, 1);

        String op;
        int a, x;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            op = st.nextToken();
            if (op.equals("p")) { // p인 경우
                a = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                segmentTree.update(1, N, 1, preOrd[a] + 1, preOrd[subTree[a]], x); // a의 부하 = preOrd[a] + 1
            } else { // u인 경우
                a = Integer.parseInt(st.nextToken());
                long ret = segmentTree.count(1, N, 1, preOrd[a], preOrd[a]);
                bw.write(ret + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {

    long[] tree;
    long[] lazy;
    int[] pay;

    SegmentTree(int n, int[] pay) {
        this.tree = new long[n * 4];
        this.lazy = new long[n * 4];
        this.pay = pay;
    }

    void init(int s, int e, int n) {
        if (s == e) {
            tree[n] = pay[s];
            return;
        }
        int mid = (s + e) / 2;
        init(s, mid, n * 2);
        init(mid + 1, e, n * 2 + 1);
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {
            tree[n] += lazy[n];
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 + 1] += lazy[n];
            }
            lazy[n] = 0;
        }
    }

    void update(int s, int e, int n, int l, int r, int w) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            lazy[n] += w;
            lazyPropagation(s, e, n);
            return;
        }
        int mid = (s + e) / 2;
        update(s, mid, n * 2, l, r, w);
        update(mid + 1, e, n * 2 + 1, l, r, w);
    }

    long count(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return count(s, mid, n * 2, l, r) + count(mid + 1, e, n * 2 + 1, l, r);
    }

}