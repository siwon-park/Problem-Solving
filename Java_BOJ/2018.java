// 수들의 합(2018번)
////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2018
  // 투 포인터
  // 매우 간단한 투 포인터 기본 문제였는데, while문에 넣는 조건을 실수로 잘못 이해해서 넣는 바람에 30분이나 소모했다
  // 단순 실수라기보다는 어느정도 실력인듯하다. 분명 인덱스 에러 등 어딘가 잘못되었는데 캐치를 하지 못했다는 뜻이니까
  // 좀 더 아직 많은 연습이 필요하다고 생각한다.
////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N+1];
    for (int i=0; i<N+1; i++) {
      arr[i] = i;
    }
    int cnt = 0;
    int s = 1;
    int e = 1;
    int sum = 0;
    while (s <= e && s < N+1 && e <= N+1) {
      if (sum < N) {
        sum += arr[e];
        e += 1;
      } else if (sum > N) {
        sum -= arr[s];
        s += 1;
      }
      if (sum == N) {
        cnt += 1;
        sum -= arr[s];
        s += 1;
      }
      // System.out.println("sum: "+sum+" s: "+s+" e: "+e+" cnt: "+cnt);
    }
    System.out.println(cnt);
  }
}
