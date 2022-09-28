// 사과나무(20002번)
/////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/20002
  // 누적합, 브루트포스
  // 파이썬으로 먼저 풀고 java로 옮긴 풀이
  // 역시 java가 python보다 빠르긴 빠르다.
  // 크게 궁금한 것은 없었고, INF를 선언함에 있어서 long형의 최댓값을 사용하고 싶었는데
  // 숫자할당으로 넣어주려니까 Integer형의 최대치를 초과했다고 떠서
  // 찾아보니 Long.MAX_VALUE가 있어서 이를 사용하였다. 직접 할당으로는 내가 원하는 만큼 최댓값을 줄 수 없나보다...
  // 1000억을 직접 할당하려했는데 분명히 Long의 최대치가 2^63 - 1으로 훨씬 클 텐데 생각처럼 되지 않았다.
/////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long findRangeSum(int r2, int c2) {
        long maxRangeSum = -INF;

        for (int k=1; k<N+1; k++) {
            int r1 = r2 - k;
            int c1 = c2 - k;
            if (0 <= r1 && r1 < N && 0 <= c1 & c1 < N) {
                long rangeSum = prefixArr[r2][c2] - prefixArr[r2][c1] - prefixArr[r1][c2] + prefixArr[r1][c1];
                maxRangeSum = Math.max(maxRangeSum, rangeSum);
            }
        }

        return maxRangeSum;
    }

    static long INF = Long.MAX_VALUE; // 숫자 할당으로 줄 수 있는 최댓값은 몇?
    static int N;
    static int[][] arr;
    static long[][] prefixArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        prefixArr = new long[N + 1][N + 1];

        for (int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i=1; i<N+1; i++) {
            for (int j=1; j<N+1; j++) {
                prefixArr[i][j] = prefixArr[i - 1][j] + prefixArr[i][j - 1] - prefixArr[i - 1][j - 1] + arr[i - 1][j - 1];
            }
        }

        long ans = -INF;
        for (int r=1; r<N+1; r++) {
            for (int c=1; c<N+1; c++) {
                long tmpAns = findRangeSum(r, c);
                ans = Math.max(ans, tmpAns);
            }
        }

        System.out.println(ans);
        br.close();
    }
}
