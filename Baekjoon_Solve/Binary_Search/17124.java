// 두 개의 배열 (17124번)
/*
  문제: https://www.acmicpc.net/problem/17124
  이분탐색, 정렬
  lowerBound로 배열 A의 숫자 하나가 정렬된 배열 B에 들어갈 위치를 찾는다.
  해당 위치 - 1이 음수면 B[0]을 더하고, 해당 위치가 배열 B의 길이와 같다면 B[m - 1]을 더한다.
  그게 아니라면 배열 B의 해당위치 - 1과 해당위치에 있는 숫자 중 A의 숫자와 가까운 수를 더한다.
  lowerBound를 잘못 구현해서 1시간을 낭비했다.
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int lowerBound(int[] arr, int target) {
        int idx = arr.length;
        int s = 0;
        int e = idx - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (target <= arr[mid]) {
                e = mid - 1;
                idx = mid;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }

    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] A = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int[] B = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<m; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            long ans = 0L;
            for (int i=0; i<n; i++) {
                int idx = lowerBound(B, A[i]);
                if (idx - 1 < 0) {
                    ans += B[0];
                } else if (idx == m) {
                    ans += B[m - 1];
                } else {
                    ans += (Math.abs(A[i] - B[idx - 1]) <= Math.abs(A[i] - B[idx])) ? B[idx - 1] : B[idx];
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}
