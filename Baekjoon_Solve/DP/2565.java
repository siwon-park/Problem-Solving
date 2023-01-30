// 전깃줄 (2565번)
/*
  문제: https://www.acmicpc.net/problem/2565
  DP, LIS
  LIS 문제
  pairs 배열을 2개 만들고, 하나는 a를 기준으로 오름차순 정렬하고,
  다른 하나는 b를 기준으로 오름차순 정렬한다.
  정렬하지 않은 요소에 대해서 LIS를 찾은 다음
  N - 둘 중 더 큰 LIS의 길이를 뺀 값을 출력하면 된다.
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static int LIS(Pair[] pairs) {
        int lis = 0;
        int[] dp = new int[N];
        for (int i=0; i<N; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (pairs[j].b < pairs[i].b) { // 정렬하지 않은 요소를 기준으로
                    dp[i] = Math.max(dp[j] + 1, dp[i]); // LIS를 찾는다.
                }
            }
            lis = Math.max(dp[i], lis);
        }
        return lis;
    }

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        Pair[] pairs1 = new Pair[N];
        Pair[] pairs2 = new Pair[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pairs1[i] = new Pair(a, b);
            pairs2[i] = new Pair(b, a); // b와 a의 자리를 바꿔서 넣는다.
        }

        Arrays.sort(pairs1, (Pair o1, Pair o2) -> {
            return Integer.compare(o1.a, o2.a);
        });

        Arrays.sort(pairs2, (Pair o1, Pair o2) -> {
            return Integer.compare(o1.a, o2.a);
        });

        int lis1 = LIS(pairs1);
        int lis2 = LIS(pairs2);

        System.out.println(N - Math.max(lis1, lis2));

    }
}
