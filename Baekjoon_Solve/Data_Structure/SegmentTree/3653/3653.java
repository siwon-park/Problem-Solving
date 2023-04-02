import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // tc의 수
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 영화의 수
            int m = Integer.parseInt(st.nextToken()); // 보려고 하는 영화의 수
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[n + m + 1]; // 초기 영화 배열
            Arrays.fill(arr, 1); // 영화 배열을 모두 1로 채움
            for (int i = n + m; i > n; i--) arr[i] = 0; // 뒤에 m개의 영화는 0으로 채움

            // 보려고 하는 영화 순서 -> 초기에는 1부터 N까지 증가하는 순으로 쌓임
            // 가장 위에 있는 영화 번호가 1이고, 아래가 N
            // 세그먼트 트리의 1번 인덱스에는 자식들의 합이 담겨 있으므로
            // N번 인덱스에 1번 영화, 1번 인덱스에 1 ~ N까지 영화의 합이 있음
            // 따라서 m개의 보고싶은 영화 인덱스를 역으로 사용해야함. 즉 1이면 N번 인덱스인 것임.
            HashMap<Integer, Integer> hashMap = new HashMap<>(); // 영화 위치 저장
            for (int i = 1; i <= n; i++) {
                hashMap.put(n - i + 1, i); // n - i + 1번째 영화의 위치는 i
            }

            SegmentTree segmentTree = new SegmentTree(n + m, arr);
            segmentTree.init(1, n + m, 1);
            int top = n; // 영화를 보고 난 다음 맨 위에 쌓으므로 n
            for (int i = 0; i < m; i++) {
                int dvdNo = Integer.parseInt(st.nextToken()); // 입력 받은 영화의 번호
                int dvdIdx = hashMap.get(dvdNo); // 영화의 위치
                int ans = segmentTree.sum(1, n + m, 1, dvdIdx, top) - 1; // dvdIdx ~ top까지의 합을 구함
                bw.write(ans + " ");
                segmentTree.update(1, n + m, 1, dvdIdx, 0); // idx번째 영화의 값을 0으로 바꿈
                top += 1; // 영화의 꼭대기를 증가시킴
                segmentTree.update(1, n + m, 1, top, 1); // 꼭대기의 값을 1로 변경
                hashMap.put(dvdNo, top); // 영화 번호의 위치를 top으로 변경시킴
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class SegmentTree {
    int[] tree;
    int[] arr;
    SegmentTree(int N, int[] arr) {
        this.tree = new int[N * 4];
        this.arr = arr;
    }

    int init(int s, int e, int n) {
        if (s == e) {
            tree[n] = arr[s];
            return tree[n];
        }
        int mid = (s + e) / 2;
        tree[n] = init(s, mid, n * 2) + init(mid + 1, e, n * 2 + 1);
        return tree[n];
    }

    int update(int s, int e, int n, int idx, int val) {
        if (idx < s || e < idx) return tree[n];
        if (idx == s && e == idx) {
            tree[n] = val;
            return tree[n];
        }
        int mid = (s + e) / 2;
        tree[n] = update(s, mid, n * 2, idx, val) + update(mid + 1, e, n * 2 + 1, idx, val);
        return tree[n];
    }

    int sum(int s, int e, int n, int l, int r) {
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[n];
        int mid = (s + e) / 2;
        return sum(s, mid, n * 2, l, r) + sum(mid + 1, e, n * 2 + 1, l, r);
    }
}