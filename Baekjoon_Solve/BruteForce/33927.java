// 나이트 오브 나이츠 (33927번)
import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static final int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int N, ans;
    static int[] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N * N];
        visited = new boolean[N * N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[i * N + j] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        backtrack(0, 0);
        System.out.println(ans);
    }

    private static boolean validate(int cur) {
        int r = cur / N;
        int c = cur % N;
        for (int k = 0; k < 8; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (visited[nr * N + nc]) return false;
        }
        return true;
    }

    private static void backtrack(int idx, int sum) {
        if (sum > ans) ans = sum;
        for (int i = idx; i < N * N; i++) {
            if (!validate(i)) continue;
            visited[i] = true;
            backtrack(i + 1, sum + board[i]);
            visited[i] = false;
        }
    }
}

