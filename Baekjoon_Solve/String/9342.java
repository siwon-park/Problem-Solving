// 염색체 (9342번)
//////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/9342
  // 문자열, 정규식
  // 정규식을 사용할 줄 몰라서 문자열 구현으로 풀었다. 한 번 진짜 날 잡아서 정규식에 대해 정리해야겠다.
  // 조건에 대한 해석을 잘 해야하는 문제이다.
  // 그런데 이상한 점은 동일한 인풋에 대해서 다른 답을 출력하는데도 답인 경우가 있어서 어떤 게 맞는 건지 잘 모르겠다.
  // 일단 내가 해석한 조건의 의미는 다음과 같다
  // 문자열은 {A, B, C, D, E, F} 중 0개 또는 1개로 시작해야 한다. => 0번째 인덱스 문자는 A, B, C, D, E, F 중 하나에 해당하지 않을 경우 아예 오면 안 된다.
  // 즉, A, B, C, D, E, F 중 하나로 시작하거나, 빈 문자열 + 두 번째 조건을 만족시키는 것부터 시작해야한다.
  // 그 다음에는 A가 하나 또는 그 이상 있어야 한다.
  // 그 다음에는 F가 하나 또는 그 이상 있어야 한다.
  // 그 다음에는 C가 하나 또는 그 이상 있어야 한다.
  // 그 다음에는 {A, B, C, D, E, F} 중 0개 또는 1개가 있으며, 더 이상의 문자는 없어야 한다. => 문자열의 제일 끝은 C로 끝나거나 A, B, C, D, E, F 중 하나로 끝나야 한다.
  // 따라서 길이 2 이하면 무조건 Good이다.
  // 처음 조건과 마지막 조건이 조금 모호해서 생각이 필요한 문제였다.
//////////////////////////////////////////////////////////////////////////////
import java.io.*;

public class Main {

    static String check(String str) {
        int N = str.length();
        if (N <= 2) {
            return "Good";
        }
        char last = str.charAt(0);
        if (last != 'A' && last != 'B' && last != 'C' && last != 'D' && last != 'E' && last != 'F') {
            return "Good";
        }
        for (int i=1; i<N; i++) {
            char s = str.charAt(i);
            if (last == 'A' && s != 'A' && s != 'F') {
                return "Good";
            } else if (last == 'F' && s != 'F' && s != 'C') {
                return "Good";
            } else if (last == 'C' && s != 'C') {
                return "Good";
            }
            last = s;
        }

        return "Infected!";
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            String S = br.readLine();
            String ret = check(S);
            bw.write(ret + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
