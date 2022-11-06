// 파닭파닭 (14627번)
//////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/14627
  // 이분탐색, 매개변수 탐색
  // int형과 long형 때문에 여러 번 틀렸습니다를 받았다. 최대 탐색 범위가 10억 이하라서 오버플로우가 발생하지 않을 줄 알았는데,
  // 생각해보니, '남은 파의 양'을 구하는 것이므로 구매한 파의 총 합의 최대는 10^9 * 10 ^ 6으로 int형을 초과하고, 이에 따라
  // 남은 파의 양도 int형을 초과할 수도 있다.
  // 따라서, s, e, mid, left(결과값)을 모두 long형으로 바꿔주니 통과할 수 있었다.
  // 또한 문제가 최적값을 찾는 매개변수 탐색 같다고 해서 매번 for 구문 안에서 계산하여 조건을 따지려고 하지 말고
  // 이 문제처럼 그냥 최적 mid 값을 찾고, 마지막에 한 번만 계산할 수 있는 경우도 있다는 것을 잊지 말아야겠다.
//////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long binarySearch() {
        long s = 1; // s가 0이면 0으로 나누게되는 예외 발생
        long opt = 0;
        while (s <= e) {
            long mid = (s + e) / 2;
            int cnt = 0; // 파닭의 수
            for (int i=0; i<S; i++) {
                cnt += arr[i] / mid;
            }
            if (cnt >= C) {
                s = mid + 1;
                opt = mid;
            } else {
                e = mid - 1;
            }

        }

        return SUM - C * opt; // 매개변수 탐색 같다고 해서 매번 for 구문에서 구하려고 하지말고, 한번에 원하는 값을 찾을 수도 있다.
    }

    static int S; // 파의 개수
    static int C; // 파닭의 수
    static int[] arr;
    static long e = 0;
    static long SUM = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[S];

        for (int i=0; i<S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, arr[i]);
            SUM += arr[i];
        }

        long ret = binarySearch();
        System.out.println(ret);
        br.close();
    }
}
