// 삼각형과 세 변(5073번)
//////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/5073
  // 수학
  // "Invaild"를 어떻게 구현할까 잠깐 고민했는데, a, b, c 중 a를 가장 큰 값으로 바꿔주는 과정을 진행한 다음에 해결하였다.
  // 그리고 Invalid에 해당하는 조건을 2번째 둬야한다. 왜냐하면 Isosceles, Scalene 부터 둬버리면 Invalid인데도 불구하고
  // Isosceles, Scalene을 출력해버리기 때문이다.
//////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String[] tmp_arr = br.readLine().split(" ");
      int a = Integer.parseInt(tmp_arr[0]);
      int b = Integer.parseInt(tmp_arr[1]);
      int c = Integer.parseInt(tmp_arr[2]);
      // a를 가장 큰 값으로 변경
      if (a < b) {
        int tmp = a;
        a = b;
        b = tmp;
      } 
      if (a < c) {
        int tmp = a;
        a = c;
        c = tmp;
      }
      if (a == 0 && b == 0 && c == 0) {
        break;
      }
      if (a == b && b == c && c == a) {
        System.out.println("Equilateral"); // Equilateral : 세 변의 길이가 모두 같은 경우
      } else if (b + c <= a) { // Invalid : 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않은 경우
        System.out.println("Invalid");
      } else if ((a == b) || (b == c) || (c == a)) { // Isosceles : 두 변의 길이만 같은 경우
        System.out.println("Isosceles");
      } else if (a != b && b != c && c != a) { // Scalene : 세 변의 길이가 모두 다른 경우
        System.out.println("Scalene");
      }
    }
  }
}
