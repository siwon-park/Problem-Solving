// 직사각형과 쿼리 (14846번)
/////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/14846
  // N X N 행렬에서 1 ~ 10이 몇 번 등장했는지 누적한 다음에
  // 주어진 구간에 대해서 1 ~ 10 각각 누적합을 계산하여 구간의 누적합이 0 이상인 숫자에 대해서 등장 횟수+=1을 해주면 된다.
/////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] numbers = new int[11];
    static int N;
    static int Q;
    static int[][][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N + 1][N + 1][11];

        for (int i=1; i<N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<N+1; j++) {
                for (int k=1; k<11; k++) {
                    dp[i][j][k] += dp[i - 1][j][k] + dp[i][j - 1][k] - dp[i - 1][j - 1][k];
                }
                int n = Integer.parseInt(st.nextToken());
                dp[i][j][n] += 1;
            }
        }

        Q = Integer.parseInt(br.readLine());

        for (int q=0; q<Q; q++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st2.nextToken());
            int y1 = Integer.parseInt(st2.nextToken());
            int x2 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());

            int cnt = 0;
            for (int k=1; k<11; k++) {
                int ret = dp[x2][y2][k] - dp[x2][y1 - 1][k] - dp[x1 - 1][y2][k] + dp[x1 - 1][y1 - 1][k];
                if (ret > 0) {
                    cnt += 1;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
