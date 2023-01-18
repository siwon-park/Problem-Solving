// 두 수의 합 (9024번)
/*
  문제: https://www.acmicpc.net/problem/9024
  투 포인터, 이분탐색
  이와 유사한 문제에 대해서 이분탐색으로 풀어본 적이 있다.
  lowerbound를 활용해서 자기 자신에서 K만큼 차이나는 숫자가 들어갈 수 있는 가장 작은 위치를 찾아서
  해당 위치에 있는 숫자를 활용하여 조건문으로 해결할 수도 있다.
  투 포인터로 푸는 방법은 예전에 아주 초보일 때 풀었던 것 같아서 익숙치 않았고, 투 포인터에 익숙해지고자
  투 포인터로 풀어봤는데, 상당히 많은 시간 애를 먹었다.
  투 포인터에도 s, e가 같은 방향으로 나가는 것이 있고, s는 점차 오른쪽으로, e는 점차 왼쪽으로 가는 경우도 있다는 것을 알게 되었다.
  아마 배열에 음수가 있는 경우에는 후자의 방법으로 구현해야 하는 것 같다.
  왜냐하면 e가 오른쪽으로 간다고 하면 두 수의 합은 항상 증가하겠지만, 그렇다고 절댓값도 항상 증가하지는 않기 때문이다.
  우리는 K와 가장 가까운 수를 찾아야하므로, 절댓값을 고려해야하는데, 이렇게 되면 원하는 값을 제대로 찾을 수 없게 된다.
*/

import java.io.*;
import java.util.*;

public class Main {

    static int find(int K, int[]arr, int s, int e) {
        int cnt = 0;
        int nearOne = arr[s] + arr[e] - K; // K와 가장 가깝다는 의미는 두 수의 합에서 K를 뺐을 때 0과 가깝다는 의미임
        while (s < e) {
            int twoSum = arr[s] + arr[e] - K;
            if (Math.abs(twoSum) < Math.abs(nearOne)) {
                nearOne = Math.abs(twoSum);
                cnt = 1;
            } else if (Math.abs(twoSum) == Math.abs(nearOne)) {
                cnt += 1;
            }
            if (twoSum < 0) { // 배열에 음수가 있으므로 합을 크게 하기 위해 s += 1
                s += 1;
            } else { // 두 수의 합을 줄이고자 할 때는 e -= 1
                e -= 1;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int ret = find(K, arr, 0, N - 1);
            bw.write(ret + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
