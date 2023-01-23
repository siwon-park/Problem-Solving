// 아이폰 9S (5883번)
/*
  문제: https://www.acmicpc.net/problem/5883
  브루트포스
  집합을 사용해서 배열의 숫자들을 담고, N에 대해서 완전탐색을 돌리면 되는 문제
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<N; i++) {
            line[i] = Integer.parseInt(br.readLine());
            set.add(line[i]);
        }

        int ans = 0;
        for (Integer num: set) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i=0; i<N; i++) {
                if (line[i] == num) {
                    continue;
                }
                arrayList.add(line[i]);
            }

            int last = 0; // 마지막 숫자
            int streak = 0; // 연속
            for (Integer i: arrayList) {
                if (i != last) {
                    last = i;
                    streak = 1;
                } else {
                    streak += 1;
                }
                ans = Math.max(ans, streak);
            }
        }

        System.out.println(ans);
    }
}
