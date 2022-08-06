//오르막길(2846번)
///////////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/2846
    // 구현
    // 쉬운 문제였는데, 코드를 짜다가 갑자기 고민했다... 다음부터는 조금 더 로직을 스케치하고 들어가야겠다.
    // 현재(i)높이가 이전(i-1)높이보다 높으면, 현재 높이에서 최소 높이(minInc)를 뺀 값이 최대 높이(maxInc)보다 높으면 최대 높이를 갱신한다.
    // 만약 현재 높이가 이전 높이보다 작거나 같으면 오르막이 아니므로 해당 높이를 현재의 최소 높이로 갱신해준다.
///////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            int inc = sc.nextInt();
            arr[i] = inc;
        }
        int minInc = arr[0];
        int maxInc = 0;
        for (int i=1; i<N; i++) {
            if (arr[i] > arr[i-1]) {
                if ((arr[i] - minInc) > maxInc) {
                    maxInc = arr[i]-minInc;
                }
            } else {
                minInc = arr[i];
            }
        }
        System.out.println(maxInc);
    }
}
