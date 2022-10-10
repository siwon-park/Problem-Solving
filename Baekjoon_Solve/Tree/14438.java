// 수열과 쿼리 17(14438번)
////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/14438
  // 세그먼트 트리
  // 세그먼트 트리 기본 문제
  // 합이나 곱 결과를 반환하는 것이 아니라, 최솟값을 반환하므로 Math.min의 결과를 반환하면 된다. 업데이트 역시 
////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {
        long[] tree;

        SegmentTree(int n) {
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
            long treeNode = Math.round(Math.pow(2, treeHeight));
            tree = new long[Math.toIntExact(treeNode)];
        }

        long init(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return tree[node];
            }
            int mid = (start + end) / 2;
            tree[node] = Math.min(init(arr, node * 2, start, mid), init(arr, node * 2 + 1, mid + 1, end));
            return tree[node];
        }

        long minValue(int node, int left, int right, int start, int end) {
            if (right < start || end < left) {
                return 1000000001; // 대소 비교 중 항상 큰 값이 되기 위해서 int(1e9) + 1을 반환한다.
            } else if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return Math.min(minValue(node * 2, left, right, start, mid), minValue(node * 2 + 1, left, right, mid + 1, end));
        }


        long update(int node, int index, int start, int end, long value) {
            if (index < start || end < index) {
                return tree[node];
            } else if (index == start && end == index) {
                tree[node] = value;
                return tree[node];
            }
            int mid = (start + end) / 2;
            tree[node] = Math.min(update(node * 2, index, start, mid, value), update(node * 2 + 1, index, mid + 1, end, value));
            return tree[node];
        }
    }

    static int N; // 수열의 크기
    static long[] arr; // 수열
    static int M; // 쿼리의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");

        SegmentTree segmentTree = new SegmentTree(N);
        arr = new long[N + 1];

        for (int i=0; i<N; i++) {
            arr[i + 1] = Long.parseLong(tmp[i]);
        }

        segmentTree.init(arr, 1, 1, N);

        int M = Integer.parseInt(br.readLine());

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int idx = Integer.parseInt(st.nextToken());
                long v = Long.parseLong(st.nextToken());
                segmentTree.update(1, idx, 1, N, v);
            } else if (q == 2) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long ret = segmentTree.minValue(1, l, r, 1, N);
                bw.write(ret + "\n");

            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
