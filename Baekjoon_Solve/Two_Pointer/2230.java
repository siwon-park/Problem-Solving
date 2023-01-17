// 수 고르기 (2230번)
/*
  문제: https://www.acmicpc.net/problem/2230
  투 포인터, 이분탐색
  투 포인터로 푸는 방법은 해설이 따로 필요 없을 것 같아서 생략하고, 이분탐색으로 풀 수 있는 방법을 소개한다.
  두 수의 차이가 M 이상이므로, A1 - A2 >= M이고, 배열에서 A1 >= A2 + M 을 만족하는 가장 작은 M을 찾으면 된다.
  lower bound로 A[i]에 대해 A[i] + M를 넣을 수 있는 가장 작은 인덱스를 찾고, 해당 위치에 있는 수와의 차이를 구한다.
  이 차이의 최솟값이 우리가 찾고자하는 답이다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int e = 0;
        int s = 0;
        int ans = 2_000_000_001;
        while (s < N && e < N) {
            int diff = Math.abs(arr[e] - arr[s]);
            if (diff >= M) {
                ans = Math.min(ans, diff);
                s += 1;
            } else if (diff < M) {
                e += 1;
            }
        }

        System.out.println(ans);

    }
}
