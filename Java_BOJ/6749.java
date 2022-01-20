//Next in Line(6749번)
////////////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/6749
    // 수학
    // 세 자식 간 나이는 등차 수열이고, 가장 막내와 둘째의 나이가 주어지므로 맏이의 나이는 둘째의 나이 + 둘째와 막내 나이의 차이이다.
////////////////////////////////////////////////////////
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Y = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(M+M-Y);
    }
}
