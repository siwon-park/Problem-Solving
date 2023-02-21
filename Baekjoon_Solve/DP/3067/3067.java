import java.io.*;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<N+1; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[10001]; // M + 1로 크기를 설정하면 X => N개의 동전 중 M보다 클 경우 인덱스 에러 발생

            for (int n=1; n<N+1; n++) {
                int coin = coins[n];
                dp[coin] += 1;
                for (int m=1; m<M+1; m++) {
                    if (m - coin >= 0) {
                        dp[m] += dp[m - coin];
                    }
                }
            }
            bw.write(dp[M] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}