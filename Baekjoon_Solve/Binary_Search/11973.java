// Angry Cows (Silver) (11973번)
//////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/11973
  // 이분 탐색
  // 문제를 풀긴 풀었는데, 도저히 이해가 안 간다. 왜 cnt = 1, curRange = x[0] + 2 * mid로 잡고 1부터 N-1까지 이분탐색을 하는 것은 틀리고
  // cnt = 0부터 curRange = 0으로 잡고 0부터 N-1까지 이분탐색을 하는 것은 올바른 해답인지 이해가 안 간다.
  // 이해가 안 돼서 대회 테스트 케이스를 돌려봤는데도 다 맞는데 왜 틀렸는지 모르겠다.
//////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int binarySearch(int s, int e) {
        int R = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            int curRange = 0; // 제일 처음은 해당 위치를 맞추니까 범위는 0이라 가정
            for (int i=0; i<N; i++) {
                if (x[i] > curRange) {
                    cnt += 1;
                    curRange = x[i] + 2 * mid;
                }
            }
//            System.out.println(mid + " " + cnt);
            if (cnt <= K) {
                e = mid - 1;
                R = mid;
            } else {
                s = mid + 1;
            }
        }
        return R;
    }

    static int N;
    static int K;
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        x = new int[N];
        int e = 0;
        for (int i=0; i<N; i++) {
            x[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, x[i]);
        }

        Arrays.sort(x);
        int ret = binarySearch(0, e);
        System.out.println(ret);
        br.close();
    }
}
