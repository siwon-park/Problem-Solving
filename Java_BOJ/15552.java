// 빠른 A + B (15552번)
////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/15552
  // 수학, 구현, 사칙연산
  // 처음으로 BufferedReader를 배워서 사용해보았다.
  // 아직 익숙치 않지만 빨리 숙달해야겠다. try/catch 구문으로 IOException을 처리해줬는데, throws가 더 빠른듯하다.
  // 그리고 코드는 거의 비슷한데, 배열을 사용하는 것보다, 문자열 슬라이싱 및 인덱싱을 통한 계산이 더 빠른듯하다?(실행속도가 더 빨랐음)
  // 근데 더 빠른 건 StringBuilder를 사용하는 것이었다.
////////////////////////////////////////////////////////////////
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            String nums = br.readLine();
            String[] arr = nums.split(" ");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);
            int res = A+B;
            bw.write(res+"\n");
            // bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
