// 비숍 (1799번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, ans, idx1, idx2, ret;
    static int[] whiteBoard, blackBoard;
    static boolean[] diag1, diag2; // r + c, r - c + N - 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        whiteBoard = new int[N * N];
        blackBoard = new int[N * N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 0) continue;
                if ((i + j) % 2 == 0) whiteBoard[idx1++] = i * N + j;
                else blackBoard[idx2++] = i * N + j;
            }
        }

        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];
        ans = 0;
        ret = 0;
        backtrack(whiteBoard, idx1,0, 0);
        ans += ret;
        Arrays.fill(diag1, false);
        Arrays.fill(diag2, false);
        ret = 0;
        backtrack(blackBoard, idx2, 0, 0);
        ans += ret;
        System.out.println(ans);
    }

    private static void backtrack(int[] board, int max, int idx, int cnt) {
        if (cnt > ret) ret = cnt;
        for (int i = idx; i < max; i++) {
            int pos = board[i];
            int r = pos / N;
            int c = pos % N;
            int d1 = r + c;
            int d2 = r - c + N - 1;
            if (!diag1[d1] && !diag2[d2]) {
                diag1[d1] = true;
                diag2[d2] = true;
                backtrack(board, max, i + 1, cnt + 1);
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }
}

