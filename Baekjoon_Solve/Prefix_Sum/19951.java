// 태상이의 훈련소 생활 (19951번)
/*
  문제: https://www.acmicpc.net/problem/19951
  누적 합
  문제를 해결하는 아이디어가 굉장히 좋은 문제라고 생각한다.
  (a, b, k)가 주어졌을 때, 누적합 배열 ps에서
  ps[a - 1]에 k를 누적하고, ps[b]에 -k를 누적한다.
  이 배열을 0부터 N-1까지 누적합을 진행하면 구간 [a - 1, b)는 의도했던 대로 k값이 각각 요소에 더해지고
  구간 [b, N-1]는 시작 지점에 -k가 더해져있어 k를 더해서 누적하면 이후 누적되는 값은 전부 0이다.
  결국에는 의도했던 대로 쿼리의 구간에 대해서만 k값을 누적 계산한 결과를 얻을 수 있게된다.
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = new int[N + 1];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            prefixSum[a - 1] += k;
            prefixSum[b] -= k;
        }

        for (int i=1; i<N; i++) {
            prefixSum[i] += prefixSum[i - 1];
            arr[i - 1] += prefixSum[i - 1];
            sb.append(arr[i - 1] + " ");
        }
        sb.append(arr[N - 1] + prefixSum[N - 1]);

        System.out.println(sb);
    }
}
