// 세탁소 사장 동혁(2720번)
//////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2720
  // 그리디
  // 센트 단위여서 실수형을 사용해야 하나 싶었는데 어차피 거스름돈을 다 구성할 수 있고
  // 입력으로 들어오는 값도 예를 들어 5달러면 500으로 들어오므로 거스름돈을 구성하는 잔돈에도 100을 곱해줘서 계산하였다.
//////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Integer[] QDNP = new Integer[4];
    QDNP[0] = 25;
    QDNP[1] = 10;
    QDNP[2] = 5;
    QDNP[3] = 1;
    int T = Integer.parseInt(br.readLine());
    for (int tc=0; tc<T; tc++) {
      int C = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      for (int i=0; i<4; i++) {
        sb.append(C/QDNP[i]+" ");
        C = C % QDNP[i];
      }
      bw.write(sb.toString());
      bw.write("\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
