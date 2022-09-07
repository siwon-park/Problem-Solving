// Maximum Subarray(10211번)
///////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10211
  // DP
  // 다 풀어놓고 출력에서 틀리고 있었다.
  // bw.write(ans +"\n")을 해줘야 한 칸 씩 아래로 띄우면서 쓰는데
  // 이어서 붙여놓고 출력하고 있었다.
  // 이전까지 더해온 값과 현재 값을 더했을 때와 현재 값 중 큰 값을 현재까지의 최대합으로 하여 DP를 계산해준다.
///////////////////////////////////////////////////////////////////
import java.io.*;
import static java.lang.Integer.parseInt;

public class Main {
    static int T;
    static int N;
    static int[] arr;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = parseInt(br.readLine());
        for (int tc=0; tc<T; tc++) {
            N = parseInt(br.readLine());
            arr = new int[N];
            int[] memo = new int[N];
            String[] tmp = br.readLine().split(" ");

            for (int i=0; i<N; i++) {
                arr[i] = parseInt(tmp[i]);
            }
            memo[0] = arr[0];
            ans = memo[0];

            for (int i=1; i<N; i++) {
                memo[i] = arr[i];
                memo[i] = Math.max(memo[i - 1] + arr[i], memo[i]);
                ans = Math.max(ans, memo[i]);
            }
            bw.write(ans +"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
