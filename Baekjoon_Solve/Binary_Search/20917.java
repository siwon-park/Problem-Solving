// 사회적 거리 두기 (20917번)
/*
  문제: https://www.acmicpc.net/problem/20917
  이분탐색, 매개변수 탐색
  이분탐색의 범위 s=1부터, e=MAX-MIN으로 배열의 최대 - 최솟값이다.
  배열의 요소 간 차이가 mid보다 크면 cnt += 1을 하고 last = X[i]로 현재 요소를 기록한다.
  그후, 만약 cnt가 S보다 크면 각 요소 간 거리가 최소 mid 이상인 값들로 S개를 만들 수 있다는 의미이므로,
  s의 범위를 증가시켜서 탐색한다.
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int binarySearch() {
        int D = 0;
        int s = 1;
        int e = MAX - MIN;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 1;
            int last = X[0];
            for (int i=0; i<N; i++) {
                if (X[i] - last >= mid) {
                    cnt += 1;
                    last = X[i];
                }
            }
            if (cnt >= S) {
                s = mid + 1;
                D = mid;
            } else {
                e = mid - 1;
            }

        }
        return D;
    }

    static int T, N, S;
    static int[] X;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            X = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
                MAX = Math.max(MAX, X[i]);
                MIN = Math.min(MIN, X[i]);
            }

            Arrays.sort(X);
            sb.append(binarySearch() + "\n");
        }
        System.out.println(sb);
    }
}
