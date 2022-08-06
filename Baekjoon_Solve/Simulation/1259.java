// 팰린드롬수(1259번)
/////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1259
  // 문자열, 구현
  // 여러 가지로 할 줄 몰라서 조금 헤맸다.
  // 특히 n==0일 때, break하게끔 코드를 짰으나, 의도했던대로 작동하지 않았다.
  // 그 이유는 자바에서 ==은 동일한 객체를 판단하는 것이지, 값이 동일한지 판별하는 것이 아니었기 때문이다.
  // 그래서 .equals를 사용했더니 됐다.
  // 자바에서 코드를 짜면서 원할하게 자료형을 다루는게 아직도 익숙치 않다.
  // 파이썬에 비해서 코드를 짜기 어려우니 작성하면서 이렇게 짜는게 맞나 싶기도 한다.
/////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String n = sc.next();
            if (n.equals("0")) {
                break;
            }
            int len = n.length();
            boolean flag = true;
            for (int i=0; i<len/2; i++) {
                String str1 = n.charAt(i)+"";
                String str2 = n.charAt(len-1-i)+"";
                if (str1.equals(str2)==false) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
