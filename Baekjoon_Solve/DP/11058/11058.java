import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i=4; i<N+1; i++) {
            // i번 모두 A를 누르기, i - 1번 출력 결과에 A를 1번 누르기
            dp[i] = Math.max(i, dp[i - 1] + 1);
            for (int j=5; j<=i; j++) {
                /*
                * j - 4개를 복사해서 계속 출력하는 경우와 비교
                * j - 4번 누르고 3번 더 누름 => j - 1번 누름, 남은 누를 수 있는 횟수: i - j + 1번만큼 dp[j - 4]를 누를 수 있음
                * */
                dp[i] = Math.max(dp[i], dp[j - 4] * 2 + dp[j - 4] * (i - j + 1));
            }
        }

        System.out.println(dp[N]);
    }
}
