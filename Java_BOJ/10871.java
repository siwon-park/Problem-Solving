// X보다 작은 수(10871번)
///////////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/10871
    // 배열을 사용해서 문제를 풀까 하다가 for 구문을 2번 돌려야해서 그냥 풀었음
///////////////////////////////////////////////////////
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        String ans = new String(); // 빈 문자열 객체 ans 선언
        for (int i=0; i<N; i++){
            int arr = sc.nextInt();
            if (arr<X){
                ans+=arr+" "; // ans가 문자열이므로, 정수형 arr를 더하면 문자열이 됨
            }
        }
        System.out.println(ans);
    }
}
