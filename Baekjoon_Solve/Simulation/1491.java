// 나선(1491번)
/////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1491
  // 구현, 시뮬레이션
  // 쉬운 난이도의 문제인데 왜 이렇게 시간을 많이 잡아 먹었는지 모르겠다.
  // 일단 문제의 예시가 잘못되었다 NxM행렬이 아니라 MxN행렬이다. 즉, 가로가 N 세로가 M으로 두고 풀어야한다.
  // 처음에는 한 칸 한 칸씩 방문을 하면서 반시계 방향으로 계속해서 돌까 생각했는데,
  // 생각해보니 그럴 필요가 없었다. 애초부터 갈 수 있는 칸 수가 정해져있기 때문에 해당 칸 만큼 x나 y를 한번에 이동시키면 된다.
  // 이번 차례에 이동 가능한 칸의 수가 0보다 작거나 같으면 나선의 끝이므로 break를 하고 x, y를 출력하면 된다.
  // 가로든 세로든 이동할 수 있는 칸은 매번 -1씩 작아지므로, 크기가 4인 move 배열에 우, 상, 좌, 하로 이동 가능한 칸을 기록해두었다.
  // 그리고 다시 자기 차례가 왔을 때는 반대 방향에서 이동한 것도 고려해야하기 때문에 이동할 수 있는 칸은 매번 -2칸씩 줄어든다.
/////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가로
        int M = Integer.parseInt(st.nextToken()); // 세로

        int[] move = {N, M - 1, N - 1, M - 2};
        int k = 0;

        int x = -1;
        int y = 0;

        while (true) {
            if (move[k] <= 0) {
                break;
            }

            if (k == 0) {
                x += move[k];
            } else if (k == 1) {
                y += move[k];
            } else if (k == 2) {
                x -= move[k];
            } else {
                y -= move[k];
            }
            move[k] -= 2; // -1이 아니라 -2를 해준다. 왜냐하면 다시 자기 차례가 돌아왔을 때는 반대 방향에서도 이동을 해서 이동할 수 있는 칸 수가 2번 감소된 상태이기 때문이다.

            k += 1;
            k = k % 4;
        }

        System.out.println(x +" " + y);
        br.close();
    }
}
