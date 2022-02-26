// 네 번째 점(3009번)
/////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/3009
  // 구현
  // x좌표, y좌표가 각각 1번씩 등장한 것이 마지막 x, y의 좌표임
  // x축, y축 count배열을 만들고, 해당 x좌표 또는 y좌표의 최종 count값이 1이면 그 값을 x, y로 하여 최종 출력함
  // 풀면서 이렇게 푸는게 맞나 싶었는데, 풀고나서 다른 사람의 답안을 보니까 대부분 이렇게 비슷하게 푼 듯하다.
/////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xCount = new int[1001];
        int[] yCount = new int[1001];
        int[] xArr = new int[3];
        int[] yArr = new int[3];
        int x = 0;
        int y = 0;
        for (int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            xCount[x1] += 1;
            yCount[y1] += 1;
            xArr[i] = x1;
            yArr[i] = y1;
        }
        for (int i=0; i<3; i++) {
            if (xCount[xArr[i]] == 1) {
                x = xArr[i];
            }
            if (yCount[yArr[i]] == 1) {
                y = yArr[i];
            }
        }
        System.out.println(x+" "+y);
    }
}
