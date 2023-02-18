// 가르침(1062번)
/////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1062
  // 백트랙킹
  // 자바로 처음 푼 골드 문제이다. + 처음 구현해본 백트랙킹 조합 문제이다.
  // 여러 가지를 깨달았다.
  // 1. 함수 안에서 외생변수를 통해 호출을 중단하고자 한다면, 해당 변수를 static으로 선언해야한다.
  // 2. 풀고나서 깨달은 건데 LinkedList에 removeLast라는 게 있어 다음에 사용하면 더 편리하게 해결할 수 있을 듯 하다.
  // 3. Wrapper 클래스 형으로 배열을 초기화했을 시 안에 들어있는 기본 값은 null이다.
  // 4. set.toArray(new Integer[0]);와 같이 Set형을 배열로 바꿀 수 있다. 이때 new Integer[0]로 선언하면 크기를 자동으로 할당해 준다.
  // 5. 배열을 set으로 돌리는 방법은 Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr)); 와 같이 쓰면 된다.
  // 엄청 효율적인 풀이는 아니지만, 그래도 자바 실력에 비해 큰 난이도의 문제를 풀 수 있어서 뿌듯하다.
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int K;
  static int[][] strArr;
  static Integer[] arr;
  static int R;
  static int maxCnt = 0; 
  // 집합 구현
  static void DFS(int k, int s, boolean[] countArr){
    if (k == R) {
      int tmpCnt = N;
      for (int n=0; n<N; n++) {
        for (int idx=0; idx<26; idx++) {
          if (strArr[n][idx] == 1 && countArr[idx] == true) {
            continue;
          } else if (strArr[n][idx] == 1 && countArr[idx] == false) {
            tmpCnt -= 1;
            break;
          }
        }
      }
      maxCnt = Math.max(maxCnt, tmpCnt);
      // System.out.println(Arrays.toString(countArr));
      // System.out.println(maxCnt);
      return;
    }
    for (int i=s; i<arr.length; i++) {
      countArr[arr[i]] = true;
      DFS(k+1, i+1, countArr);
      countArr[arr[i]] = false;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    String[] tmpArr = new String[N];
    for (int i=0; i<N; i++) {
      tmpArr[i] = br.readLine();
    }
    if (K < 5) {
      System.out.println(0);
    } else {
      HashSet<Integer> set = new HashSet<Integer>();
      strArr = new int[N][26];
      for (int i=0; i<N; i++) {
        String S = tmpArr[i];
        for (int j=0; j<S.length(); j++) {
          if (S.charAt(j) == 'a' || S.charAt(j) == 'n' || S.charAt(j) == 't' || S.charAt(j) == 'i' || S.charAt(j) == 'c') {
            continue;
          }
          set.add(S.charAt(j)-97);
          strArr[i][S.charAt(j)-97] = 1;
        }
      }
      arr = set.toArray(new Integer[0]);
      boolean[] count = new boolean[26];
      R = (K-5 > arr.length) ? arr.length: K-5;
      DFS(0, 0, count);
      System.out.println(maxCnt);
    }
  }
}
