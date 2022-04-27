// 나는 친구가 적다(small) (16171번)
////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/16171
  // 문자열
  // 문자열에서 0이나 9사이에 있는 문자는 제외하고 스트링버퍼에 넣어서 문자열로 변환하여 contains를 사용해 찾고자 하는 문자열이 있는지 확인하였다.
  // 실수로 ('0' <= s && s <= '9') 이 부분을 ('0' < s && s < '9')으로 적어서 처음 시도에선 틀렸습니다를 받았다.
  // 삼항 연산자를 처음으로 써본 문제인듯하다.
////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    String wrongstr = br.readLine();
    String fidings = br.readLine();
    for (int i=0; i<wrongstr.length(); i++) {
      char s = wrongstr.charAt(i);
      if ('0' <= s && s <= '9') {
        continue;
      }
      sb.append(s);
    }
    String S = sb.toString();
    System.out.println(S.contains(fidings) ? 1 : 0);
  }
}
