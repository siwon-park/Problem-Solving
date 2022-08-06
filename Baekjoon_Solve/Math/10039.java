// 평균 점수(10039번)
////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10039
  // 오랜만에 Scanner를 사용해봤는데 역시 200ms대로 BufferedReader보다 느리다.
////////////////////////////////////////////////////////
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int total = 0;
    for (int i=0; i<5; i++) {
      int score = sc.nextInt();
      if (score < 40) {
        score = 40;
      }
      total += score;
    }
    System.out.println(total/5);
  }
}
