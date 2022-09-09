// 구간 곱 구하기(11505번)
//////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/11505
  // 세그먼트 트리
  // 구간 합 구하기와 동일한 문제
  // 다만 이번엔 곱이기 때문에 덧셈 연산이 있는 부분을 곱으로 바꿔주고 모듈러 연산을 추가해주면 된다.
//////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class SegmentTree {
        private long[] tree;
        private long MOD = 1000000007;

        SegmentTree(int n) {
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            tree = new long[Math.toIntExact(treeNodeCount)];
        }

        long init(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                tree[node] = (init(arr, node * 2, start, mid) * init(arr, node * 2 + 1, mid + 1, end)) % MOD;
                return tree[node];
            }
        }

        long mul(int node, int left, int right, int start, int end) {
            if (right < start || left > end) {
                return 1;
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                return (mul(node * 2, left, right, start, mid) * mul(node * 2 + 1, left, right, mid + 1, end)) % MOD;
            }
        }

        long update(int node, int start, int end, int index, long changeValue) {
            if (index < start || end < index) {
                return tree[node];
            } else if (index == start && end == index) {
                tree[node] = changeValue;
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                tree[node] = (update(node * 2, start, mid, index, changeValue) * update(node * 2 + 1, mid + 1, end, index, changeValue)) % MOD;
                return tree[node];
            }
        }
    }

    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N);
        long[] arr = new long[N + 1];

        for (int i=0; i<N; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i + 1] = num;
        }

        segmentTree.init(arr, 1, 1, N);

        for (int i=0; i<M+K; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            long c = Long.parseLong(st2.nextToken());
            // a가 1인 경우 숫자를 바꾸고, 2인 경우 곱을 출력
            if (a == 1) {
                segmentTree.update(1, 1, N, b, c);
            } else if (a == 2) {
                long ret = segmentTree.mul(1, b, (int) c, 1, N);
                System.out.println(ret);
            }
        }
        br.close();
    }
}
