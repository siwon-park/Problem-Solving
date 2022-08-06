// 시험 성적(9498번)
///////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/9498
    // if 문 사용
    // java에서는 python 처럼 if 80 <= B <= 89: 와 같은 구문은 사용할 수 없다.
    // if (B >= 80 && B <= 89)와 같이 표현해야한다.
///////////////////////////////////////////////////
import java.util.*;
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80 && score <= 89) {
            System.out.println("B");
        } else if (score >= 70 && score <= 79) {
            System.out.println("C");
        } else if (score >= 60 && score <= 69) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
