// 동전 뒤집기 (1285번)
import java.io.*;
import java.util.*;

public class Main {

    /*
    * 행에 대해서만 뒤집다가 열에 대해서 그리디하게 뒤집어서 최소 동전의 개수를 찾음
    * */
    static void flip(int k) {
        // 열에 대해서 그리디하게 뒤집어 봄
        // 뒤집었을 때 T가 더 적으면 뒤집는다 -> 뒤집었을 때 H는 T이므로 현재 H의 개수(= 뒤집었을 때 T)를 카운트
        if (k == N) { // 다 뒤집었으면 반환
            int t = 0;
            for (int j = N - 1; j >= 0; j--) { // 0열부터 시작하니 인덱스 상에선 N - 1부터 시작
                int tmpH = 0;
                for (int i = 0; i < N; i++) {
                    if ((coins[i] & (1 << j)) != 0) tmpH += 1; // j번째 숫자와 비트 AND 연산했을 때 0보다 크면 1 증가
                }
                // 현재 H의 개수가 과반 이상이면 뒤집지 않는다 -> 뒤집으면 T가 더 많아지기 때문
                if (tmpH >= (N / 2) + 1) {
                    t += (N - tmpH);
                } else {
                    t += tmpH;
                }
            }
            MIN = Math.min(MIN, t);
            return;
        }
        // 이번 행을 뒤집지 않음
        flip(k + 1);
        // 이번 행을 뒤집음 -> 현재 비트를 비트 반전함
        coins[k] = ~coins[k];
        flip(k + 1);
    }

    static int N, MIN, MAX_BIT; // 동전의 개수
    static int[] coins; // 동전 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        MIN = 0; // 현재 T의 개수
        MAX_BIT = (1 << N) - 1;
        coins = new int[N];
        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            int bit = 0; // 비트 -> H: 1, T: 0
            for (int j = 0; j < N; j++) {
                if (line.charAt(j) == 'H') bit = 2 * bit + 1;
                else {
                    bit = 2 * bit;
                    MIN += 1;
                }
            }
            coins[i] = bit;
        }

        flip(0);
        System.out.println(MIN);
    }
}