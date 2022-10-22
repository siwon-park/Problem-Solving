// ROT13 (4446번)
//////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/4446
  // 문자열, 구현
  // 모음은 3칸, 자음은 10칸 이동하는 것임을 유의하고 EOF 처리를 해줘야함을 유의할 것
  // 나머지는 그냥 아스키 코드 값에 따라 분기처리 해주면 된다.
//////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static char[] arr1 = {'a', 'i', 'y', 'e', 'o', 'u'};
    static char[] arr2 = {'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'};

    static int N = arr1.length;
    static int M = arr2.length;

    static Map<Character, Integer> stringMap1 = new HashMap<>();
    static Map<Character, Integer> stringMap2 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = "";
        while((S = br.readLine()) != null) {
            int L = S.length();
            String ans = "";

            for (int i=0; i<N; i++) {
                char k = arr1[i];
                int v = arr1[(i + 3) % N];
                stringMap1.put(k, v);
            }

            for (int i=0; i<M; i++) {
                char k = arr2[i];
                int v = arr2[(i + 10) % M];
                stringMap2.put(k, v);
            }

            for (int i=0; i<L; i++) {
                char s = S.charAt(i);
                if (65 <= s && s <= 90) {
                    s += 32;
                    if (s == 'a' || s == 'i' || s == 'y' || s == 'e' || s == 'o' || s == 'u') {
                        int v = stringMap1.get(s);
                        ans += (char) (v - 32);
                    } else {
                        int v = stringMap2.get(s);
                        ans += (char) (v - 32);
                    }
                } else if (97 <= s && s <= 122) {
                    if (s == 'a' || s == 'i' || s == 'y' || s == 'e' || s == 'o' || s == 'u') {
                        int v = stringMap1.get(s);
                        ans += (char) (v);
                    } else {
                        int v = stringMap2.get(s);
                        ans += (char) (v);
                    }
                } else {
                    ans += s;
                }
            }
            System.out.println(ans);
        }

        br.close();
    }
}
