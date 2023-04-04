import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[14];
        for (int i = 0; i < 14; i++) arr[i] = Integer.parseInt(st.nextToken());

        int jh = N; // 준현이의 현금
        int jhCnt = 0; // 준현이의 주식수
        int sm = N; // 성민이의 현금
        int smCnt = 0; // 성민이의 주식수

        // 준현이의 주식 구매 => 살 수 있으면 전량 구매 후 기도 메타
        for (int i = 0; i < 14; i++) {
            jhCnt += jh / arr[i];
            jh -= (jh / arr[i]) * arr[i];
        }

        // 성민이의 주식 구매 => 연속 3일 간의 결과에 따라 구매 메타가 다름
        int ascStreak = 0; // 연속 오른 횟수
        int descStreak = 0; // 연속 감소한 횟수
        int last = arr[0]; // 마지막
        for (int i = 0; i < 14; i++) {
            if (descStreak >= 3) { // 3일 연속 감소세이면 현재의 주식을 전량 구매
                smCnt += sm / arr[i];
                sm -= (sm / arr[i]) * arr[i];
            } else if (ascStreak >= 3) { // 3일 연속 상승세면 현재의 주식을 모두 판매
                sm += smCnt * arr[i];
                smCnt = 0;
            }

            if (last < arr[i]) { // 전날보다 크면 연속 오름 횟수를 증가
                ascStreak += 1;
                descStreak = 1;
            } else if (last > arr[i]) { // 전날보다 작으면 연속 감소 횟수 증가
                descStreak += 1;
                ascStreak = 1;
            }
            last = arr[i];
        }

        jh += jhCnt * arr[13];
        sm += smCnt * arr[13];

        String ret = (jh == sm) ? "SAMESAME" : (jh > sm) ? "BNP" : "TIMING";
        System.out.println(ret);
    }
}