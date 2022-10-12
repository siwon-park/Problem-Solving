// 가장 많은 글자(1371번)
////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1371
  // 문자열, 구현
  // java의 EOF 처리에 대해 다시 한번 복습하기 위해 풀어보았다.
////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = "";
        while ((S = br.readLine()) != null) {
            int N = S.length();
            for (int i=0; i<N; i++) {
                char s = S.charAt(i);
                if ('a' <= s && s <= 'z') {
                    arr[s - 'a'] ++;
                }
            }
        }

        int max = 0;
        for (int i=0; i<26; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        String ans = "";
        for (int i=0; i<26; i++) {
            if (arr[i] == max) {
                ans += (char)(i + 97) + "";
            }
        }

        System.out.println(ans);
    }
}
