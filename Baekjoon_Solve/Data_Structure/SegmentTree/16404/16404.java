// 주식회사 승범이네 (16404번)
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {
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

        int remain(int s, int e, int n, int l, int r) {
            lazyPropagation(s, e, n);
            if (r < s || e < l) return 0;
            if (l <= s && e <= r) {
                return tree[n];
            }
            int mid = (s + e) / 2;
            return remain(s, mid, n * 2, l, r) + remain(mid + 1, e, n * 2 + 1, l, r);
        }

    }

    static int N, M, num; // 판매원들의 수, 명령의 수, 방문 번호
    static int[] parent, preOrder, subtree; // 전위 순회 결과, 사수-부사수 관계, 본인을 루트로하는 서브트리에서 가장 끝 노드의 번호
    static ArrayList<ArrayList<Integer>> graph; // 연결 관계

    static int setPreOrder(int cur) {
        preOrder[cur] = ++num; // 방문 순서를 기록
        if (graph.get(cur).size() == 0) {
            subtree[cur] = num;
            return num;
        }
        int end = 0;
        for (int i = 0; i < graph.get(cur).size(); i++) {
            int nxt = graph.get(cur).get(i);
            end = setPreOrder(nxt);
        }
        subtree[cur] = end;
        return subtree[cur];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        preOrder = new int[N + 1];
        subtree = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) parent[i] = 0;
            graph.get(parent[i]).add(i);
        }
        num = 0;
        setPreOrder(1);

        SegmentTree segmentTree = new SegmentTree(N);

        int x, num, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());
            if (x == 1) {
                w = Integer.parseInt(st.nextToken());
                segmentTree.update(1, N, 1, preOrder[num], subtree[num], w);
            } else if (x == 2) {
                int ret = segmentTree.remain(1, N, 1, preOrder[num], preOrder[num]);
                bw.write(ret + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}