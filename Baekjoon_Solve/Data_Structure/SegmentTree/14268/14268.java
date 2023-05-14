// 회사 문화 2 (14268번)
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    /*
    * 전위 순회 방문 순서와 서브 트리상 마지막 노드 번호를 기록하는 함수
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

    static int n, m, ord; // 회사 직원 수, 쿼리의 수, 전위순회 방문 순서
    static int[] parent, preOrd, subTree; // 부모 배열, 전위순회 결과, 서브 트리 상 마지막 노드 번호
    static ArrayList<ArrayList<Integer>> graph; // 트리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        parent = new int[n + 1];
        preOrd = new int[n + 1];
        subTree = new int[n + 1];
        int p;
        for (int i = 1; i < n + 1; i++) {
            p = Integer.parseInt(st.nextToken());
            if (p == -1) p = 0; // -1일 경우 0
            graph.get(p).add(i);
            parent[i] = p;
            subTree[i] = i;
        }

        ord = 0;
        preOrder(1);

        SegmentTree segmentTree = new SegmentTree(n);

        int x, i, w;
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            if (x == 1) {
                i = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                segmentTree.update(1, n, 1, preOrd[i], preOrd[subTree[i]], w);
            } else if (x == 2) {
                i = Integer.parseInt(st.nextToken());
                bw.write(segmentTree.sum(1, n, 1, preOrd[i], preOrd[i]) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}


class SegmentTree {
    int[] tree;
    int[] lazy;

    SegmentTree(int n) {
        this.tree = new int[n * 4];
        this.lazy = new int[n * 4];
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

    void update(int s, int e, int n, int l, int r, int w) { // 업데이트 한 다음 어떠한 연산도 하지 말아야 함 -> 업데이트만 함
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

    int sum(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
    }

}