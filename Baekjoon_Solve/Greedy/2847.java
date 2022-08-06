//게임을 만든 동준이(2847번)
////////////////////////////////////////////////////////
    // 문제: https://www.acmicpc.net/problem/2847
    // 그리디 알고리즘
    // 배열을 선언하고 각 레벨별 점수를 각 배열의 인덱스에 넣는다.
    // 마지막 단계에서 얻는 점수가 가장 높고, 점수를 내리는 것을 최소한으로 해야하므로, 배열의 끝-1에서부터 처음까지 역순으로 탐색을 시작한다.
    // 만약 현재 레벨(i+1)의 점수가 이전 레벨(i)의 점수보다 작거나 같으면, 점수를 내린 횟수에 (이전 레벨의 점수-현재 레벨의 점수+1)의 값을 누적해준다.
    // 예를 들어, 현재 레벨의 점수: 5 이전 레벨의 점수: 7이라면 이전 레벨의 점수에서 3을 빼줘야 5보다 작은 4가 된다.
    // 이후에 이전 레벨의 점수는 현재 레벨의 점수-1로 갱신시켜준다.
////////////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] lvl = new int[N];
        int cnt = 0;
        for (int i=0; i<N; i++) {
            int n = sc.nextInt();
            lvl[i] = n;
        }
        for (int i=N-2; i>=0; i--) {
            if (lvl[i] >= lvl[i+1]) {
                cnt += lvl[i] - lvl[i+1] + 1;
                lvl[i]=lvl[i+1]-1;
            }
        }
        System.out.println(cnt);
    }
}
