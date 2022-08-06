// 경비원(2564번)
////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/2564
  // 구현
  // 이 문제를 왜 한 시간 반이나 넘게 잡고 끙끙됐는지 잘 모르겠다.... 거의 다 풀어놓고 마지막에 최단거리를 계산함에 있어
  // 머리속에서 로직이 꼬여서 고생을 많이했다.
  // Pair 클래스를 선언해서 x, y 좌표를 담았으며, Math.min, Math.abs 최솟값, 절댓값 관련 함수를 처음 써본 문제였다.
  // 결국 찾고자하는 것은 최단거리였는데, 나는 자꾸 논리 그대로 짜려다 보니 더 고생했던 것 같다. 로직때로 구현을 하는 것도 중요하지만,
  // 얼마나 효율적으로 원하는 답을 정확하게 찾느냐도 중요하다.
  // 여기서 말하는 효율은 코드의 효율성을 이야기하는 것이 아니다. 아래 코드를 보면 if, else if , else 구문을 엄청 많이 썼다. 복잡하다.
  // 8%에서 자꾸 틀렸다고 나왔는데, 너비 10, 높이 5의 사각형에서 (0,3) (10,3) 일 경우, 최단거리는 14임에도 내 코드는 10을 출력하고 있었다.(10 5 1 3 2 4 2 케이스)
  // 두 좌표의 y값이 같을 경우(또는 x값이 같을 경우) 그냥 반대(x 또는 y) 좌표값 간 차이의 절댓값만을 계산해서 그런 문제가 발생하였다.
  // 이때도 역시 x좌표 차이의 절댓값 또는 y좌표 차이의 절댓값에 시계방향, 반시계방향으로 갔을 때의 추가 거리를 계산해서 둘 중 최솟값을 더해줘야 했었다.
////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[N];
        // 각 상점들의 좌표
        for (int i=0; i<N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int way = Integer.parseInt(st2.nextToken());
            int diff = Integer.parseInt(st2.nextToken());
            if (way == 1) { // 북쪽일 경우
                Pair p = new Pair(diff, H);
                arr[i] = p;
            } else if (way == 2) { // 남쪽인 경우
                Pair p = new Pair(diff, 0);
                arr[i] = p;
            } else if (way == 3) { // 서쪽인 경우
                Pair p = new Pair(0, H - diff);
                arr[i] = p;
            } else { // 동쪽인 경우
                Pair p = new Pair(W, H - diff);
                arr[i] = p;
            }
        }  // end of for loop
        // 동근이의 좌표 x, y
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int dWay = Integer.parseInt(st3.nextToken());
        int dDiff = Integer.parseInt(st3.nextToken());
        int x = 0;
        int y = 0;
        if (dWay == 1) { // 북쪽일 경우
            x = dDiff;
            y = H;
        } else if (dWay == 2) { // 남쪽인 경우
            x = dDiff;
            y = 0;
        } else if (dWay == 3) { // 서쪽인 경우
            x = 0;
            y = H - dDiff;
        } else { // 동쪽인 경우
            x = W;
            y = H - dDiff;
        }
        int ans = 0; // 최종 답
        for (int i=0; i<N; i++) {
            int x2 = arr[i].first;
            int y2 = arr[i].second;
            if (x2 == x) {
                int frstV = x2 + x;
                int scndV = 2*W - x2 - x;
                ans += Math.abs(y2 - y) + Math.min(frstV, scndV);
            } else if (y2 == y) {
                int frstV = y2 + y;
                int scndV = 2*H - y2 - y;
                ans += Math.abs(x2 - x) + Math.min(frstV, scndV); 
            } else {
                if (dWay == 1 || dWay == 2) {
                    int frstV = x2 + x;
                    int scndV = 2*W - x2 - x;
                    ans += (Math.min(frstV, scndV) + Math.abs(y2 - y));
                } else {
                    int frstV = y2 + y;
                    int scndV = 2*H - y2 - y;
                    ans += (Math.min(frstV, scndV) + Math.abs(x2 - x));
                }
            }
        }
        System.out.println(ans);
    }
}
