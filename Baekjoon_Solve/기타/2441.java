// 별찍기 - 4(2441번)
///////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2441
  // 구현
  // StringBuffer로 풀어보자까진 생각했는데, 어떻게 이렇게 출력을 해야하나 아주 잠깐 고민했는데, 생각해보니
  // for문 안에서 for문을 2번 돌리는 방법밖에 없겠다 싶어서 이렇게 구현하였다.
  // 그냥 평균적일 것이라 생각했는데 124m/s로 빠르게 동작하는 알고리즘을 완성하였다.
  // 문제 풀기 전에는 br.close();하자고 생각했는데 지금보니까 안 했다. 다음부턴 신경써야지...
///////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                sb.append(" ");
            }
            for (int j=i; j<N; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
