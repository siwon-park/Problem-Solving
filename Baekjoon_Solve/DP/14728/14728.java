import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static class Pair implements Comparable<Pair>{
        int k; // 예상 공부 시간
        int s; // 문제의 배점
        Pair(int k, int s) {
            this.k = k;
            this.s = s;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.k > o.k) {
                return 1;
            } else if (this.k < o.k) {
                return -1;
            } else {
                return Integer.compare(this.s, o.s);
            }
        }
    }

    static int N, T; // 단원의 개수, 총 시간
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][T + 1];
        Pair[] pairs = new Pair[N + 1];
        pairs[0] = new Pair(0, 0); // 정렬을 위한 빈 Pair 생성
        for (int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(K, S);
        }

        Arrays.sort(pairs, Pair::compareTo); // 정렬

        for (int n=1; n<N+1; n++) {
            Pair pair = pairs[n];
            for (int t=1; t<T+1; t++) {
                dp[n][t] = t - pair.k >= 0 ? Math.max(dp[n - 1][t - pair.k] + pair.s, dp[n - 1][t]) : dp[n - 1][t];
            }
        }

        System.out.println(dp[N][T]);
    }
}