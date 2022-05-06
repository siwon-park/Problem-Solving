// 알고리즘 수업 - 선택 정렬 1 (23881번)
/////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/23881
  // 구현
  // 점점 많은 부분을 활용해 나가고 있다.
  // 선택 정렬에 대한 구현 문제
  // 이 시리즈를 자바로 풀면서 자바 알고리즘 기초를 익혀야겠다.
/////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

class Pair {
  int first;
  int second;
  Pair() {
    this.first = 0;
    this.second = 0;
  }
  Pair(int x, int y) {
    this.first = x;
    this.second = y;
  }
}

public class Main {
  static int swithCnt = 0;
  static int N;
  static int K;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    String[] arr = br.readLine().split(" ");
    int[] A = new int[N];
    Pair[] pairs = new Pair[N+1];
    for (int i=0; i<N; i++) {
      A[i] = Integer.parseInt(arr[i]+"");
    }
    for (int i=N-1; i>0; i--) {
      int last = i;
      for (int j=i-1; j>-1; j--) {
        if (A[last] < A[j]) {
          last = j;
        }
      }
      if (last != i) {
        int tmp = A[i];
        A[i] = A[last];
        A[last] = tmp;
        swithCnt += 1;
        pairs[swithCnt] = new Pair(A[last], A[i]);
      }
    }
    if (swithCnt < K) {
      System.out.println(-1);
    } else {
      System.out.println(pairs[K].first + " " + pairs[K].second);
    }
  }
}
