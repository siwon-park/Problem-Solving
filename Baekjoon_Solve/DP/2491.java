// 수열 (2491번)
/*
  문제: https://www.acmicpc.net/problem/2491
  DP
  가장 긴 증가하는 연속 수열(단조 증가), 가장 긴 감소하는 연속 수열(단조 감소)의 길이 중 가장 긴 값을 출력하면 된다.
  주의할 점은 연속 수열이지, 부분 수열이 아니라는 것이다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[N][2]; // 0은 증가, 1은 감소

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ASC_VALUE = 1;
        int DESC_VALUE = 1;
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i=1; i<N; i++) {
            if (arr[i - 1] <= arr[i]) {
                dp[i][0] = dp[i - 1][0] + 1;
                ASC_VALUE = Math.max(dp[i][0], ASC_VALUE);
            } else {
                dp[i][0] = 1;
            }
            if (arr[i - 1] >= arr[i]) {
                dp[i][1] = dp[i - 1][1] + 1;
                DESC_VALUE = Math.max(dp[i][1], DESC_VALUE);
            } else {
                dp[i][1] = 1;
            }
        }

        System.out.println(Math.max(ASC_VALUE, DESC_VALUE));

    }
}
