// 색상환 (2482번)
//////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2482
  // DP
  // 2차원의 dp 테이블을 선언하고, dp[i][j]를 i색상환에서 j개를 고르는 경우의 수를 마킹한다.
  // 점화식은 dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD이다.
  // i색상환에서 j개를 선택하는 경우는 i - 2색상환에서 j - 1개를 선택한 다음 색상환 2개를 추가하고 하나를 더 선택하면 되는 경우와
  // i - 1색상환에서 j개를 선택한 다음 색상환 1개를 추가하고나서 아무것도 선택하지 않으면 되는 경우의 합이다.
  // dp 테이블은 i색상환에서 1개를 고르는 경우의 수는 무조건 i개이므로 i로 초기화한다.
//////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;

public class Main {
    static final int MOD = 1000000003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][K + 1];

        for (int i=2; i<N+1; i++) {
            dp[i][1] = i; // 1개를 고르는 경우의 수는 i개

        }

        for (int i=4; i<N+1; i++) {
            for (int j=2; j<K+1; j++) {
                // i - 2 색상환에서 j - 1개를 선택한 경우 + i - 1 색상환에서 j개를 선택한 경우
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
        
    }
}
