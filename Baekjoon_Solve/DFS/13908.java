// 비밀번호 (13908번)
/*
  문제: https://www.acmicpc.net/problem/13908
  백트랙킹
  0 부터 9까지의 숫자 중 m개의 비밀번호 후보군은 배열에서 1로 체크해두고
  백트랙킹을 통해서 비밀번호를 붙여나간다.
  이 때, 후보 비밀번호면 0으로 바꾼다. 이렇게 하는 이유는 전체 숫자 중 하나를 선택했을 때의 중복을 피하기 위해서이다.
  0으로 바꾸고 나면 비밀번호 후보군 숫자라도 이제 배열에서의 값이 1이 아니기 때문에 else 구문을 통해 중복 없이 선택이 가능하다.
  이런 과정과 else없이 전체 숫자 중 하나를 선택하게 하면 중복이 발생하게 된다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void dfs(int k, int cnt) {
        if (k == n) {
            if (cnt == m) {
                ans++;
            }
            return;
        }

        for (int i=0; i<10; i++) {
            if (cand[i] == 1) { // 비밀번호 후보군을 붙임
                cand[i] = 0;
                dfs(k + 1, cnt + 1);
                cand[i] = 1;
            } else {
                dfs(k + 1, cnt);
            }
        }
    }

    static int n, m, ans;
    static int[] cand;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cand = new int[10];

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<m; i++) {
                int idx = Integer.parseInt(st.nextToken());
                cand[idx] = 1;
            }
        }

        dfs(0, 0);
        System.out.println(ans);

    }
}
