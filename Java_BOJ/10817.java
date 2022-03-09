// 세 수(10817번)
///////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10817
  // 선택정렬 쓰려다가 잘 안 돼서 왜 안 되는 건지 따지다가 시간을 너무 많이 소비했다.
  // 원본 배열이 문자열 배열이라 새로운 배열을 선언하고 선택 정렬을 시도했는데, 생각해보니 원본 배열에 있는 숫자 문자열의 자리가 바뀌지 않으니
  // 원하는대로 정렬이 되지 않고 있던 것이었다. 바보였다.
  // 그다음에 그냥 숫자 비교를 하려했는데, 숫자가 모두 같은 경우 때문에 생각하기 귀찮아서 그냥 정렬 메서드를 사용했다.
  // 이런 쉬운 문제에선 그냥 정렬 메서드 사용하는게 낫겠다. 뭐 하나 쓰면서 배우려다 오히려 시간만 많이 잡아 먹는 듯하다.
///////////////////////////////////////////////////
import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = br.readLine().split(" ");
    int[] num_arr = new int[3];
    for (int i=0; i<3; i++) {
      num_arr[i] = Integer.parseInt(arr[i]);
    }
    Arrays.sort(num_arr);
    System.out.println(num_arr[1]);
  }
}
