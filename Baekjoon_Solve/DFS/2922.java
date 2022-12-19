// 즐거운 단어 (2922번)
/*
 문제: https://www.acmicpc.net/problem/2922
 백트랙킹
 직접 백트랙킹으로 단어를 넣어서 체크하면 시간초과가 난다.
 따라서 경우의 수 계산을 통해서 만들 수 있는 즐거운 단어를 구해야한다.
 처음에 자음 21개, 모음 5개에 L인 특수한 경우를 추가적으로 고려하다보니, 중복이 발생할 수 밖에 없다.
 다른 스터디원의 풀이를 보니까 20개의 자음과, 5개의 모음, L인 경우로 나눠서 고려하고 있었다.
 즉, L이 여러 개 들어가는 경우의 수는 L들과 나머지 20, 5개의 조합으로 고려하는 셈이다.
 조합, 경우의 수 고려하는 문제를 많이 풀어봐야겠다는 생각이 든다... ㅠㅠ
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean check() { // 연속된 자음, 모음 체크(슬라이딩 윈도우 방식)
        int s = 0;
        int e = 2;
        boolean Lcnt = false; // L이 등장한 횟수
        while (e < N) {
            int cnt1 = 0; // 자음 개수
            int cnt2 = 0; // 모음 개수
            for (int i=s; i<=e; i++) {
                if (words[i].equals("L")) {
                    Lcnt = true;
                }
                if (VOW.contains(words[i]) || words[i].equals("2")) {
                    cnt2 += 1;
                } else {
                    cnt1 += 1;
                }
            }
            if (cnt1 == 3 || cnt2 == 3) {
                return false;
            }
            s += 1;
            e += 1;
        }
        if (Lcnt) {
            return true;
        }
        return false;
    }

    static void fillBlanks(int idx, int cnt) {
        if (cnt == blanks) { // 되는지 확인
            boolean flag = check();
            if (flag) {
                long tmp = 1;
                for (int i=0; i<N; i++) {
                    if (words[i].equals("1")) { 
                        tmp *= 20; // L을 제외한 자음의 개수 20개
                    } else if (words[i].equals("2")) {
                        tmp *= 5;
                    }
                }
                ans += tmp; // 전부 L인 경우에는 1을 더 함
            }
            return;
        }
        for (int i=idx; i<N; i++) {
            if (words[i].equals("_")) {
                words[i] = "L"; // L
                fillBlanks(i + 1, cnt + 1);
                words[i] = "_";
                words[i] = "1"; // 자음
                fillBlanks(i + 1, cnt + 1);
                words[i] = "_";
                words[i] = "2"; // 모음
                fillBlanks(i + 1, cnt + 1);
                words[i] = "_";
            }
        }
    }

    static int N, blanks; // 단어의 길이, 공백의 개수
    static long ans; // 경우의 수(정답)
    static String[] words;
    static String VOW = "AEIOU";
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        words = br.readLine().split("");
        N = words.length;
        for (int i=0; i<N; i++) {
            if (words[i].equals("_")) {
                blanks += 1;
            }
        }

        fillBlanks(0, 0);
        System.out.println(ans);

    }
}
