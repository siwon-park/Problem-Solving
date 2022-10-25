// 과자 나눠주기 (16401번)
///////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/16401
  // 이분 탐색, 매개변수 탐색
  // 다 풀어놓고 2번이나 시간초과를 받았다.(로직은 이상이 없다)
  // 그 이유는 첫 번째, 자바 입력 형태 때문이었다. 문자열로 배열을 읽어 온 다음에 long형 배열에 숫자값을 넣어서 시간이 많이 걸리는 형태였다.
  // 두 번째, 정렬을 하지말고 최댓값만 찾아야했는데 정렬을 하였다. 근데 이건 엄청 큰 이유는 아니었고 효율적인 풀이를 위해 굳이 정렬을 할 필요가 없었던 것 뿐이다.
  // 세 번째는 그냥 의심가는 것인데 10^9가 int형을 초과하는 줄 알고 long형으로 선언했다.
  // 로직에는 문제가 없었는데 어떤 부분에서 얼마나 시간을 낭비했는지 정확한 포인트는 모르겠다...
///////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int binarySearch() {
        int opt = 0;
        int s = 1; // 막대 과자의 가장 작은 길이(0으로 하면 ArithmeticException 발생할 수 있음)
        int e = MAX;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            for (int i=0; i<N; i++) {
                cnt += snacks[i] / mid;
            }
            if (cnt >= M) { // cnt가 조카 수보다 크거나 같으면 과자 길이를 늘려서 탐색
                opt = mid;
                s = mid + 1;
            } else { // 조카 수보다 작으면 과자 길이를 줄여서 탐색
                e = mid - 1;
            }
        }
        return opt;
    }

    static int N;
    static int M;
    static int[] snacks;
    static int MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st1.nextToken());
        N = Integer.parseInt(st1.nextToken());
        snacks = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            snacks[i] = Integer.parseInt(st2.nextToken());
            MAX = Math.max(MAX, snacks[i]);
        }

        int ret = binarySearch();
        System.out.println(ret);
        br.close();
    }
}
