// 문제 출제 (2854번)
//////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2854
  // DP
  // 아이디어를 떠올리기가 힘들었던 문제이다. 문제를 이해하기까지 좀 시간이 걸리기도 했고...
  // 점화식은 마지막에 i번째 문제를 선택하는데 고정 난이도에서 i번째 문제를 선택하는 경우와
  // 가변 난이도1에서 i번째 문제를 선택하는 경우 => 단, 이전에 가변 난이도에서 i - 1번째 문제를 선택한 경우를 1번 제외시켜야 하는 것을 유의!
  // 가변 난이도2에서 i번째 문제를 선택하는 경우의 합이다.
//////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N + 1];
        int[] arr2 = new int[N + 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i=1; i<N+1; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
        }

        for (int i=1; i<N; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        long[][] dp = new long[N + 1][3]; // 0번째 인덱스는 고정 난이도, 1번째 인덱스는 가변 1, 2번째 인덱스는 가변2
        dp[1][0] = arr1[1];
        dp[1][2] = arr2[1];

        for (int i=2; i<N+1; i++) {
            dp[i][0] = (arr1[i] * (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2])) % MOD; // 마지막에 고정 난이도에서 i번째 문제를 선택
            dp[i][1] = ((arr2[i - 1] * (dp[i - 1][0] + dp[i - 1][1])) + (arr2[i - 1] - 1) * dp[i - 1][2]) % MOD; // 마지막에 가변 난이도1에서 i번째 문제를 선택
            dp[i][2] = (arr2[i] * (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2])) % MOD; // 마지막에 가변 난이도2에서 i번째 문제를 선택
        }


        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);

    }
}
