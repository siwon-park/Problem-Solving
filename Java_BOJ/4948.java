// 베르트랑 공준(4948번)
/////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/4948
  // 수학, 에라토스테네스의 체
  // 자바에서 에라토스테네스의 체를 구현할 때, true/false 설정이 긴가민가 했다.
  // boolean 배열을 선언했을 때, 디폴트값이 false이므로, 소수가 아닌 애들을 true 체크한다.(크게 상관은 없지만, 파이썬에서 주로 구현할 땐 반대로 하니까 유의해야겠다.)
/////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] arr = new boolean[123456*2+1];
        arr[0] = true;
        arr[1] = true;
        for (int i=2; i<123457; i++) {
            if (!arr[i]) {
                int j = 2;
                while (i*j < 123456*2+1) {
                    arr[i*j] = true;
                    j += 1;
                }
            }
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int cnt = 0;
            for (int i=n+1; i<2*n+1; i++) {
                if (!arr[i]) {
                    cnt += 1;
                }
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
