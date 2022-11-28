
// 겹치는 건 싫어 (20922번)
////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/20922
  // 투 포인터
  // 오랜만에 투 포인터 문제를 풀어보았다. 그래서 구현에서 실수를 하여 시간을 잠깐 소비하였다.
  // 처음에 조건에 따라 s도 움직이는 방식으로 구현하였으나, 생각해보니 while 문 안에 있는 while문은 어차피 조건이 맞으면 동작하는 개념이니
  // 최상단의 while문에서 s를 움직여주는 방식으로 구현하면 됬었다.
////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] count = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] a = new int[N + 1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st2.nextToken());
        }

        int s = 0; // 시작 포인터
        int e = 0; // 끝 포인터
        int len = 0; // 현재 길이
        int ans = 0; // 최대 길이
        while (s < N) {
            while (e < N && count[a[e]] < K) {
                count[a[e]] ++;
                e ++;
                len ++;
            }

            ans = Math.max(ans, len);
            count[a[s]] --;
            len --;
            s ++;
        }

        System.out.println(ans);
    }
}
