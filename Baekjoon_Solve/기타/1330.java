//두 수 비교하기(1330번)
//////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/1330
    // Python에서 elif가 Java에서는 else if 라는 것을 배웠다
//////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int A,B;
        A=sc.nextInt();
        B=sc.nextInt();
        if (A>B){
            System.out.println(">"); 
        } else if (A<B){
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }
}
