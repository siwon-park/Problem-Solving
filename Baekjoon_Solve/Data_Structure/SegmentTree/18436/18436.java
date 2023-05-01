// 수열과 쿼리 37 (18436번)
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수열의 길이
        Pair[] arr = new Pair[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0) arr[i] = new Pair(1, 0);
            else arr[i] = new Pair(0, 1);
        }

        SegmentTree segmentTree = new SegmentTree(N, arr);
        segmentTree.init(1, N, 1);

        int M = Integer.parseInt(br.readLine()); // 쿼리의 개수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken()); // 쿼리의 종류
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (q == 1) {
                segmentTree.update(1, N, 1, a, b); // a번째 인덱스 값을 b로 바꿈
            } else if (q == 2) {
                int ret = segmentTree.count(1, N, 1, a, b).evenCnt; // a와 b 사이의 짝수 개수를 반환
                bw.write(ret + "\n");
            } else if (q == 3) {
                int ret = segmentTree.count(1, N, 1, a, b).oddCnt; // a와 b 사이의 홀수 개수를 반환
                bw.write(ret + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    Pair[] arr;
    Pair[] tree;

    SegmentTree(int n, Pair[] arr) {
        this.tree = new Pair[n * 4];
        this.arr = arr;
    }

    Pair init(int s, int e, int n) {
        if (s == e) return tree[n] = arr[s];
        int mid =  (s + e) / 2;
        Pair o1 = init(s, mid, n * 2);
        Pair o2 = init(mid + 1, e, n * 2 + 1);
        return tree[n] = new Pair(o1.evenCnt + o2.evenCnt, o1.oddCnt + o2.oddCnt);
    }

    Pair update(int s, int e, int n, int idx, int val) {
        if (idx < s || e < idx) return tree[n];
        if (idx == s && e == idx) {
            if (val % 2 == 0) return tree[n] = new Pair(1, 0);
            else return tree[n] = new Pair(0, 1);
        }
        int mid = (s + e) / 2;
        Pair o1 = update(s, mid, n * 2, idx, val);
        Pair o2 = update(mid + 1, e, n * 2 + 1, idx, val);
        return tree[n] = new Pair(o1.evenCnt + o2.evenCnt, o1.oddCnt + o2.oddCnt);
    }

    Pair count(int s, int e, int n, int l, int r) {
        if (r < s || e < l) return new Pair(0, 0); // 범위를 벗어나면 홀짝의 개수 0 반환
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        Pair o1 = count(s, mid, n * 2, l, r);
        Pair o2 = count(mid + 1, e, n * 2 + 1, l, r);
        return new Pair(o1.evenCnt + o2.evenCnt, o1.oddCnt + o2.oddCnt);
    }

}

class Pair {
    int evenCnt; // 짝수의 개수
    int oddCnt; // 홀수의 개수

    Pair(int evenCnt, int oddCnt) {
        this.evenCnt = evenCnt;
        this.oddCnt = oddCnt;
    }
}