// 나머지(3052번)
///////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/3052
  // 수학
  // n을 42로 나눈 나머지 중 서로 다른 나머지가 몇개 있는지 구하는 문제이므로, 크기가 42인 배열을 선언하였음
  // 그 후 나머지를 인덱스로 하여 배열의 값을 +=1 증가시켰고, 전체 배열을 돌면서 값이 0이 아니면 서로 다른 나머지의 수에 +=1을 해줬음
///////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[42];
        for (int i=0; i<10; i++) {
            int n = sc.nextInt();
            arr[n%42]+=1;
        }
        int notSame = 0;
        for (int i=0; i<42; i++) {
            if (arr[i]!=0) {
                notSame+=1;
            }
        }
        System.out.println(notSame);
    }
}
