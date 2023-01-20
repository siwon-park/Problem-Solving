// 용액 합성하기 (14921번)
/*
  문제: https://www.acmicpc.net/problem/14921
  투 포인터
  배열을 오름차순 정렬하고 두 수의 합을 구한다.
  0과 가까운 두 수의 합을 구하려면 두 수의 합 절댓값에 대해서 0과 가까운지 확인해야한다.
  즉, 0과 가깝다는 것은 절댓값이 가장 작은 경우이다.
*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); // 오름차순 정렬

        int s = 0;
        int e = N - 1;
        int ans = 0;
        int zero = 200_000_001;
        while (s < e) {
            int twoSum = A[s] + A[e]; // 두 수의 합
            if (Math.abs(twoSum) < zero) { // 0과 가깝다는 의미는 두 수의 합의 절댓값이 가장 작다는 의미
                zero = Math.abs(twoSum);
                ans = twoSum; // 두 수의 합 기록
            }
            if (twoSum < 0) { // 두 수의 합이 0 미만이면 s를 += 1시켜서 두 수의 합을 증가시킴
                s += 1;
            } else { // 두 수의 합이 0 이상이면 e를 -= 1시켜서 두 수의 합을 감소시킴
                e -= 1;
            }
        }
        System.out.println(ans);
    }
}
