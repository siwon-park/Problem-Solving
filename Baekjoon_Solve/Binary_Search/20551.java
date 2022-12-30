// Sort 마스터 배지훈의 후계자 (20551번)
/*
 문제: https://www.acmicpc.net/problem/20551
 이분탐색
 LowerBound 문제
 정렬하여, 해당 숫자가 배열에서 들어갈 수 있는 가장 빠른 위치(인덱스)를 찾는다.
 만약 인덱스가 배열의 길이와 같거나, 해당 인덱스에 있는 숫자가 넣을 숫자가 아니라면 -1을 출력한다.
 그게 아니라면, 인덱스를 출력한다.
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int lowerBound(int value) {
        int idx = N;
        int s = 0;
        int e = N - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (A[mid] >= value) {
                e = mid - 1;
                idx = mid;
            } else {
                s = mid + 1;
            }
        }

        return idx;
    }

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        for (int i=0; i<M; i++) {
            int B = Integer.parseInt(br.readLine());
            int ret = lowerBound(B);
            if (ret == N || A[ret] != B) {
                bw.write(-1 + "\n");
            } else {
                bw.write(ret + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
