// 크면서 작은 수 (2992번)
/*
  문제: https://www.acmicpc.net/problem/2992
  백트랙킹
  주어진 숫자의 각 자리수를 배열에 담은 다음에 백트랙킹으로 순열을 구성하면서 X보다 큰 제일 작은 수를 찾으면 된다.
  ans의 값이 Integer.MAX_VALUE이면 0을 출력하면 된다.
*/

import java.io.*;

public class Main {

    static void backtrack(int k, int num) {
        if (k == N) {
            if (num > X) {
                ans = Math.min(ans, num);
            }
        }
        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(k + 1, num + pow(numbers[i], k));
                visited[i] = false;
            }
        }
    }

    static int pow(int n, int k) {
        int m = 1;
        for (int i=0; i<k; i++) {
            m *= 10;
        }
        return n * m;
    }

    static int N, X;
    static int ans = Integer.MAX_VALUE;
    static int[] numbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmpX = br.readLine();
        X = Integer.parseInt(tmpX);
        N = tmpX.length();
        numbers = new int[N];
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(tmpX.charAt(i) + "");
        }

        backtrack(0, 0);
        System.out.println((ans != Integer.MAX_VALUE) ? ans : 0);
    }
}
