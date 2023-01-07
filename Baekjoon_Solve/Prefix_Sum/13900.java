// 순서쌍의 곱의 합 (13900번)
/*
  문제: https://www.acmicpc.net/problem/13900
  누적합
  구간의 누적합을 구한 다음에
  누적합 * 인덱스에 해당하는 숫자를 곱해주면 된다.
  이렇게 되는 이유는 쌍을 구했을 때
  (1, 2), (1, 3), (1, 4)
  (2, 3), (2, 4)
  (3, 4)
  가 있을 때, (1, 2) / (1, 3), (2, 3) / (1, 4), (2, 4), (3, 4)로 묶을 수 있다.
  이를 누적합을 이용해서 계산하는 것이다.
*/


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] SUM = new long[N + 1];

        for (int i=1; i<N+1; i++) {
            SUM[i] = SUM[i - 1] + arr[i - 1];
        }

        long ans = 0;
        for (int i=1; i<N+1; i++) {
            ans += SUM[i - 1] * arr[i - 1];
        }

        System.out.println(ans);
    }
}
