// 스네이크버드(16435번)
/////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/16435
  // 그리디, 정렬
  // 딱히 그리디라는 생각은 안 들었고, 정렬 문제였다.
  // 과일을 오름차순 정렬하여, 자기보다 작거나 같은 과일이면 현재 길이 L++을 하다가 큰 것이 나오면 break하고 출력하면 된다.
  // VScode에 요즘 자바가 에러가 많이 나는 듯하다. 분명히 java.util과 java.io를 전부 임포트했는데도
  // 내림차순 한번 연습하려고 Collections클래스를 부르려는데 자꾸 클래스가 임포트 되지 않았다는 에러가 발생하였다.
  // 터미널을 완전히 끄고 VSCode도 다시 껐다 키니까 정상적으로 작동하였다.
/////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] tmp = br.readLine().split(" "); 
    int N = Integer.parseInt(tmp[0]);
    int L = Integer.parseInt(tmp[1]);
    String[] arr = br.readLine().split(" ");
    Integer[] fruits = new Integer[N];
    for (int i=0; i<N; i++) {
      fruits[i] = Integer.parseInt(arr[i]+"");
    }
    Arrays.sort(fruits);
    for (int i=0; i<N; i++) {
      if (fruits[i] > L) {
        break;
      }
      L++;
    }
    System.out.println(L);
  }
}
