// 기타리스트 (1495번)
/*
  문제: https://www.acmicpc.net/problem/1495
  DP
  2차원의 DP 배열을 선언
  DP[N][M]을 N번째 곡을 M의 볼륨으로 연주할 수 있음으로 표시
  조건에 맞게 dp[i][j]를 마킹하고, 마지막에 i == n에 대해서 j의 최댓값을 구하면 된다.
  최댓값이 갱신되지 않을 경우 -1을 출력하면 된다.
*/


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, S, M;
    static int[] V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        V = new int[N + 1];
        for (int i=1; i<N+1; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N + 1][M + 1]; // N번째 곡을 M 볼륨으로 연주할 수 있음
        dp[0][S] = true;
        for (int i=1; i<N+1; i++) {
            for (int j=0; j<M+1; j++) {
                if (dp[i - 1][j]) {
                    if (j + V[i] <= M) dp[i][j + V[i]] = true;
                    if (j - V[i] >= 0) dp[i][j - V[i]] = true;
                }
            }
        }

        int ans = -1;
        for (int i=0; i<M+1; i++) {
            if (dp[N][i]) ans = i;
        }
        System.out.println(ans);
    }
}
