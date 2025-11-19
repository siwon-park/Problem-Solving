// Civilization (11151번)
import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int ans, N;
    static int[] target;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            target = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) target[i] = Integer.parseInt(st.nextToken());
            arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) arr[i][j] = Integer.parseInt(st.nextToken());
            }
            ans = INF;
            backtrack(0, 0);
            if (ans == INF) bw.write("game over\n");
            else bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtrack(int idx, int cnt) {
        if (cnt >= ans) return;
        if (target[0] <= 0 && target[1] <= 0 && target[2] <= 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = idx; i < N; i++) {
            for (int j = 0; j < 3; j++) target[j] -= arr[i][j];
            backtrack(i + 1, cnt + 1);
            for (int j = 0; j < 3; j++) target[j] += arr[i][j];
        }
    }
}

