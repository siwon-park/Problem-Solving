// 수들의 합(1789번)
/////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1789
  // 수학, 그리디
  // 다 풀고 욕나왔다. 진짜 다 해놓고 sqrtN을 int형으로 변환했기 때문에 틀렸다. long으로 변환해주니 맞았음
  // 제곱근을 사용한 논리는 n(n+1)/2 <= s로 가정하고, n(n+1) <= 2*s에서 n(n+1) <= 2*s가 되는 n의 최댓값을 찾으려고 하였음
/////////////////////////////////////////////////////
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long sqrtN = (long) Math.sqrt(N*2);
        while (sqrtN*sqrtN + sqrtN > N*2) {
            sqrtN -= 1;
        }
        System.out.println(sqrtN);
    }
}
