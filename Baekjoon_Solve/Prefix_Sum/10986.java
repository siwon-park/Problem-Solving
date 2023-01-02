// 나머지 합 (10986번)
/*
  문제: https://www.acmicpc.net/problem/10986
  누적합
  N이 최대 10^6이고, A의 최대값이 10^9이므로 단순 누적합 및 브루트포스를 사용하면 시간초과, 메모리초과가 난다.
  힌트는 나머지에 있다.
  누적합의 나머지가 같은 그룹을 묶는다. 나머지가 같으면 구간합을 계산했을 때, 0이므로
  해당 구간은 M으로 나누어 떨어진다.
  따라서 나머지가 같은 그룹 안의 요소의 개수 중에서 2개를 뽑는 경우의 수를 누적하면 된다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        long[] remainder = new long[M];
        remainder[0] = 1;
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<N+1; i++) {
            A[i] = (A[i - 1] + Integer.parseInt(st.nextToken())) % M;
            remainder[A[i]] += 1;
        }

        long ans = 0;
        for (int i=0; i<M; i++) {
            ans += (remainder[i] * (remainder[i] - 1)) / 2;
        }

        System.out.println(ans);

    }
}
