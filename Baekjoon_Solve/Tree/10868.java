// 최솟값(10868번)
///////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10868
  // 세그먼트 트리
  // 최솟값을 구성하는 세그먼트 트리를 만든 다음 입력에 대해 구간의 최솟값을 찾아서 출력하면 된다.
///////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
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
            } else {
                int mid = (start + end) / 2;
                tree[node] = Math.min(init(arr, node * 2, start, mid), init(arr, node * 2 + 1, mid + 1, end));
                return tree[node];
            }
        }

        long findMinNum(int node, int left, int right, int start, int end) {
            if (right < start || end < left) {
                return 1000000000;
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                return Math.min(findMinNum(node * 2, left, right, start, mid), findMinNum(node * 2 + 1, left, right, mid + 1, end));
            }
        }
    }

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N);
        long[] arr = new long[N + 1];

        for (int i=0; i<N; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i + 1] = num;
        }

        segmentTree.init(arr, 1, 1, N);

        for (int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            long minNum = segmentTree.findMinNum(1, a, b, 1, N);
            bw.write(minNum +" \n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
