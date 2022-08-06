// 서버(10409번)
////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10409
  // 수학, 사칙연산, 구현
  // 합산을 먼저 계산하고, 그 값이 T값 이하인 경우에만 cnt += 1을 하게 하였음. 넘으면 break 구문에 의해 cnt를 +=1하지 않음
////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split(" ");
        int cnt = 0;
        int total = 0;
        for (int i=0; i<n; i++) {
            total += Integer.parseInt(arr[i]);
            if (total > T) {
                 break;
            }
            cnt += 1;
        }
        System.out.println(cnt);
    }
}
