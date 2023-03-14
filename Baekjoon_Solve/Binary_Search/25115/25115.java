import java.io.*;
import java.util.*;


public class Main {

    static long binarySearch() {
        long s = 1L;
        long e = MAX;
        long ans = 0L;
        while (s <= e) {
            long mid = (s + e) / 2L;
            boolean flag = true; // 물건을 순서대로 다 살 수 있는지 여부
            long budget = mid;
            long c = 0L; // 현재 캐시 포인트
            for (int i = 0; i < N; i++) {
                if (budget + (c / 10) < P[i]) { // 현금 + 캐시백으로 구매 불가능하면 false
                    flag = false;
                    break;
                }
                if (budget >= P[i]) { // 현금 우선 구매(주어진 현금으로만 구매 가능한 경우)
                    budget -= P[i]; // 상품을 구매
                    c += P[i]; // 캐시 포인트 증가(사용할 때, 누적된 값의 10%를 활용)
                } else {
                    // 일단 주어진 예산은 다 씀
                    long p = P[i] - budget; // 주어진 예산을 다 쓰고 남은 지불 가격
                    c += budget; // 현금 지불 가격을 더 함
                    c -= p * 10; // p의 10배를 뺌
                    budget = 0;
                }
            }

            if (flag) { // 물건을 순서대로 다 살 수 있으면 금액을 줄임
                e = mid - 1;
                ans = mid;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    static int N;
    static long MAX; // 필요한 최대 현금
    static int[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        P = new int[N];
        MAX = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            MAX += P[i];
        }

        long ans = binarySearch();
        System.out.println(ans);
    }
}