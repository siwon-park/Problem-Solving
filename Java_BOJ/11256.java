// 사탕(11256번)
/////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/11256
  // 그리디
  // 입력으로 주어진 R*C를 arr에 담은 뒤 내림차순 정렬하고
  // J에서 arr[i]를 빼면서 J <= 0이면 break하고, 뺀 횟수 cnt를 출력하면 된다.
/////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc=0; tc<T; tc++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      int J = Integer.parseInt(st1.nextToken());
      int N = Integer.parseInt(st1.nextToken());
      Integer[] arr = new Integer[N];
      for (int i=0; i<N; i++) {
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st2.nextToken());
        int C = Integer.parseInt(st2.nextToken());
        arr[i] = R*C;
      }
      Arrays.sort(arr, Collections.reverseOrder());
      int cnt = 0;
      for (int i=0; i<N; i++) {
        if (J <= 0) {
          break;
        }
        J -= arr[i];
        cnt += 1;
      }
      System.out.println(cnt);
    }
  }
}
