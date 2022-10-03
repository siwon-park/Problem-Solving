// 모음의 개수(1264번)
//////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1264
  // 문자열
  // 입력으로 주어지는 문자열에서 모음의 개수를 찾는 문제
  // 입력으로 주어지는 문자열을 모두 소문자로 바꾼 다음에 모음의 개수를 카운트해주었다.
//////////////////////////////////////////////////////////////////////////////////////
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String words = br.readLine().toLowerCase();
            int cnt = 0;

            if (words.equals("#")) {
                break;
            }

            int N = words.length();
            for (int i=0; i<N; i++) {
                String s = words.charAt(i) + "";
                if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
                    cnt ++;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
