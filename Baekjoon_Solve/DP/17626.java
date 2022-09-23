// Four Squares (17626번)
////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/17626
  // DP
  // 제곱으로 표현해야하므로, i의 제곱근 내림 + 1까지 반복하면서 i - j*j 인 지점 + 1과 비교하여 더 작은 값을 택하면 된다.
  // 최대 4개의 제곱수로 표현가능하다 했으므로 dp 배열은 4로 초기화한다.
////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i=4; i<N+1; i++) {
            dp[i] = 4;
            for (int j=1; j<(int) (Math.pow(i, 0.5)) + 1; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
