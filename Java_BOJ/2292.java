// 벌집(2292번)
/////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2292
  // 수학
  // 이 문제를 푸는데 오래 걸린 이유는 또 시간초과가 날까 두려워서 다른 산식이 있나 찾다가 헤멨다.
  // 시간초과가 날까 고민했던 이유는 N의 최댓값이 int(1e9)여서 1부터 6의 배수씩 더해서 가면 시간초과가 나지 않을까 생각했는데, 쓸데없는 걱정이었다.
  // 다음부터는 시간초과 날까 고민하지 말고 그냥 질러야겠다.
/////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 1;
        int n = 1;
        while (true) {
            if (N<=n) {
                break;
            }
            n+=6*cnt;
            cnt += 1;
        }
        System.out.println(cnt);
    }
}
