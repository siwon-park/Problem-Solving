// Bags (26556번)
import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = Integer.MAX_VALUE;
    static int N, M, ans;
    static int[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            bags = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) bags[i] = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(br.readLine());
            ans = MAX;
            backtrack(0, 0, 0);
            bw.write((ans == MAX ? "Not possible" : ans) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static void backtrack(int idx, int sum, int cnt) {
        if (sum > M || cnt >= ans) return;
        if (sum == M) {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = idx; i < N; i++) backtrack(i + 1, sum + bags[i], cnt + 1);
    }
}

