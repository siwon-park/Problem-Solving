// 다이나믹 롤러 (17393번)
/*
  문제: https://www.acmicpc.net/problem/17393
  이분탐색
  시작 인덱스가 매번 바뀌는 upperbound 문제
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int upperBound(int s, int e, long[] arr, long val) {
        int idx = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] <= val) {
                s = mid + 1;
                idx = mid;
            } else {
                e = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        long[] B = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            B[i] =  Long.parseLong(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            sb.append(upperBound(i, N - 1, B, A[i]) - i);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
