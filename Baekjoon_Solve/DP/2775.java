// 부녀회장이 될테야(2775번)
////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2775
  // 수학, DP
  // 간단한 수학 문제이면서 동시에 간단한 DP 문제이다. 점화식: dp[i][j]=dp[i-1][j]+dp[i][j-1] (1<= i, j <=15이기 때문에 더 간단)
  // 0층은 1, 2, 3, 4, 5, ... 1씩 증가하는 등차수열이고, 1층 이상부터는 해당 층의 전층 + 아랫층의 현재 층이다.
  // 처음으로 java에서 2차원의 배열을 사용해서 풀어본 문제였다.
////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[15][15];
        for (int i=1; i<15; i++) {
            arr[0][i]=i;
            arr[i][1]=1;
        }
        for (int i=1; i<15; i++) {
            for (int j=2; j<15; j++) {
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        int T = sc.nextInt();
        for (int i=0; i<T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(arr[k][n]);
        }
    }
}
