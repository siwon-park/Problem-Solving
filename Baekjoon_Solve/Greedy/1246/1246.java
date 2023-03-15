import java.io.*;
import java.util.*;


public class Main {

    static int minPrice, maxProfit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 달걀의 수
        int M = Integer.parseInt(st.nextToken()); // 고객의 수

        int[] C = new int[M];
        for (int i = 0; i < M; i++) C[i] = Integer.parseInt(br.readLine());

        // 정렬
        Arrays.sort(C);
        minPrice = maxProfit = 0;
        for (int i = 0; i < M; i++) {
            int curPrice = C[i]; // 현재 계란 가격
            int cnt = M - i; // 현재 가격 이상인 계란의 수
            int n = Math.min(cnt, N); // 팔 수 있는 계란의 최대 수
            if (curPrice * n > maxProfit) { // 최소 가격과 최대 이익을 갱신
                maxProfit = curPrice * n;
                minPrice = curPrice;
            }
        }

        System.out.println(minPrice + " " + maxProfit);
    }
}