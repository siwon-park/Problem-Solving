// 상품의 주인은?(24509번)
/////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/24509
  // 구현, 정렬
  // 자바에서 정렬을 어떻게 하는지 아직 안 배워서, 어떻게 풀까 고민을 했는데, 2차원의 배열에서 열 우선 탐색을 하는 방식으로 해결하였다.
  // 정렬을 할 수 있었다면 코드가 더 간결했겠지만, 코드를 짜면서 자바에 대해 좀 더 익숙해질 수 있어서 좋았다.
/////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ret = new int[4]; // 과목별 상품을 받은 학생 번호를 기록하기 위한 배열
        boolean[] check = new boolean[N]; // 해당 번호 학생이 상품을 받았는지 체크하기 위한 배열
        // 2차원 배열에 데이터 입력받기
        int[][] arr = new int[N][4];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            arr[X-1][0] = Integer.parseInt(st.nextToken());
            arr[X-1][1] = Integer.parseInt(st.nextToken());
            arr[X-1][2] = Integer.parseInt(st.nextToken());
            arr[X-1][3] = Integer.parseInt(st.nextToken());
        }
        // 열 우선 탐색 시작
        String ans = "";
        int[] score = {-1, -1, -1, -1}; // 점수 기록 및 갱신용 배열
        for (int j=0; j<4; j++) {
            int last = -1;
            for (int i=0; i<N; i++) {
                // 해당 과목의 최고점일 경우
                if (arr[i][j] > score[j]) {
                    // 상품을 받지 않았을 경우에만, 최고점 갱신 및 상품 수령 체크
                    if (!check[i]) {
                        // 더 높은 점수를 가졌으면서 상품을 받지 않은 학생이 있을 경우,
                        if (last != -1){
                            check[last] = false; // 가장 최근에 상품을 수령한 학생 번호를 false로 바꿈
                        }
                        check[i] = true;
                        last = i;
                        score[j] = arr[i][j];
                        ret[j] = i+1;
                    }
                }
            }
            ans += ret[j]+" ";
        }
        System.out.println(ans);
    }
}
