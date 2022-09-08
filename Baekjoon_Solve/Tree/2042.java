// 구간 합 구하기(2042번)
////////////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2042
  // 세그먼트 트리
  // 세그먼트 트리라는 자료 구조를 알아야만 풀 수 있는 문제이다. 해당 알고리즘에 대해 익히고자 가장 기본적인 유형으로 유명한 문제를 풀어보았다.
  // 개념 자체는 분할정복, 재귀와 비슷하다. (알고리즘 및 자료 구조 레포지토리에 개념에 대해 정리해둠)
////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

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
                return tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                tree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid + 1, end);
                return tree[node];
            }
        }

        long sum(int node, int left, int right, int start, int end) {
            if (right < start || end < left) {
                return 0;
            } else if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return sum(node * 2, left, right, start, mid) + sum(node * 2 + 1, left, right, mid + 1, end);
        }

        // 값을 변경하는 형태의 업데이트 함수
        long update(int node, int start, int end, int index, long changeValue) {
            if (index < start || end < index ) {
                return tree[node];
            } else if (start == index && end == index) {
                tree[node] = changeValue;
                return tree[node];
            }
            int mid = (start + end) / 2;
            tree[node] = update(node * 2, start, mid, index, changeValue) + update(node * 2 + 1, mid + 1, end, index, changeValue);
            return tree[node];
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

        for (int i=0; i<M + K; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            // a가 1이면 b번째 수를 c로 변경, a가 2이면 [b, c]의 구간 합을 반환
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            long c = Long.parseLong(st2.nextToken()); // c는 a가 2일 때, 값으로 들어올 수도 있으니 long으로 선언한다.
            if (a == 1) {
                segmentTree.update(1, 1, N, b, c);
            } else if (a == 2) {
                long ret = segmentTree.sum(1, b, (int) c, 1, N); // c가 long으로 선언됐지만, sum함수에서 구간의 끝 c는 int형이므로 형변환을 해준다.
                System.out.println(ret);
            }
        }
    }
}
