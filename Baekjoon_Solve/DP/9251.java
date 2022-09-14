// LCS (9251번)
//////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/9251
  // DP
  // 점화식이, 문자열이 같을 땐 arr[i][j] = arr[i - 1][j - 1] + 1이고, 서로 다를 땐 arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1])인 이유
  // 얼핏보기에 arr[i][j] = max(arr[i - 1][j], arr[i][j - 1], arr[i - 1][j - 1]) + 1 인 것처럼 보일 수도 있는데,
  // 예를 들어 입력 문자열의 길이가 서로 다른 경우 하나는 A, 하나는 AA라고 하자
  // 이때, 점화식이 arr[i][j] = max(arr[i - 1][j], arr[i][j - 1], arr[i - 1][j - 1]) + 1와 같다면 arr[1][2]인 경우(또는 arr[2][1])에 
  // 해당 값이 2가 기록된다. 하지만 최장 '공통' 부분 수열을 찾는 것이므로 1이 기록되어 햔다.
  // 그래서 문자열이 서로 같을 때는 대각선 방향을 보고, 아닐 때는 좌측 또는 상측 중 큰 값을 취하는 것이다.
//////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string1 = br.readLine();
        String string2 = br.readLine();
        int N = string1.length();
        int M = string2.length();

        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j ++) {
                String s1 = string1.charAt(i - 1) + "";
                String s2 = string2.charAt(j - 1) + "";

                if (s1.equals(s2)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }

                maxValue = Math.max(maxValue, arr[i][j]);
            }
        }

        System.out.println(maxValue);

    }
}

