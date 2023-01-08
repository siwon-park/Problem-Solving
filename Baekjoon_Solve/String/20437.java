// 문자열 게임 2 (20437번)
/*
  문제: https://www.acmicpc.net/problem/20437
  문자열, 슬라이딩 윈도우
  문제 접근 자체는 맞았다. 그런데 시간초과가 나서 그냥 다른 사람의 풀이를 참고했다.
  슬라이딩 윈도우라는 유형에 집중하다보니 슬라이딩 윈도우의 크기 w에 너무 매몰된 것 같다.
  i번 인덱스에서 부터 N번 인덱스까지 가면서 i번 인덱스에 해당하는 문자의 개수가 K개가 되면 최대, 최소 길이를 갱신해주는 방식으로 구현하면 된다.
*/


import java.io.*;

public class Main {

    static class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static Pair check(String str, int k) {
        int N = str.length();
        int MIN = 10001;
        int MAX = -1;
        int[] count = new int[26];
        for (int i=0; i<N; i++) {
            count[str.charAt(i) - 97] += 1;
        }
        if (k == 1) {
            return new Pair(1, 1);
        }
        for (int i=0; i<N; i++) {
            if (count[str.charAt(i) - 97] >= k) {
                int cnt = 1; // 현재 인덱스의 알파벳 수
                for (int j=i+1; j<N; j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        cnt += 1;
                    }
                    if (cnt == k) {
                        MIN = Math.min(MIN, j - i + 1);
                        MAX = Math.max(MAX, j - i + 1);
                        break;
                    }
                }
            }
        }

        return new Pair(MIN, MAX);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            Pair pair = check(W, K);
            if (pair.b == -1) {
                System.out.println(-1);
            } else {
                System.out.println(pair.a + " " + pair.b);
            }
        }
    }
}
