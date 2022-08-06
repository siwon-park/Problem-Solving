// 2 + 1 세일(11508번)
///////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/11508
  // 그리디, 정렬
  // 내림차순 정렬한다는 것을 실수로 오름차순 정렬해버렸고, 인덱스를 선택함에 있어서 파이썬보다 자유롭지 못해서
  // 어떻게 처리해야하나 고민하다가 시간을 좀 썼다.
///////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[N];
    for (int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr, Collections.reverseOrder());
    int sum = 0;
    for (int i=0; i<N; i++) {
      sum += arr[i];
      if ((i + 1) % 3 == 0) { // 3개 선택했으면, 현재 값을 하나 뺀다(내림차순 정렬했으므로 현재 값이 큰 값 중에서 가장 작은 값이다.)
        sum -= arr[i];
      }
    }
    System.out.println(sum);
  }
}
