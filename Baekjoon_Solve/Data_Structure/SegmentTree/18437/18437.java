// 회사 문화 5 (18437번)
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ord; // 직원 수, 쿼리 수, 방문 순서
    static int[] parent, subTree, preOrd; // 부모 배열, 서브 트리 상 마지막 노드 번호, 전위 순회 결과
    static ArrayList<ArrayList<Integer>> graph;

    /*
     * 전위 순회와 서브 트리 상 마지막 노드를 갱신하는 함수
     * */
    static int preOrder(int cur) {
        preOrd[cur] = ++ord;
        int size = graph.get(cur).size();
        int last = cur;
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
        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        preOrd = new int[N + 1];
        subTree = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int p = Integer.parseInt(st.nextToken());
            parent[i] = p;
            graph.get(p).add(i);
        }

        ord = 0;
        preOrder(1);

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(1, N, 1);

        M = Integer.parseInt(br.readLine());
        int x, a;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            if (x == 1) { // turn on
                segmentTree.update(1, N, 1, preOrd[a] + 1, preOrd[subTree[a]], 1); // 왼쪽 서브트리의 루트는 i + 1
            } else if (x == 2) { // turn off
                segmentTree.update(1, N, 1, preOrd[a] + 1, preOrd[subTree[a]], -1);
            } else if (x == 3) { // 사람 수 출력
                int ret = segmentTree.sum(1, N, 1, preOrd[a] + 1, preOrd[subTree[a]]);
                bw.write(ret + "\n");
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

    int init(int s, int e, int n) {
        if (s == e) return tree[n] = 1; // 제일 처음에 컴퓨터들은 켜져 있는 상태
        int mid = (s + e) / 2;
        return tree[n] = init(s, mid, n * 2) + init(mid + 1, e, n * 2 + 1);
    }

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {  // lazy가 1이면 켜고, lazy가 -1이면 끈다.
            tree[n] = (lazy[n] == 1) ? e - s + 1 : 0; // lazy가 1일 경우 구간의 개수를 계산.
            if (s != e) {
                lazy[n * 2] = lazy[n];
                lazy[n * 2 + 1] = lazy[n];
            }
            lazy[n] = 0;
        }
    }

    int update(int s, int e, int n, int l, int r, int w) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return tree[n];
        if (l <= s && e <= r) {
            lazy[n] = w;
            lazyPropagation(s, e, n);
            return tree[n];
        }
        int mid = (s + e) / 2;
        return tree[n] = update(s, mid, n * 2, l, r, w) + update(mid + 1, e, n * 2 + 1, l, r, w);
    }

    int sum(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
    }
}