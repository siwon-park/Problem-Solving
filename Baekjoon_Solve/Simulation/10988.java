// 팰린드롬인지 확인하기(10988번)
///////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10988
  // 문자열, 구현
  // StringBuffer자료형은 값을 비교하는 equals 비교해봐도 소용이 없으므로
  // toString을 통해서 문자열로 바꿔준다음에 equals로 비교해야한다.
  // 이번에는 저번에 배운 sb.reverse()를 활용해보았다.
///////////////////////////////////////////////////////
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringBuffer sb = new StringBuffer(s);
    sb.reverse();
    String rs = sb.toString();
    if (s.equals(rs)) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}
