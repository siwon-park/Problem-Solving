import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // a -> 1 또는 2를 입력으로 받아 arr[i] == a이면 -1로 바꾼 다음 구간의 최대 합을 계산하는 함수
    static int solve(int a) {
        int ans = 0;
        int[] dp = new int[N];
        for (int i=0; i<N; i++) { // 연속합의 최댓값을 구함
            dp[i] = (arr[i] == a) ? -1 : 1; // arr[i] == a이면 -1로 바꾸고 그 외에는 1로 함
            if (i - 1 >= 0) {
                dp[i] = Math.max(dp[i], dp[i - 1] + dp[i]); // 현재 값과 이전 값을 더 했을 때, 현재 값보다 크면 갱신
            }
            ans = Math.max(dp[i], ans); // 연속합 중 최댓값을 갱신
        }
        return ans;
    }

    static int N; // 배열의 길이
    static int[] arr; // 1, 2로 이루어진 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ret1 = solve(1); // 1 -> -1, 2 -> 1로 바꿔서 연속합의 최댓값 계산
        int ret2 = solve(2); // 2 -> -1, 1 -> 1로 바꿔서 연속합의 최댓값 계산

        System.out.println(Math.max(ret1, ret2));

    }
}