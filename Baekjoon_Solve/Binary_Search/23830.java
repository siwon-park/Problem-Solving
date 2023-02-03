// 제기차기 (23830번)
/*
  문제: https://www.acmicpc.net/problem/23830
  이분탐색
  일반적인 매개변수 탐색 문제이다.
  처음에 예제 답도 안 나와서 보니 조건에 만족하지 않는 경우 A[i]를 더해줘야 했다.
  그리고 나서 제출했는데 틀렸습니다를 받았다.
  그 이유를 자세히보니, 두 번째 조건에서 '점수가 K미만이면' 이라고 했으므로 K가 가질 수 있는 최댓값은
  배열 A의 최댓값 + 1이다. 따라서 e의 초기값은 10만이 아니라 10만 + 1이어야 한다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int binarySearch() {
        int k = -1;
        int s = 1;
        int e = 100001;
        while (s <= e) {
            int mid = (s + e) / 2;
            long sum = 0L;
            for (int i=0; i<N; i++) {
                if (A[i] < mid) {
                    sum += A[i] + q;
                } else if (A[i] > mid + r) {
                    sum += A[i] - p;
                } else {
                    sum += A[i];
                }
            }
            if (sum >= S) {
                e = mid - 1;
                k = mid;
            } else {
                s = mid + 1;
            }
        }
        return k;
    }

    static int N, p, q, r;
    static long S;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        S = Long.parseLong(st.nextToken());

        System.out.println(binarySearch());

    }
}
