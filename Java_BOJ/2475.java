// 검증수(2475번)
/////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2475
  // 수학, 구현
  // 입력 받은 n을 제곱하여 누적합을 계산한뒤 10으로 나눈 나머지를 출력하면 됨.
/////////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        for (int i=0; i<5; i++) {
            int n = sc.nextInt();
            total += (n*n);
        }
        total %= 10;
        System.out.println(total);
    }
}
