// 3대 측정(20299번)
/////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/20299
  // 구현
  // 처음에 로직대로 풀었을 때 1%에서 시간초과가 났음.
  // 아마 문자열에 +연산을 하고 마지막에 " "을 출력시키지 않기 위해서 for구문 안에 i가 N-1이 아닐 경우 OO을 하는 if구문을 넣어서 그런게 아닌가 싶음
  // 그래서 다른 사람 풀이를 구글링 해보니까 로직은 똑같고(애초에 이런 간단한 문제에 로직이란게 있을리가 없지만) StringBuilder를 썼다는 차이가 있었다.
  // 그래서 이왕지사 간단하게 StringBuilder와 StringBuffer에 대해 간단하게 정리하였다.
  // 게다가 출력의 마지막에 " "(공백)을 출력해도 큰 상관은 없는 듯하다.
/////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st2.nextToken());
            int x2 = Integer.parseInt(st2.nextToken());
            int x3 = Integer.parseInt(st2.nextToken());
            if (x1 >= L && x2 >= L && x3 >= L && x1 + x2 + x3 >= K) {
                cnt += 1;
                sb.append(x1).append(" ").append(x2).append(" ").append(x3).append(" ");
            }
        }
        br.close();
        System.out.println(cnt);
        System.out.println(sb.toString());   
    }
}
