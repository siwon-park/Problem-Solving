// 주몽(1940번)
////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1940
  // 투 포인터, 정렬
  // 배열을 정렬한 뒤에, 0번 인덱스와 마지막 인덱스를 기준으로 투 포인터를 돌려서
  // 합이 M이 되는 경우 cnt +=1 을 해주면 된다.
////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    String[] lst = br.readLine().split(" ");

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(lst[i]);
    }
    Arrays.sort(arr);

    int cnt = 0;
    int s = 0;
    int e = N - 1;
    while (s < e) {
      int total = arr[s] + arr[e];
      if (total == M) {
        cnt++;
        s++;
      } else if (total < M) {
        s++ ;
      } else {
        e--;
      }
    }
    System.out.println(cnt);
    br.close();
  }
}
