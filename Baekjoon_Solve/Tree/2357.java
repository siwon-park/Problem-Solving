// 최솟값과 최댓값(2357번)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2357
  // 세그먼트 트리
  // 2개의 세그먼트 트리를 활용한다. 하나는 구간의 최댓값, 다른 하나는 구간의 최솟값을 담고 있다.
  // 최댓값, 최솟값을 찾는 find 연산을 만들고, 최댓값 세그먼트 트리에서 최댓값을, 최솟값 세그먼트 트리에서 최솟값을 찾아서 출력하면 된다.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

        long minInit(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                tree[node] = Math.min(minInit(arr, node * 2, start, mid), minInit(arr, node * 2 + 1, mid + 1, end));
                return tree[node];
            }
        }

        long maxInit(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                tree[node] = Math.max(maxInit(arr, node * 2 ,start, mid), maxInit(arr, node * 2 + 1, mid + 1, end));
                return tree[node];
            }
        }

        long findMinNum(int node, int left, int right, int start, int end) {
            if (right < start || end < left) {
                return 1000000000; // 비교했을 때 최소를 반환하기 위해 가장 큰 값 설정
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                return Math.min(findMinNum(node * 2, left, right, start, mid), findMinNum(node * 2 + 1, left, right, mid + 1, end));
            }
        }

        long findMaxNum(int node, int left, int right, int start, int end) {
            if (right < start || end < left) {
                return -1000000000;
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                return Math.max(findMaxNum(node * 2, left, right, start, mid), findMaxNum(node * 2 + 1, left, right, mid + 1, end));
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
        
        SegmentTree maxSegmentTree = new SegmentTree(N); // 최댓값 세그먼트 트리
        SegmentTree minSegmentTree = new SegmentTree(N); // 최솟값 세그먼트 트리

        long[] arr = new long[N + 1];
        for (int i=0; i<N; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i + 1] = num;
        }

        maxSegmentTree.maxInit(arr, 1, 1, N);
        minSegmentTree.minInit(arr, 1, 1, N);

        for (int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            long minNum = minSegmentTree.findMinNum(1, a, b, 1, N);
            long maxNum = maxSegmentTree.findMaxNum(1, a, b, 1, N);
            bw.write(minNum + " " + maxNum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
