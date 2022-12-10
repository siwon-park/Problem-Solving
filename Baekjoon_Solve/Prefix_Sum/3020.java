// 개똥벌레 (3020번)
//////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/3020
  // 누적합
  // 처음에 이분탐색으로 풀려고 시도했는데, 구간에 대한 석순과 종유석 개수를 어떻게 계산해야할지 몰라서 많은 고민을 하다가
  // 질문 게시판에서 힌트를 얻어서 풀었다. 이분탐색으로 풀 필요 없이 누적합으로도 풀 수 있는 문제였다.
  // H의 최댓값이 50만이고, N의 최댓값이 20만이기 때문에 입력으로 주어지는 높이 h들이 50만과 가까운 큰 수라면
  // 누적 배열을 만드는데에서 시간초과가 날 것이었다.
  // 누적 배열을 효율적으로 만드는 포인트는 다음과 같았다. 일단 입력으로 주어지는 높이에 대해 누적 배열에 +=1을 해준다.
  // 그 후, H-1부터 1까지 역순으로 반복 구문을 돌려서 높은 높이에 있는 값을 낮은 높이에 누적해주는 방식으로 누적합을 계산하면 된다.
  // 석순과 종유석 2종류가 있으므로 누적합 배열도 2개 선언하고, 파괴할 수 있는 장애물의 개수를 구할 때는 종유석의 경우 역으로 계산해줘야 하기 때문에
  // [최대 높이 - 현재 높이 + 1]으로 계산해줘야 한다.
//////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] upCount = new int[H + 1]; // 석순
        int[] downCount = new int[H + 1]; // 종유석


        for (int i=0; i<N; i++) {
            int obst = Integer.parseInt(br.readLine());
            if (i % 2 == 0) { // 석순
                upCount[obst] += 1;
            } else { // 종유석
                downCount[obst] += 1;
            }
        }

        // 누적합 계산(역순)
        for (int h=H-1; h > 0; h--) {
            upCount[h] += upCount[h + 1];
            downCount[h] += downCount[h + 1];
        }

        // 부셔야하는 장애물의 최소 개수와 구간의 수 계산
        int maxBroken = Integer.MAX_VALUE;
        int cnt = 0;
        for (int h=1; h<=H; h++) {
            int curBroken = upCount[h] + downCount[H - h + 1];
            if (curBroken < maxBroken) {
                maxBroken = curBroken;
                cnt = 1;
            } else if (curBroken == maxBroken) {
                cnt += 1;
            }
        }

        System.out.println(maxBroken + " " + cnt);

    }

}
