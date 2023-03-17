import java.io.*;
import java.util.*;


public class Main {

    /*
    * 이분탐색하여 음식을 만들 수 있는 최소 시간을 반환
    * */
    static long binarySearch(int[] arr) {
        long minTime = MAX;
        long s = K / N; // 최소 완성 시간(1이 N개 있을 때, K / N)
        long e = MAX; // 최대 완성 시간
        while (s <= e) {
            long mid = (s + e) / 2L; // mid 시간으로 K개의 음식을 만들 수 있는지 확인
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += mid / arr[i]; // mid 시간으로 개당 arr[i]의 시간으로 음식을 만들 때 만들 수 있는 음식의 개수
            }
            if (cnt >= K) { // 만들 수 있는 음식의 개수가 K 이상이면 탐색 범위를 줄여서 탐색
                e = mid - 1;
                minTime = mid;
            } else {
                s = mid + 1;
            }
        }
        return minTime;
    }

    /*
    * 백트래킹으로 중복조합을 구성하여 이분탐색 실시
    * */
    static void backtrack(int c) {
        if (c == C) {
            long mt = binarySearch(arr);
            ans = Math.min(ans, mt);
            return;
        }
        boolean flag = false; // 더 이상 칭찬할 수 없음
        for (int i = 0; i < N; i++) {
            if (arr[i] > 1) {
                arr[i] -= 1;
                flag = true;
                backtrack(c + 1);
                arr[i] += 1;
            }
        }
        if (!flag) { // 더이상 칭찬할 수 없어도 이분 탐색 시작
            long mt = binarySearch(arr);
            ans = Math.min(ans, mt);
        }
    }

    static int N, K, C; // 요리사의 수, 음식의 개수, 격려 가능 횟수
    static long MAX = Integer.MAX_VALUE;
    static long ans;
    static int[] arr; // 요리사가 음식을 만드는데 걸리는 시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            MAX = Math.min(MAX, arr[i]);
        }
        MAX *= K; // 음식을 만드는 최대 시간(arr의 최소 시간 x K개)
        ans = MAX;

        backtrack(0);
        System.out.println(ans);
    }
}