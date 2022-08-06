// 세로읽기(10798번)
/////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10798
  // 문자열, 구현
  // 자바 배열은 처음부터 크기를 고정하고 시작해서 어쩌면 조금 편했는지도 모르겠다.
  // String 배열의 초기값은 null타입이고, ==을 통해 비교 연산이 가능하다.
/////////////////////////////////////////////////////////////
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[][] arr = new String[5][15];
    for (int i=0; i<5; i++) {
      String s = br.readLine();
      int N = s.length();
      for (int j=0; j<N; j++) {
        arr[i][j] = s.charAt(j)+"";
      }
    }
    String ret = "";
    for (int j=0; j<15; j++) {
      for (int i=0; i<5; i++) {
        if (arr[i][j] == null) {
          continue;
        }
        else {
          ret += arr[i][j];
        }
      }
    }
    System.out.println(ret);
    br.close();
  }
}
