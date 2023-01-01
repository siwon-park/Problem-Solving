// 고냥이 (16472번)
/*
  문제: https://www.acmicpc.net/problem/16472
  투 포인터
  N 종류의 문자를 가지는 최대 긴 문자열의 길이를 구해야한다.
  이 때, 주의할 점이
  종류가 N개가 되었을 때만 갱신하게 되면 안 된다. 예를 들어 N은 5가 주어지는데 문자열은 aaaaa라면 최대 길이가 갱신되지 않을 수도 있다.
  또한 cnt가 N보다 작을 때만 while 구문을 반복하는 것이 아니라, N 이하일 경우까지 포함해야한다.
  N개의 종류 알파벳을 가지는 최장 문자열이므로, N 이하여야 한다.
  그리고 추가적으로 최대 길이를 갱신할 때, cnt가 N을 초과했으면 끝 인덱스 e가 1칸 더 간 상태이기 때문에 e - s - 1과 l을 비교하여 갱신하고
  cnt가 N 이하라면 e - s와 l을 비교하여 갱신한다.
*/

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int M = S.length();

        int[] arr = new int[26];

        int l = 0;
        int e = 0;
        int cnt = 0;
        for (int s=0; s<M; s++) {
            while (e < M && cnt <= N) {
                int eIdx = S.charAt(e) - 97;
                if (arr[eIdx] == 0) {
                    cnt += 1;
                }
                arr[eIdx] += 1;
                e += 1;
            }

            if (cnt > N) {
                l = Math.max(l, e - s - 1);
            } else {
                l = Math.max(l, e - s);
            }

            int sIdx = S.charAt(s) - 97;
            if (arr[sIdx] == 1) {
                cnt -= 1;
            }
            arr[sIdx] -= 1;
        }

        System.out.println(l);

    }
}
