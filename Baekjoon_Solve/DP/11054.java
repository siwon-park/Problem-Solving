// 가장 긴 바이토닉 부분 수열 (11054번)
/*
  문제: https://www.acmicpc.net/problem/11054
  DP
  Sk라는 배열의 특정 위치의 요소를 기준으로 왼쪽에서부터 Sk까지 증가하다가, Sk부터 오른쪽으로는 감소하는 수열의 가장 긴 길이를 찾는 문제이다.
  가장 긴 증가하는 부분 수열 구하는 문제에서 아이디어를 얻을 수 있다.
  정확하게는 가장 긴 증가하는 부분 수열을 2번 구하면 된다. 이 때, 기준이 되는 배열은 하나는 정방향, 하나는 역방향이다.
  dp1[i], dp2[i]를 i까지 가장 긴 증가하는 부분 수열의 길이라고 했을 때, dp1은 정방향 배열에서 가장 긴 증가하는 부분 수열을 구한 것이고,
  dp2는 역방향 배열에서 가장 긴 증가하는 부분 수열을 구한 것이므로, 이를 정뱡향 기준으로 다시 표현하면
  정방향 배열의 인덱스 기준 N - i - 1부터 감소하는 부분 수열 중 가장 긴 길이를 저장한 값이다. 
  따라서 특정 위치 i를 기준으로 했을 때, 가장 긴 바이토닉 부분 수열은 dp1[i] + dp2[N - i - 1] - 1의 최댓값이다.
  1을 빼주는 이유는 현재 위치인 자기 자신이 한 번 중복되므로 빼주는 것이다.
*/

import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A1 = new int[N];
        int[] A2 = new int[N];
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A1[i] = Integer.parseInt(st.nextToken());
            A2[N - i - 1] = A1[i];
        }

        for (int i=0; i<N; i++) {
            dp1[i] = 1;
            dp2[i] = 1;
            for (int j=0; j<i; j++) {
                if (A1[i] > A1[j]) { // 증가하는 부분 수열(순방향)
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                } if (A2[i] > A2[j]) { // 증가하는 부분 수열(역방향)
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i=0; i<N; i++) {
            ans = Math.max(ans, dp1[i] + dp2[N - i - 1]);
        }
        
        System.out.println(ans - 1); // 자기 자신이 중복이므로 1을 빼줌

    }
}
