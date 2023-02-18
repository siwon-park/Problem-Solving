// 신기한 소수(2023번)
/*
  문제: https://www.acmicpc.net/problem/2023
  소수, 정수론, 백트랙킹
  메모리가 4MB로 매우 작으므로, 어떠한 곳에도 따로 저장하지 말고 바로 출력해야한다.
  문제에서 주어지는 신기한 소수에 규칙성이 있는데
  처음에 2, 3, 5, 7 중 하나가 오고, 그 다음부터는 1, 3 ,7, 9 중 하나가 온다는 것이다.
  재귀호출을 통해 탐색하면서 매번 해당 수가 소수로 판별 가능한지 확인한다.
  마지막에 탐색하면 숫자가 커진 상태로 제곱근만큼 반복문을 돌기 때문에
  숫자가 커질 수록 탐색 시간이 길어진다. 따라서 매번 탐색하여 가지치기를 하는 것이다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void dfs(int pos, int nums) {
        for (int i=2; i <= (int) Math.sqrt(nums); i++) {
            if (nums % i == 0) {
                return;
            }
        }
        if (pos == N) {
            System.out.println(nums);
        }
        if (pos == 0) {
            for (Integer n: fristNums) {
                dfs(pos + 1, n + nums);
            }
        } else {
            for (Integer n2: nxtNums) {
                dfs(pos + 1, nums * 10 + n2);
            }
        }
    }

    static int[] fristNums = {2, 3, 5, 7}; // 처음 올 수 있는 숫자
    static int[] nxtNums = {1, 3, 7, 9}; // 그 다음부터 올 수 있는 숫자
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0, 0);
    }
}
