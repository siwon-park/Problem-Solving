// 블랙 프라이데이 (18114번)
/*
  문제: https://www.acmicpc.net/problem/18114
  이분탐색, 정렬, 브루트포스
  입력으로 받는 배열을 정렬한다.
  N번 순회하여 완전 탐색으로 C인 arr[i]가 있다면 1을 반환하고,
  없다면 두 개를 고르는 경우로 arr[i]를 고른 상태에서 C - arr[i]가 arr[i]보다 크다면
  이분 탐색을 통해 arr[i] + arr[mid] == C인 j를 찾는다.
  만약 arr[i] + arr[mid] < C라면 나머지가 arr[i]와 arr[mid]가 아니면서 배열의 집합에 있으면 1을 반환한다.
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int blackFriday() {
        // 한 개를 고르는 경우
        for (int i=0; i<N; i++) {
            if (arr[i] == C) {
                return 1;
            }
        }

        // 두 개를 고르는 경우
        for (int i=0; i<N; i++) {
            if (C - arr[i] > arr[i]) {
                int s = i + 1;
                int e = N - 1;
                while (s <= e) {
                    int mid = (s + e) / 2;
                    if (arr[mid] + arr[i] == C) { // 두 개의 합이 C이면 1을 반환
                        return 1;
                    } else if (arr[mid] + arr[i] > C) { // 두 개의 합이 C 이상이면 e를 줄임
                        e = mid - 1;
                    } else { // arr[mid] + arr[i] < C
                        s = mid + 1;
                        // 세 개를 고르는 경우
                        int left = C - arr[mid] - arr[i];
                        if (left != arr[mid] && left != arr[i]) {
                            if (set.contains(left)) {
                                return 1;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    static int N, C;
    static int[] arr;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        Arrays.sort(arr);
        int ret = blackFriday();
        System.out.println(ret);

    }
}
