// 알파벳 (1987번)
/*
  문제: https://www.acmicpc.net/problem/1987
  DFS, 백트랙킹
  (0, 0)에서 출발해서 백트랙킹으로 최대 몇 칸 갈 수 있는지 세면 된다.
  (0, 0)을 포함해서 시작은 1칸이다.
  같은 알파벳을 2번 방문하지 않기 위해 크기가 26인 count배열을 통해
  배열의 인덱스에 해당하는 값이 0이면 방문하고, 그렇지 않으면 방문하지 않는다.
  처음에 예제 답안도 잘 안 나왔는데, 그 이유는 (0, 0)에서만 출발한 것이 아니라,
  모든 좌표에 대해서 백트랙킹을 통해 최대 갈 수 있는 칸 수를 구하고 있어서 그랬다.
  문제를 잘 읽자!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static void dfs(int y, int x, int cnt, int[] c) {
        ret = Math.max(ret, cnt);
        for (int k=0; k<4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (0 <= ny && ny < R && 0 <= nx && nx < C) {
                if (c[graph[ny][nx] - 65] == 0) {
                    c[graph[ny][nx] - 65] = 1;
                    dfs(ny, nx, cnt + 1, c);
                    c[graph[ny][nx] - 65] = 0;
                }
            }
        }
    }
    static int R, C, ret;
    static char[][] graph;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        for (int i=0; i<R; i++) {
            String tmp = br.readLine();
            for (int j=0; j<C; j++) {
                graph[i][j] = tmp.charAt(j);
            }
        }

        int[] count = new int[26];
        count[graph[0][0] - 65] = 1;
        ret = 0;
        dfs(0, 0, 1, count);

        System.out.println(ret);

    }
}
