// LCS2 (9252번)
////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/9252
  // DP
  // 점화식을 세우는 것까진 됬는데, LCS를 구하는데에 애를 먹어서 질문게시판의 힌트를 참고했다.
  // 근데 해당 논리를 이해하려면 두 문자가 같지 않을 경우의 점화식인 arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1])을 이해하면 된다.
  // 즉, 두 문자가 같지 않으면 arr[i][j]는 좌측 아니면 윗쪽이 가장 큰 값이므로 포인터를 해당 방향으로 이동시켜서
  // 각 문자가 같으면 문자를 추가하는 식으로 구현하면 되는 것이었다.
  // 처음 접하는 방식이라 아예 생각지도 못한 접근법이었던 것 같다. 숙지해두자.
////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int maxLength = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int N = str1.length();
        int M = str2.length();

        arr = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                String s1 = str1.charAt(i - 1) + "";
                String s2 = str2.charAt(j - 1) + "";
                if (s1.equals(s2)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
                maxLength = Math.max(maxLength, arr[i][j]);
            }
        }

        System.out.println(maxLength); // LCS의 최대 길이

        if (maxLength > 0) { // 0이상일 경우에만 LCS를 출력함
            int n = N;
            int m = M;
            StringBuffer sb = new StringBuffer();
            while (n > 0 && m > 0) {
                String s1 = str1.charAt(n - 1) + "";
                String s2 = str2.charAt(m - 1) + "";
                if (s1.equals(s2)) {
                    sb.append(s1);
                    n -= 1;
                    m -= 1;
                } else if (arr[n][m] == arr[n - 1][m]) {
                    n -= 1;
                } else if (arr[n][m] == arr[n][m - 1]) {
                    m -= 1;
                }
            }
            sb.reverse();
            String ret = sb.toString();
            System.out.println(ret);
        }
        br.close();
    }
}
