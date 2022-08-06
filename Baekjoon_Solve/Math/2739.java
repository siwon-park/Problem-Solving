// 구구단(2739번)
/////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2739
  // 수학
  // 구구단 결과를 문제에서 원하는 출력으로 표현함
/////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i=1; i<10; i++) {
            int result=N*i;
            System.out.println(N+" * "+ i+" = "+result);
        }
    }
}
