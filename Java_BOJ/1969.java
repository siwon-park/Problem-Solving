// DNA(1969번)
/////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1969
  // 문자열, 구현, 브루트포스(완전탐색)
  // 풀이 로직은 완전탐색으로 각 문자열의 동일 인덱스에서 가장 많이 있는 문자열을 고르되, 사전순으로 빠른 것을 골라야함
  // 그렇게 되었을 때, HammingDistance는 N - 최다 등장횟수의 누적값임
  // 왜냐하면 최다 등장 문자열을 골랐으니 해당 인덱스에서 (N - 최다 등장횟수)는 고르지 않은 것이기 때문
  // 처음에 자바로 풀다가 문제를 잘못 이해해서 시간만 소비하고 파이썬으로 풀고나서 자바로 다시 품
  // 쉬운 문제에 대해 파이썬으로 풀고나서 자바로 한번 더 풀어보는 것도 자바에 대해 좀 더 익숙해 질 수 있는 방법이라고 생각함
/////////////////////////////////////////////////////////////////////////////
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] tmp = br.readLine().split(" ");
    int N = Integer.parseInt(tmp[0]);
    int M = Integer.parseInt(tmp[1]);

    String[] lst = new String[N];
    for (int i=0; i<N; i++) {
      lst[i] = br.readLine();
    }

    String ret = "";
    int min_HD = 0;
    for (int i=0; i<M; i++) {
      int[] count = new int[26]; // 알파벳의 인덱스에 해당하는 위치에 나온 횟수를 기록함
      for (int j=0; j<N; j++) {
        int idx = lst[j].charAt(i);
        idx -= 65;
        count[idx] += 1;
      }
      int max_cnt = 0; // count 배열의 최댓값 체크
      String add_str = ""; // ret에 더할 문자열
      for (int k=25; k>-1; k--) {
        if (count[k] >= max_cnt) { // max_cnt값을 갱신하면서 ret에 더할 문자열도 갱신함
          max_cnt = count[k];
          add_str = (char)(k + 65)+"";
        }
      }
      ret += add_str;
      min_HD += N - max_cnt; // HammingDistance는 N - 최다 등장횟수의 누적값임
    }
    System.out.println(ret);
    System.out.println(min_HD);
    br.close();
  }  
}
