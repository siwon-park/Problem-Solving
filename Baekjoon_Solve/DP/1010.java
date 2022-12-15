// 다리 놓기 (1010번)
/////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1010
  // DP
  // 조합의 재귀적 성질을 이용하는 문제
  // nCk = n-1Ck-1 + n-1Ck이므로 dp[n][m] = dp[n - 1][m - 1] + dp[n - 1][m]이다.
  // 문제에서 N <= M이라고 했으므로, 위에 있는 점화식에서 n과 m의 위치를 바꿔주면 된다.
/////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] dp = new long[31][31]; // dp[n][m] = dp[n-1][m-1] + dp[n-1][m]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[1][1] = 1;

        for (int i=2; i<31; i++) {
            dp[i][1] = i;
            for (int j=2; j<31; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(dp[M][N]);
        }
    }
}
