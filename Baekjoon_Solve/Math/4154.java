// 직각삼각형(4154번)
////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/4153
  // 수학
  // 처음에 50%에서 틀렸습니다가 나왔는데, 
  // 그 이유는 입력으로 들어오는 a,b,c에서 맨 마지막 요소가 항상 빗변이라는 것이 문제에 없기 때문에
  // a,b,c의 순서를 바꿨을 때 직각삼각형이 되는지도 추가적으로 확인해봐야한다.
////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            if (((a*a + b*b) == c*c) || ((c*c + b*b) == a*a) || ((a*a + c*c) == b*b)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
