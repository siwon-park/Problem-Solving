// Moo 게임 (5904번)
/*
  문제: https://www.acmicpc.net/problem/5904
  재귀, 분할 정복
  N이 S(k) 중에서 몇 번째인지 찾고, 다시 N을 규칙에 따라서 분할했다.
*/


import java.io.*;

public class Main {

    static void recur(int n, int k) {
        if (n >= N) {
            M = (n - k) / 2;
            K = k;
            return;
        }
        recur(n + k + 1 + n, k + 1);
    }

    static void recur2(int k, int n, int m) {
        if (1 <= n - m && n - m <= k) {
            if (n - m == 1) {
                ans = "m";
            } else {
                ans = "o";
            }
        } else if (n <= m) {
            recur2(k - 1, n, (m - (k - 1)) / 2);
        } else {
            recur2(k - 1, n - m - k, (m - (k - 1)) / 2);
        }
    }

    static int N, M, K;
    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        recur(3, 3);
        recur2(K, N, M);
        System.out.println(ans);
    }
}
