// 커피숍2 (1275번)
/////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1275
  // 세그먼트 트리
  // 구간 합 구하기와 동일한 문제이다
  // 다만 이 문제에서 주의할 점이 있다면, x ~ y까지의 구간 합을 구한 뒤에 a번째 숫자의 값을 b로 바꿔주는 업데이트를 진행해야한다.
  // 게다가 x ~ y에서 x < y인 보장이 없으므로 x > y인 케이스에 대해서 swap을 통해 처리를 해줘야한다.(질문 게시판을 보지 않았다면 아마 몰랐을 것이다...)
/////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {

        private long[] tree;

        SegmentTree(int n) {
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            tree = new long[Math.toIntExact(treeNodeCount)];
        }

        long init(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return tree[node];
            }
            int mid = (start + end) / 2;
            tree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid + 1, end);
            return tree[node];
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

        long update(int node, int start, int end, int index, long changeValue) {
            if (index < start || end < index) {
                return tree[node];
            } else if (index == start && end == index) {
                tree[node] = changeValue;
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                tree[node] = update(node * 2, start, mid, index, changeValue) + update(node * 2 + 1, mid + 1, end, index, changeValue);
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

        String[] tmp = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i + 1] = Long.parseLong(tmp[i]);
        }

        segmentTree.init(arr, 1, 1, N);

        for (int i=0; i<Q; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            // x y a b => x ~ y까지의 합을 구하여라, 그리고 a번째 수를 b로 바꿔라
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            int a = Integer.parseInt(st2.nextToken());
            long b = Long.parseLong(st2.nextToken());
            
            // x ~ y에서 y가 x보다 크다는 보장이 없으므로 swap처리를 해줘야함
            if (x > y) {
                int swapTmp = x;
                x = y;
                y = swapTmp;
            }

            long ret = segmentTree.sum(1, x, y, 1, N);
            segmentTree.update(1, 1, N, a, b);
            System.out.println(ret);
        }
    }
}
