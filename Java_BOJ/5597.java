// 과제 안 내신 분..?(5597번)
/////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/5597
  // 구현
  // 길이가 31인 배열을 선언하여 입력으로 받는 숫자를 인덱스로 하여 배열에 1을 마킹한다.
  // 1부터 30까지 배열을 탐색하여 0으로 체크되어 있는 인덱스를 출력하면 끝.
/////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[31];
        for (int i=0; i<28; i++) {
            int n = sc.nextInt();
            arr[n]+=1;
        }
        for (int i=1; i<31; i++) {
            if (arr[i]==0) {
                System.out.println(i);
            }
        }
    }
}
