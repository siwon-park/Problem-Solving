// ROT13 (11655번)
////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/11655
  // 문자열
  // String형은 대소 비교 및 숫자 연산이 불가능하지만, char형은 가능하다.
  // 'Z'나 'z'를 초과했을 경우에 해당하는 아스키 코드 값을 빼고, 64나 96을 더해줘야한다.
  // 'a'(97), 'A'(65)라고 해서 65나 97을 더 해주면 초과해서 해당 위치로 가서 밀기 시작하는 것이므로 원했던 칸수 + 1을 하게되는 셈이다.
////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        int n = tmp.length();
        String ans = "";

        for (int i=0; i<n; i++) {
            char s = tmp.charAt(i);
            if ('A' <= s && s <= 'Z') {
                s += 13;
                if (s > 90) {
                    s -= 90;
                    s += 64;
                }
            } else if ('a' <= s && s <= 'z') {
                s += 13;
                if (s > 122) {
                    s -= 122;
                    s += 96;
                }
            }

            ans += s + "";
        }

        System.out.println(ans);
        br.close();
    }
}
