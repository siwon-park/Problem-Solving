// 소수의 자격 (6219번)
/////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/6219
  // 수학, 에라토스테네스의 체
  // 에라토스테네스의 체로 소수를 판별한 다음에 해당 숫자의 자릿수를 체크하면서 숫자 D가 있는지 확인하면 된다.
  // 처음에 D가 2자리 이상일 수 있겠다 싶어서 문자열로 비교하는 방식으로 구현하려 했는데, 질문 게시판을 확인해보니
  // 여기서 말하는 숫자란 0 ~ 9까지라고한다. 그래서 오히려 더 쉽게 풀 수 있었다.
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        primes[0] = true;
        primes[1] = true;
        for (int i=2; i<4000001; i++) {
            int j = 2;
            if (!primes[i]) {
                while (i * j <= 4000000) {
                    primes[i * j] = true;
                    j += 1;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i=A; i<=B; i++) {
            if (!primes[i] && include(i, D)) {
                cnt ++;
            }
        }
        System.out.println(cnt);
    }

    static int A, B, D;
    static boolean[] primes = new boolean[4000001];

    static boolean include(int num, int d) {
        int n = 1;
        while (num > 0) {
            int r = (int) (num % Math.pow(10, n));
            if (r == d) {
                return true;
            }
            num = (int) (num / Math.pow(10, n));
        }
        return false;
    }
}
