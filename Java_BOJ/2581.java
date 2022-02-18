// 소수(2581번)
/////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2581
  // 수학, 에라토스테네스의 체
  // java boolean 배열의 디폴트 값은 false다라는 것을 배웠다.(당연한 건가?)
  // 그래서 보통 에라토스테네스의 체를 쓸 때는 범위 내의 모든 수는 소수다(true)로 뒀으나, 이번엔 반대로 소수가 아닐 경우 true, 소수일 경우 false로 두었다.
/////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10001];
        arr[0] = true;
        arr[1] = true;
        for (int i=2; i<10001; i++) {
            if (!arr[i]) {
                int j = i;
                while (j*i < 10001) {
                    arr[j*i] = true;
                    j += 1;
                }
            }
        }
        int total = 0;
        int minPrime = 10002;
        for (int m=M; m<N+1; m++) {
            if (!arr[m]) {
                total += m;
                if (m < minPrime) {
                    minPrime = m;
                }
            }
        }
        if (total != 0) {
            bw.write(total+"\n");
            bw.write(minPrime+"\n");
        } else {
            bw.write(-1+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
