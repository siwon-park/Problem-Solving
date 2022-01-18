// 손익분기점(1712번)
/////////////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/1712
    // 수학, 사칙연산
    // 손익분기점은 A+B*n<C*n이 되는 순간이다. 이를 처음엔 while 구문으로 n++;하여 확인하려고 했으나,
    // A,B,C의 값의 최대가 21억이라 하나 하나씩 n을 계산하게 되면 엄청난 시간이 걸린다
    // 하지만 n의 값을 한번에 구할 수 있는데, 위에 언급된 식을 n에 대해서 정리하면 n = A/(C-B)이다. 여기서 +1만 하면 손익 분기점을 넘으므로 정답
    // B>=C이면 아무리 C를 많이 팔아봐야 절대 손익분기점을 넘을 수 없으므로 -1을 출력한다.
/////////////////////////////////////////////////////////
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        if (B>=C){
            System.out.println(-1);
        } else{
            int n = A/(C-B)+1;
            System.out.println(n);
        }   
    }
}
