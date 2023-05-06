// 스위치 (1395번)
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N);

        int x, l, r;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            if (x == 0) { // 스위치 반전
                segmentTree.update(1, N, 1, l, r);
            } else if (x == 1) { // 켜져있는 스위치 출력
                int ret = segmentTree.count(1, N, 1, l, r);
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

    void lazyPropagation(int s, int e, int n) {
        if (lazy[n] != 0) {
            if (s != e) { // 리프 노드가 아닐 경우
                lazy[n * 2] ^= 1;
                lazy[n * 2 + 1] ^= 1;
                int tempCount = 0; // 오른쪽, 왼쪽의 상태에 따라 전구의 개수 반전(값이 1이면 반전 필요)
                int mid = (s + e) / 2;
                if (lazy[n * 2] != 0) tempCount += (mid - s + 1) - tree[n * 2];
                else tempCount += tree[n * 2];
                if (lazy[n * 2 + 1] != 0) tempCount += (e - (mid + 1) + 1) - tree[n * 2 + 1];
                else tempCount += tree[n * 2 + 1];
                tree[n] = tempCount;
            } else { // 리프 노드일 경우
                tree[n] ^= 1;
            }
            lazy[n] = 0;
        }
    }

    int update(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return tree[n];
        if (l <= s && e <= r) {
            lazy[n] ^= 1; // 반전
            lazyPropagation(s, e, n);
            return tree[n];
        }
        int mid = (s + e) / 2;
        return tree[n] = update(s, mid, n * 2, l, r) + update(mid + 1, e, n * 2 + 1, l, r);
    }

    int count(int s, int e, int n, int l, int r) {
        lazyPropagation(s, e, n);
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return count(s, mid, n * 2, l, r) + count(mid + 1, e, n * 2 + 1, l, r);
    }
}