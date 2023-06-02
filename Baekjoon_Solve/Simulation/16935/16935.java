// 배열 돌리기 3 (16935번)
import java.io.*;
import java.util.*;

public class Main {

    static void upDownFlip() {
        int R = arr.length;
        int C = arr[0].length;
        int[][] tmpArr = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                tmpArr[r][c] = arr[R - r - 1][c];
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) arr[r][c] = tmpArr[r][c];
        }
    }

    static void leftRightFlip() {
        int R = arr.length;
        int C = arr[0].length;
        int[][] tmpArr = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                tmpArr[r][c] = arr[r][C - 1 - c];
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) arr[r][c] = tmpArr[r][c];
        }
    }

    static void rotateRight() {
        int R = arr.length;
        int C = arr[0].length;
        int[][] tmpArr = new int[C][R];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                tmpArr[c][r] = arr[R - r - 1][c];
            }
        }
        arr = new int[C][R];
        for (int r = 0; r < C; r++) {
            for (int c = 0; c < R; c++) arr[r][c] = tmpArr[r][c];
        }
    }

    static void rotateLeft() {
        int R = arr.length;
        int C = arr[0].length;
        int[][] tmpArr = new int[C][R];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                tmpArr[c][r] = arr[r][C - c - 1];
            }
        }
        arr = new int[C][R];
        for (int r = 0; r < C; r++) {
            for (int c = 0; c < R; c++) arr[r][c] = tmpArr[r][c];
        }
    }

    static void switchArea1() {
        int R = arr.length;
        int C = arr[0].length;
        int[][] tmpArr = new int[R][C];
        // 4 -> 1
        for (int r = 0; r < R / 2; r++) {
            for (int c = 0; c < C / 2; c++) tmpArr[r][c] = arr[r + R / 2][c];
        }
        // 1 -> 2
        for (int r = 0; r < R / 2; r++) {
            for (int c = C / 2; c < C; c++) tmpArr[r][c] = arr[r][c - C / 2];
        }
        // 2 -> 3
        for (int r = R / 2; r < R; r++) {
            for (int c = C / 2; c < C; c++) tmpArr[r][c] = arr[r - R / 2][c];
        }
        // 3 -> 4
        for (int r = R / 2; r < R; r++) {
            for (int c = 0; c < C / 2; c++) tmpArr[r][c] = arr[r][c + C / 2];
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) arr[r][c] = tmpArr[r][c];
        }
    }

    static void switchArea2() {
        int R = arr.length;
        int C = arr[0].length;
        int[][] tmpArr = new int[R][C];
        // 2 -> 1
        for (int r = 0; r < R / 2; r++) {
            for (int c = 0; c < C / 2; c++) tmpArr[r][c] = arr[r][c + C / 2];
        }
        // 3 -> 2
        for (int r = 0; r < R / 2; r++) {
            for (int c = C / 2; c < C; c++) tmpArr[r][c] = arr[r + R / 2][c];
        }
        // 4 -> 3
        for (int r = R / 2; r < R; r++) {
            for (int c = C / 2; c < C; c++) tmpArr[r][c] = arr[r][c - C / 2];
        }
        // 1 -> 4
        for (int r = R / 2; r < R; r++) {
            for (int c = 0; c < C / 2; c++) tmpArr[r][c] = arr[r - R / 2][c];
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) arr[r][c] = tmpArr[r][c];
        }
    }

    static int N, M, Q; // 행, 열, 연산 수
    static int[][] arr; // 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int q;
        for (int i = 0; i < Q; i++) {
            q = Integer.parseInt(st.nextToken());
            switch (q) {
                case 1: upDownFlip();
                        break;
                case 2: leftRightFlip();
                        break;
                case 3: rotateRight();
                        break;
                case 4: rotateLeft();
                        break;
                case 5: switchArea1();
                        break;
                case 6: switchArea2();
                        break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}