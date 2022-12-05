// 먹을 것인가 먹힐 것인가 (7795번)
//////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/7795
  // 이분탐색
  // A와 B 배열 모두 정렬하여, A의 모든 요소에 대해서 B에 집어 넣는다고 할 때, B[j] < A[i]를 만족하는 위치면서
  // B에서 가장 왼쪽에 집어넣을 수 있는 위치를 찾는 문제이다.
//////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                A[i] = Integer.parseInt(st1.nextToken());
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i=0; i<M; i++) {
                B[i] = Integer.parseInt(st2.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int ans = 0;
            for (int i=0; i<N; i++) {
                ans += upperBound(B, 0, M - 1, A[i]);
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int upperBound(int[] arr, int start, int end, int target) {
        int idx = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) { // arr[mid] < target인 최고지점인 mid를 구해야함
                start = mid + 1;
                idx = start; // idx가 start인 이유는 arr[mid] < target인 최고지점 mid 인덱스의 오른쪽에 삽입해야하므로 mid + 1의 값인 start임
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }

}
