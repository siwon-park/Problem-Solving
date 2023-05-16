// 회사 문화 3 (14287번)
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    /*
     * 전위 순회와 서브 트리 상 마지막 노드를 갱신하는 함수
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

    static int n, m, ord; // 직원 수, 쿼리 수, 방문 순서
    static int[] parent, preOrd, subTree; // 부모 배열, 전위 순회 결과, 서브 트리 상 마지막 노드 번호
    static ArrayList<ArrayList<Integer>> graph; // 트리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        preOrd = new int[n + 1];
        subTree = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) p = 0;
            parent[i] = p;
            graph.get(p).add(i);
        }

        ord = 0;
        preOrder(1);

        SegmentTree segmentTree = new SegmentTree(n);

        int x, a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            if (x == 1) { // update
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                // a번째 직원이 부하로부터 b만큼 칭찬을 받음
                segmentTree.update(1, n, 1, preOrd[a], preOrd[a], b);
            } else if (x == 2) { // count
                a = Integer.parseInt(st.nextToken());
                int ret = segmentTree.count(1, n, 1, preOrd[a], preOrd[subTree[a]]);
                bw.write(ret + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

// 구간 합을 저장한 세그먼트 트리
class SegmentTree {

    int[] tree;
    int[] lazy;

    SegmentTree(int n) {
        this.tree = new int[n * 4];
        this.lazy = new int[n * 4];
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {
            tree[n] += lazy[n] * (e - s + 1);
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 + 1] += lazy[n];
            }
            lazy[n] = 0;
        }
    }

    int update(int s, int e, int n, int l, int r, int w) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return tree[n];
        if (l <= s && e <= r) {
            lazy[n] += w;
            lazyPropagation(s, e, n);
            return tree[n];
        }
        int mid = (s + e) / 2;
        return tree[n] = update(s, mid, n * 2, l, r, w) + update(mid + 1, e, n * 2 + 1, l, r, w);
    }

    int count(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return count(s, mid, n * 2, l, r) + count(mid + 1, e, n * 2 + 1, l, r);
    }
}