// 코스튬 파티 (6159번)
/*
  문제: https://www.acmicpc.net/problem/6159
  브루트포스
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int ans = 0;
        for (int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                if (arr[i] + arr[j] > S) {
                    break;
                }
                ans++;
            }
        }

        System.out.println(ans);

    }
}
