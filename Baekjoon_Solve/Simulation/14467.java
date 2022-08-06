// 소가 길을 건너간 이유1 (14467번)
////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/14467
  // 구현
  // 문제를 잘못 이해해서 여러 번 틀렸음
  // 소가 길을 건넜다는 것을 0번 위치와 1번 위치에서 몇번 발견됬는지에 따라 확인하려 했고, 배열 [0,0]을 통해 확인하려 했음
  // 0번 위치이면 0번 인덱스에 해당하는 값 +=1, 1번 위치이면 1번 인덱스에 해당하는 값 +=1을 하였음
  // 그리고 그 값의 min값을 취한 것이 소가 건넌 횟수라고 '이해'했으나,
  // 사실은 그게 아니었고, '마지막으로 발견된 위치와 현재 발견된 위치가 다르면 1번 건넌 것'이다가 문제에서 말하는 건넜다의 의미였음
  // 문제를 잘 읽는 것도 중요하지만, 잘 이해하는 것도 정말 중요하다.
////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        int cnt = 0;
        for (int i=1; i<11; i++) {
            arr[i]=-1;
        }
        for (int i=0; i<N; i++) {
            String s1 = br.readLine();
            StringTokenizer st = new StringTokenizer(s1);
            int cowNum = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            if (arr[cowNum] < 0) {
                arr[cowNum] = pos;
            } else if (arr[cowNum] != pos) {
                cnt += 1;
                arr[cowNum] = pos;
            }
        }
        br.close();
        System.out.println(cnt);
    }
}
