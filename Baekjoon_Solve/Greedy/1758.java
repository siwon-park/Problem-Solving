// 알바생 강호(1758번)
////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1758
  // 그리디 알고리즘, 정렬
  // 문제 자체는 쉬웠는데, 자바를 잘 다룰 줄 몰라서 조금 헤맸다.
  // 1. 정수형 배열의 내림차순은 기본타입인 int형이 아니라 Integer형으로 선언해야한다.
  // 2. N과 거스름돈의 크기가 최대 10만이므로 int의 범위를 벗어날 수 있다. 따라서 long으로 선언해야한다.
////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[N]; // 배열 내림차순 정렬을 하려면 int가 아니라 Integer형으로 선언
    for (int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr, Collections.reverseOrder());
    long max_tip = 0; // N과 거스름돈의 최대 크기가 10만이므로 int범위를 벗어날 수도 있음
    for (int i=0; i<N; i++) {
      if (arr[i] - i <= 0) {
        break;
      }
      max_tip += (arr[i] - i);
    }
    System.out.println(max_tip);
  }
}
