import java.io.*;
import java.util.*;

// F1ow3rC0n (23833번)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int Q = Integer.parseInt(st.nextToken()); // 쿼리 수
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.arr = arr;
        segmentTree.init(1, N, 1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); // 쿼리 타입
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (t == 1) bw.write(segmentTree.count(1, N, 1, a, b).cnt + "\n");
            else segmentTree.update(1, N, 1, a, b);
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

class SegmentTree {
    Node[] tree;
    int[] arr;

    SegmentTree(int n) {
        this.tree = new Node[n * 4];
        for (int i = 0; i < n * 4; i++) tree[i] = new Node();
    }

    Node init(int s, int e, int n) {
        if (s == e) {
            tree[n].cnt = 1;
            tree[n].lb = tree[n].rb = arr[s];
            return tree[n];
        }
        int mid = (s + e) >> 1;
        Node left = init(s, mid, n * 2);
        Node right = init(mid + 1, e, n * 2 + 1);
        return getNode(n, left, right);
    }

    Node update(int s, int e, int n, int idx, int val) {
        if (idx < s || e < idx) return tree[n];
        if (idx == s && e == idx) {
            tree[n].lb = tree[n].rb = val;
            tree[n].cnt = 1;
            return tree[n];
        }
        int mid = (s + e) >> 1;
        Node left = update(s, mid, n * 2, idx, val);
        Node right = update(mid + 1, e, n * 2 + 1, idx, val);
        return getNode(n, left, right);
    }

    Node count(int s, int e, int n, int l, int r) {
        if (r < s || e < l) return new Node();
        if (l <= s && e <= r) {
            return tree[n];
        }
        int mid = (s + e) >> 1;
        Node left = count(s, mid, n * 2, l, r);
        Node right = count(mid + 1, e, n * 2 + 1, l, r);
        if (right.cnt == 0) {
            return new Node(left.lb, left.rb, left.cnt);
        } else if (left.cnt == 0) {
            return new Node(right.lb, right.rb, right.cnt);
        } else {
            if (left.rb == right.lb) {
                return new Node(left.lb, right.rb, Math.max(left.cnt + right.cnt - 1, 1));
            } else {
                return new Node(left.lb, right.rb, left.cnt + right.cnt);
            }
        }
    }

    private Node getNode(int n, Node left, Node right) {
        if (right.cnt == 0) {
            tree[n].lb = left.lb;
            tree[n].rb = left.rb;
            tree[n].cnt = left.cnt;
            return tree[n];
        } else if (left.cnt == 0) {
            tree[n].lb = right.lb;
            tree[n].rb = right.rb;
            tree[n].cnt = right.cnt;
            return tree[n];
        } else {
            tree[n].lb = left.lb;
            tree[n].rb = right.rb;
            if (left.rb == right.lb) tree[n].cnt = Math.max(left.cnt + right.cnt - 1, 1);
            else tree[n].cnt = left.cnt + right.cnt;
            return tree[n];
        }
    }
}


class Node {
    int lb, rb, cnt;
    Node() {}
    Node (int lb, int rb, int cnt) {
        this.lb = lb;
        this.rb = rb;
        this.cnt = cnt;
    }
}
