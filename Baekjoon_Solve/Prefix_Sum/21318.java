// 피아노 체조 (21318번)
/*
  문제: https://www.acmicpc.net/problem/21318
  누적합
  어떻게 풀어야 하나 잠시 고민을 하다가 생각해보니
  A[i - 1] > A[i]인 경우에 대해 +1 씩 누적하는 누적합 배열을 만들면 되는 간단한 문제였다.
*/


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] prefixSum = new long[N + 1];
        for (int i=1; i<N+1; i++) {
            int ret = (arr[i - 1] > arr[i]) ? 1 : 0;
            prefixSum[i] += prefixSum[i - 1] + ret;
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(prefixSum[y] - prefixSum[x] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
