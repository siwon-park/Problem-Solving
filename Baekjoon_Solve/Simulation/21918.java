// 전구 (21918번)
///////////////////////////////////////////////////////////////////////////////////// 
  // 문제: https://www.acmicpc.net/problem/21918
  // 조건에 맞게 구현만 하면 되는 문제이다.
  // 2번째 조건은 삼항 연산자를 사용하였고, 출력은 StringBuilder를 사용하였다.
/////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] L = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            L[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i=0; i<M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            int c = Integer.parseInt(st3.nextToken());
            if (a == 1) {
                L[b - 1] = c;
            } else if (a == 2) {
                for (int j=b-1; j<c; j++) {
                    L[j] = (L[j] == 0) ? 1 : 0;
                }
            } else if (a == 3) {
                for (int j=b-1; j<c; j++) {
                    L[j] = 0;
                }
            } else if (a == 4) {
                for (int j=b-1; j<c; j++) {
                    L[j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(L[0]);
        for (int i=1; i<N; i++) {
            sb.append(" " + L[i]);
        }
        System.out.println(sb);

    }

}
