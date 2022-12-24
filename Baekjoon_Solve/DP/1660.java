// 캡틴 이다솜 (1660번)
/*
  문제: https://www.acmicpc.net/problem/1660
  DP
  4면체가 되는 숫자를 기록하고, 해당 수에 해당하는 dp배열의 값을 1로 만든다.
  2부터 N + 1까지 반복문을 돌면서 그 안에서 사면체를 만들 수 있는 숫자에 대해 반복 구문을 돈다.
  어떤 숫자 n이 사면체이면 i는 i - n에 1을 더해서 만들 수 있다.
  예) 9는 5에 4를 더해서 만들 수 있고, 8에 1을 더해서 만들 수 있다. 그리고 그 때의 값이 최소이다.
  처음에 사면체에 대해서 반복구문을 돌리지 않고, j=1부터 i까지 2중 반복하였는데, 시간초과가 났다.
  우리가 필요한 것은 최솟값이므로, 만들 수 있는 사면체와의 조합을 통해 계산해야 했다. 모든 경우를 따지니 시간초과 날 수 밖에 없다.
*/

import java.io.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        ArrayList<Integer> fours = new ArrayList<>();
        int n = 0;
        int m = 0;
        while (true) {
            n += (m * (m + 1)) / 2;
            if (n > N) {
                break;
            }
            fours.add(n);
            dp[n] = 1;
            m += 1;
        }

        for (int i=2; i<N+1; i++) {
            if (dp[i] == 1) {
                continue;
            }
            dp[i] = Math.min(dp[i - 1] + 1, Integer.MAX_VALUE);
            for (Integer num : fours) {
                if (num > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - num] + 1);
            }
        }

        System.out.println(dp[N]);

    }
}
