import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int dfs(int n) {
        if (n == -1) return 0;
        if (dp[n] != -1) return dp[n];
        int cur = cheers[n];
        cur += dfs(parent[n]);
        dp[n] = cur;
        return dp[n];
    }

    static int N, M; // 회사의 직원 수, 칭찬 횟수
    static int[] parent, cheers, dp; // 직속 상사 번호, 각 사원별 칭찬받은 수치, dp배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        cheers = new int[N + 1];
        dp = new int[N + 1];
        dp[0] = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            parent[i] = Integer.parseInt(st.nextToken()); // 직속 상사
            dp[i] = -1;
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            cheers[i] += w;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            int ret = dfs(i);
            sb.append(ret + " ");
        }
        System.out.println(sb);
    }
}