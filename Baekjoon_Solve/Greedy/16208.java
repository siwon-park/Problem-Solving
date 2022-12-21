// 귀찮음 (16208번)
/*
 문제: https://www.acmicpc.net/problem/16208
 그리디
 처음에 분할정복 문제인줄 알았는데, 홀수인 경우에는 잘못 계산하면 최솟값이 아닐 수 있어서
 정렬한 다음, 현재 요소 * (총합 - 현재요소)를 누적해서 결과를 도출했다. 이 때, 총합에서 현재요소를 매번 빼줘야한다. 이미 나눠진 값이니까.
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        long cost = 0L;
        for (int i=0; i<n; i++) {
            cost += arr[i] * (sum - arr[i]);
            sum -= arr[i];

        }
        System.out.println(cost);
    }
}
