// 2048(Easy) (12100번)
///////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/source/48994200
  // 백트랙킹, 브루트포스, 구현, 시뮬레이션
  // 문제를 꼼꼼히 읽고, 자바에 좀 더 익숙했다면 별로 오래 걸리지 않았을 것 같은 문제이다.
  // 몇 가지 예외 상황 및 의도했던 대로 작동하지 않아서 디버깅에 많은 시간을 할애했다. (실수도 몇번 있었음)
  // 2차원의 복사는 그냥 for 구문 2번 돌려서 할당하는 방식으로 하였다. 파이썬이었다면, 복사한 배열을 그냥 원본 배열에 할당해주면 됬는데,
  // 자바는 그게 안 되는 걸 직접 디버깅하면서 확인했고, 다시 2중 for 구문을 통해 할당하는 방식을 사용하였다.
///////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int maxValue = -1024;
    static int[][] board;

    static void move(int r, int c, int dr, int dc, boolean[][] visited) {
        if (board[r][c] != 0) {
            while (0 <= r + dr && r + dr < N && 0 <= c + dc && c + dc < N) {
                if (board[r + dr][c + dc] == 0) {
                    board[r + dr][c + dc] = board[r][c];
                    board[r][c] = 0;
                    visited[r + dr][c + dc] = visited[r][c];
                    visited[r][c] = false;
                } else if (board[r + dr][c + dc] == board[r][c] && !visited[r + dr][c + dc]) {
                    board[r + dr][c + dc] += board[r][c];
                    board[r][c] = 0;
                    visited[r + dr][c + dc] = true;
                    break;
                } else {
                    break;
                }
                r += dr;
                c += dc;
            }
        }
    }
    static void backTrack(int mc) {
        if (mc == 5) {
//            System.out.println(Arrays.deepToString(board));
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    maxValue = Math.max(maxValue, board[i][j]);
                }
            }
            return;
        }

        int[][] orgBoard = new int[N][N]; // 배열 복사
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                orgBoard[i][j] = board[i][j];
            }
        }

        for (int k=0; k<4; k++) {
            boolean[][] visited = new boolean[N][N];
            int dr = dy[k];
            int dc = dx[k];
            if (k == 0 || k == 3) {
                for (int i=0; i<N; i++) {
                    for (int j=0; j<N; j++) {
                        int r = i;
                        int c = j;
                        move(r, c, dr, dc, visited);
                    }
                }
            } else {
                for (int i=N-1; i>-1; i--) {
                    for (int j=N-1; j>-1; j--) {
                        int r = i;
                        int c = j;
                        move(r, c, dr, dc, visited);
                    }
                }
            }

            backTrack(mc + 1);
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    board[i][j] = orgBoard[i][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        backTrack(0);

        System.out.println(maxValue);

    }
}
