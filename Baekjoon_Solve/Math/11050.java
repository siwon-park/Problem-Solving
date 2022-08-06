// 이항계수1 (11050번)
///////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/11050
  // 수학, 구현
  // nCk를 구현하면 되는 문제 n!/((n-k)!*k!)
  // 처음에 왜 0이 나오지 했는데 res의 값을 0으로 초기화해서 그랬던 것이었다.
///////////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int res = 1;
        for (int i=0; i<K; i++) {
            res *= (N-i);
            res /= i+1;
        }
        System.out.println(res);
    }
}
