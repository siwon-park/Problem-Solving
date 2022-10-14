// 문자열 분석(10820번)
////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10820
  // 문자열
  // char s = S.charAt(i)로 인덱스별 문자 하나에 대해 어떤지 판단하였다.
  // 이 때, 숫자를 맨 마지막에 확인해야한다. 왜냐하면 공백일 경우 Integer.parseInt에 들어갈 경우 에러가 발생하기 때문이다.
  // 따라서 공백인지 먼저 확인하고 나서 맨 마지막에 숫자인지 확인을 한다.
////////////////////////////////////////////////////////////////////////////////
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = "";
        while ((S = br.readLine()) != null) {
            int N = S.length();
            int[] arr = new int[4];
            for (int i=0; i<N; i++) {
                char s = S.charAt(i);
                if ('a' <= s && s <= 'z') {
                    arr[0]++;
                } else if ('A' <= s && s <= 'Z') {
                    arr[1]++;
                } else if ( (s + "").equals(" ")) {
                    arr[3]++;
                } else if (0 <= Integer.parseInt(s + "") && Integer.parseInt(s + "") <= 9) {
                    arr[2]++;
                }
            }

            bw.write(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
