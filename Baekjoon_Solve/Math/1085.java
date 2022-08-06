// 직사각형에서 탈출(1085번)
////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1085
  // 수학
  // 자바에 튜플형이 없어서 처음으로 Pair라는 클래스를 만들어 보았다.(인터넷 참고함)
  // 또한 파이썬 처럼 절댓값을 구하는 함수가 없어 직접 대소 비교를 통해 x간, y간 차이를 구해 거리를 계산하였다.
  // 문제 풀면서 제네릭스도 처음 적용해보았다.
////////////////////////////////////////////////////////////////
import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        ArrayList<Pair> arr = new ArrayList<>(); // 리스트 자료형에는 Pair객체가 담긴다고 제네릭스를 줬다
        for (int i=0; i<=w; i++) {
            for (int j=0; j<=h; j++) {
                if (i==0 || i==w || j==0 || j==h) { // i가 0이거나 w이거나 j가 0이거나 h이면 그 좌표는 선 위의 좌표이다.
                    arr.add(new Pair(i,j)); // Pair 객체를 매번 새로 생성하는 것이니 new를 붙여줘야한다.
                }
            }
        }
        int minDist = 100000000;
        for (Pair p : arr) {
            int first, second;
            first = p.first;
            second = p.second;
            int tmpDist= 0;
            if (x >= first) {
                tmpDist += x-first;
            } else {
                tmpDist += first-x;
            }
            if (y >= second) {
                tmpDist += y-second;
            } else {
                tmpDist += second-y;
            }
            if (tmpDist < minDist) {
                minDist = tmpDist;
            }
        }
        System.out.println(minDist);
    }
}
