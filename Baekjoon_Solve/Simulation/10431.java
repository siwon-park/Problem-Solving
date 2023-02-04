// 줄 세우기 (10431번)
/*
  문제: https://www.acmicpc.net/problem/10431
  구현, 시뮬레이션
  문제에서 주어진 조건대로 잘 구현하면 되는 문제.
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void count(int N, int cur) {
        int idx = N;
        for (int i=0; i<N; i++) {
            if (arr[i] > cur) {
                idx = i;
                break;
            }
        }

        int[] newArr = new int[N + 1];

        for (int i=0; i<idx; i++) {
            newArr[i] = arr[i];
        }
        newArr[idx] = cur;

        for (int i=idx + 1; i < N + 1; i++) {
            newArr[i] = arr[i - 1]; // arr[i - 1]을 arr[idx - 1]로 사용하는 실수를 하고 있었다.
            ans += 1;
        }

        arr = newArr;
    }

    static int P, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        P = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int p=0; p<P; p++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            arr = new int[20];
            for (int n=0; n<20; n++) {
                int cur = Integer.parseInt(st.nextToken());
                count(n, cur);
            }
            bw.write(T + " " + ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
