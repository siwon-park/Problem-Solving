// 윤년(2753번)
//////////////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/2753
    // 수학, 구현
    // 나는 시간 관련 문제는 풀기 꺼려서 일부러 안 풀고 있었는데
    // 그냥 if문을 활용한 나눗셈 문제였음
    // java도 if문 안에 괄호를 씌워서 괄호끼리의 조건문이 가능하다는 것을 알았다
//////////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if ((year%4 == 0 && year%100 !=0 )||(year%400==0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
