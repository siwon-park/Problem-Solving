// 평균(1546번)
///////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1546
  // 수학
  // 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이므로, 배열을 선언할 때, int형이 아니라 double형으로 선언한다.
  // 또한 평균을 구하기 위한 누적값도 double로 선언한다. int형으로 해버리면 자바에서 나머지는 전부 버리므로 안 된다.
///////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxScore = 0;
        int N = sc.nextInt();
        double[] arr = new double[N];
        for (int i=0; i<N; i++) {
            int n = sc.nextInt();
            arr[i] = n;
            if (n > maxScore) {
                maxScore = n;
            }
        }
        double total = 0;
        for (int i=0; i<N; i++) {
            total+=arr[i]/maxScore*100;
        }
        System.out.println(total/N);
    }
}
