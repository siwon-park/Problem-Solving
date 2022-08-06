// 서강근육맨(20300번)
/////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/20300
  // 그리디, 정렬
  // 정렬한 뒤에 N이 짝수냐 홀수냐에 따라 분기를 달리하여 그리디하게 합을 선택했다.
  // N이 홀수면 제일 끝에 있는 숫자를 빼고 짝수 개를 맞춰서 진행한다.
  // N이 짝수면 2개씩 짝을 이룰 수 있으므로 제일 첫 인덱스와 제일 끝 인덱스에서 출발해서 가운데로 2개씩 골라서 합을 구하면 된다.
  // M의 초기값은 홀수든 짝수든 가장 마지막 인덱스에 있는 값으로 초기화한다.
  // t값의 범위가 10^18 이하이므로 Long형으로 선언해야함을 유의한다.
/////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] tmp = br.readLine().split(" ");
    Long [] arr = new Long[N];
    for (int i=0; i<N; i++) {
      arr[i] = Long.parseLong(tmp[i]+"");
    }
    Arrays.sort(arr);
    int n = (N % 2 == 0) ? N : N - 1;
    Long M = arr[N-1];
    for (int i=0; i<n/2; i++) {
      Long tmp_M = arr[i] + arr[n - 1 - i];
      if (tmp_M > M ) {
        M = tmp_M;
      }
    }
    System.out.println(M);
  }
}
