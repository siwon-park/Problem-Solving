// 가계부(Hard) (12837번)
///////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/12837
  // 세그먼트 트리
  // 세그먼트 트리 연습용 문제
  // 특이한 점은 init 함수로 트리를 초기화하고 시작하는 것이 아니라
  // 아예 처음부터 트리에 값을 업데이트하는 방식으로 시작한다.
  // 그리고 생후 p일에 지출/수입을 추가하는 방식이므로 값을 바꾼다기보다는 값을 +- 변화시켜주면 된다.
///////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {

        public long[] tree;

        SegmentTree(int n) {
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
            long treeNode = Math.round(Math.pow(2, treeHeight));
            tree = new long[Math.toIntExact(treeNode)];
        }

        long init(long[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                return tree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid + 1, end);
            }
        }

        long sum(int node, int left, int right, int start, int end) {
            if (right < start || end < left) {
                return 0;
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                return sum(node * 2, left, right, start, mid) + sum(node * 2 + 1, left, right, mid + 1, end);
            }
        }

        long update(int node, int start, int end, int index, long addValue) {
            if (index < start || end < index) {
                return tree[node];
            } else if (index == start && end == index) {
                tree[node] += addValue;
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                tree[node] =  update(node * 2, start, mid, index, addValue) + update(node * 2 + 1, mid + 1, end, index, addValue);
                return tree[node];
            }
        }
    }

    static int N;
    static int Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N);
        long[] arr = new long[N + 1];

        for (int i=0; i<Q; i++) {
            String[] tmp = br.readLine().split(" ");
            int ord = Integer.parseInt(tmp[0]);
            int p = Integer.parseInt(tmp[1]);

            if (ord == 1) {
                long x = Integer.parseInt(tmp[2]);
                segmentTree.update(1, 1, N, p, x);

            } else {
                int q = Integer.parseInt(tmp[2]);
                long ret = segmentTree.sum(1, p, q, 1, N);
                System.out.println(ret);
            }
        }
    }
}
