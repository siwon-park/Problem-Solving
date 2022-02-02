// ACM 호텔(10250번)
///////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/10250
  // 수학
  // 방 번호의 규칙을 찾아서 출력하는 문제
  // 기본적으로 방 번호에서 앞에오는 층수는 H를 N으로 나눈 나머지이고, 호수는 H를 N으로 나눈 몫+1인데 예외가 있다.
  // H%N==0이면, 층수는 H층이다. 그리고 층수가 H층일 때는, 호수는 H//N 이다.(java에선 H/N)
///////////////////////////////////////////////////
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0; i<T; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            int floor = N%H;
            int roomNo = N/H;
            if (floor == 0) {
                floor = H;
            } else {
                roomNo = roomNo+1;
            }
            if (roomNo >= 10) {
                System.out.println(floor+""+roomNo);
            } else {
                System.out.println(floor+"0"+roomNo);
            }
        }
    }
}
