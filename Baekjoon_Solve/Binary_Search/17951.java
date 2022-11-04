// 흩날리는 시험지 속에서 내 평점이 느껴진거야(17951번)
//////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/17951
  // 이분 탐색, 매개 변수 탐색
  // 찾아야하는 값은 K개의 그룹으로 나눴을 때, 그룹의 최솟값 중 가장 큰 값이다.
  // s = 0, e = 배열의 총합으로 두고, mid를 우리가 찾아야할 값으로 선정한 다음에,
  // 배열의 누적합을 구하면서, mid와 크거나 같으면 그룹 수를 += 1 해준다.
  // 만약 그룹 수가 K개 이상이면, K개의 그룹을 만들 수도 있고, 최적값은 mid가 된다.
//////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int binarySearch() {
        int opt = 0;
        int s = 0;
        int e = SUM;
        while (s <= e) {
            int mid = (s + e) / 2;

            int cnt = 0;
            int cur = 0;

            for (int i=0; i<N; i++) {
                cur += arr[i];
                if (cur >= mid) { // 현재 합이 mid를 넘으면 그룹의 수를 += 1
                    cnt += 1;
                    cur = 0;
                }
            }

            if (cnt >= K) { // 그룹 수가 K 이상이더라도, K개를 만들 수 있고 그 때의 최적값은 mid이다.
                opt = mid;
                s = mid + 1;
            } else if (cnt < K) {
                e = mid - 1;
            }
        }

        return opt;
    }

    static int N;
    static int K;
    static int[] arr;
    static int SUM = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        String[] tmp = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
            SUM += arr[i];
        }

        int ret = binarySearch();
        System.out.println(ret);
        br.close();
    }
}
