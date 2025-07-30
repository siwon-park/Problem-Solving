import java.io.*;
import java.util.*;

// 그리고 하나가 남았다 (3895번)
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        SegmentTree segmentTree;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0 && m == 0) break;
            segmentTree = new SegmentTree(n);
            segmentTree.init(1, n, 1); // 초기화
            int idx = segmentTree.remove(1, n, 1, m); // m번째 돌 제거 -> idx는 제거된 돌의 인덱스
            int cnt = segmentTree.count(1, n, 1, 1, idx); // idx 앞에 있는 돌의 개수 합
            // 남은 돌의 수는 n - 1개 -> n - 1번 반복
            int total = segmentTree.tree[1]; // 남은 전체 돌의 개수
            for (int i = 0; i < n - 1; i++) {
                // cnt + k % total == 0 이면 total번째 돌 제거
                idx = segmentTree.remove(1, n, 1, (cnt + k) % total == 0 ? total : (cnt + k) % total);
                cnt = segmentTree.count(1, n, 1, 1, idx);
                total = segmentTree.tree[1]; // 남은 전체 돌의 개수 갱신
            }
            bw.write(idx + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    int[] tree;

    SegmentTree(int n) {
        tree = new int[n * 4];
    }

    void init(int s, int e, int n) {
        if (s == e) {
            tree[n] = 1;
            return;
        }
        int mid = (s + e) >> 1;
        init(s, mid, n * 2);
        init(mid + 1, e, n * 2 + 1);
        tree[n] = tree[n * 2] + tree[n * 2 + 1];
    }

    int count(int s, int e, int n, int l, int r) {
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) >> 1;
        int left = count(s, mid, n * 2, l, r);
        int right = count(mid + 1, e, n * 2 + 1, l, r);
        return left + right;
    }

    // 돌 개수가 cnt개인 돌의 인덱스를 찾을 때까지 구간의 합을 -1씩 감소
    int remove(int s, int e, int n, int cnt) {
        tree[n] -= 1;
        if (s == e) return s;
        int mid = (s + e) >> 1;
        int left = tree[n * 2];
        if (cnt <= left) { // 왼쪽에서 찾음
            return remove(s, mid, n * 2, cnt);
        } else { // 오른쪽에서 찾음
            return remove(mid + 1, e, n * 2 + 1, cnt - left);
        }
    }
}

