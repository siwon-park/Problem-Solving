// 숫자의 개수(2577번)
//////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2577
  // 수학, 구현
  // a,b,c를 곱한 값을 문자열로 변환하고, 길이 10인 배열을 만들어서, 문자열에 있는 숫자 문자를 인덱스로 하여 해당 인덱스에 +=1을 해줌
  // num.charAt(i)를 하고, 그것을 정수형으로 그대로 변환시켜주는 것이 포인트였음
//////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int N = A*B*C;
        String num = ""+N;
        int[] arr = new int[10];
        for (int i=0; i<num.length(); i++) {
            int n = Integer.parseInt(num.charAt(i)+""); // 그냥 int n = num.charAt(i)를 하면 묵시적 변환이 일어남
            arr[n]+=1;
        }
        for (int i=0; i<10; i++) {
            System.out.println(arr[i]);
        }
    }
}
