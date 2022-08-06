// 음계(2920번)
////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2920
  // 구현
  // 오름차순이 나온 횟수가 7번이면 ascending을, -7이면 descending을, 그게 아니라면 mixed를 출력하게 하였음
////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for (int i=0; i<8; i++) {
            int n =sc.nextInt();
            arr[i] = n;
        }
        int cnt = 0;
        for (int i=0; i<7; i++) {
            if (arr[i] < arr[i+1]) {
                cnt+=1;
            }
            else {
                cnt-=1;
            }
        }
        if (cnt == 7) {
            System.out.println("ascending");    
        } else if (cnt == -7) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
