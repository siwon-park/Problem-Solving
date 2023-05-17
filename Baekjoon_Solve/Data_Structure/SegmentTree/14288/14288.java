// 회사 문화 4 (14288번)
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    /*
    * 전위 순회와 서브트리 상의 마지막 노드를 갱신하는 함수
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
    static int[] parent, preOrd, subTree; // 부모 배열, 전위 순회 순서, 서브 트리상 마지막 노드 번호
    static ArrayList<ArrayList<Integer>> graph; // 그래프

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
            parent[i] = p; // i의 부모는 p
            graph.get(p).add(i); // p의 자식은 i
        }

        ord = 0;
        preOrder(1);
        boolean flag = true; // true: 상사 -> 부하 (정방향) / false: 부하 -> 상사 (역방향)

        SegmentTree segmentTree = new SegmentTree(n);
        int x, i, w;
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            if (x == 1) { // 칭찬 전달
                i = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                if (flag) { // 정방향
                    if (preOrd[i] == 1) continue; // 1번 노드는 정방향에서 칭찬을 못받음
                    segmentTree.update(1, n, 1, preOrd[i], preOrd[subTree[i]], w, 1);
                } else { // 역방향
                    if (i == subTree[i]) continue; // 리프 노드일 경우 역방향에서 칭찬을 못받음
                    segmentTree.update(1, n, 1, preOrd[i], preOrd[i], w, 0);
                }
            } else if (x == 2) { // 칭찬 출력
                i = Integer.parseInt(st.nextToken());
                int ret1 = segmentTree.count(1, n, 1, preOrd[i], preOrd[i], 1);
                int ret2 = segmentTree.count(1, n, 1, preOrd[i], preOrd[subTree[i]], 0);
                bw.write(ret1 + ret2 + "\n");
            } else if (x == 3) { // 칭찬 방향 전환
                flag = !flag;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    int[] tree1; // 구간 합 세그먼트 트리
    int[] tree2; // 구간 값 세그먼트 트리
    int[] lazy1;
    int[] lazy2;
    SegmentTree(int n) {
        this.tree1 = new int[n * 4];
        this.tree2 = new int[n * 4];
        this.lazy1 = new int[n * 4];
        this.lazy2 = new int[n * 4];
    }

    void lazyPropagation(int s, int e, int n) { // toggle: 0이면 구간 합 계산, 1이면 값만 계산
        if (lazy1[n] != 0) {
            tree1[n] += lazy1[n] * (e - s + 1);
            if (s != e) {
                lazy1[n * 2] += lazy1[n];
                lazy1[n * 2 + 1] += lazy1[n];
            }
            lazy1[n] = 0;
        }
        if (lazy2[n] != 0) {
            tree2[n] += lazy2[n];
            if (s != e) {
                lazy2[n * 2] += lazy2[n];
                lazy2[n * 2 + 1] += lazy2[n];
            }
            lazy2[n] = 0;
        }
    }

    void update(int s, int e, int n, int l, int r, int w, int toggle) { // toggle: 0이면 구간 합 갱신, 1이면 값만 갱신
        lazyPropagation(s, e, n);
        if (r < s || e < l) return;
        if (l <= s && e <= r) {
            if (toggle == 0) lazy1[n] += w;
            else lazy2[n] += w;
            lazyPropagation(s, e, n);
            return;
        }
        int mid = (s + e) / 2;
        update(s, mid, n * 2, l, r, w, toggle);
        update(mid + 1, e, n * 2 + 1, l, r, w, toggle);
        tree1[n] = tree1[n * 2] + tree1[n * 2 + 1];
    }

    int count(int s, int e, int n, int l, int r, int toggle) { // toggle: 0이면 구간 합 계산, 1이면 값만 계산
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) {
            return (toggle == 0) ? tree1[n] : tree2[n];
        }
        int mid = (s + e) / 2;
        return count(s, mid, n * 2, l, r, toggle) + count(mid + 1, e, n * 2 + 1, l, r, toggle);
    }

}