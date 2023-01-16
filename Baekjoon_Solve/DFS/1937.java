// 욕심쟁이 판다 (1937번)
/*
  문제: https://www.acmicpc.net/problem/1937
  DFS, DP
  메모이제이션으로 접근하였다. 이 문제는 메모이제이션과 DFS를 잘 익힐 수 있는 좋은 문제라고 생각한다.
  메모 배열에 현재 칸에서 갈 수 있는 칸 수를 미리 기록해두는 방식으로 해결하였다.
  일단 배열에 있는 값이 0이면 현재 칸까지 포함해서 이동할 수 있다고 보는 것이므로 1로 기록한다. 아니라면 원래 기록된 값을 return 한다.
  어떤 칸에서 다음 칸으로 갈 수 있다면, 해당 칸으로 갈 수 있는 경우인 1에서 시작해서
  재귀 호출을 통해 다음 칸에서부터 갈 수 있는 모든 칸 수들의 합을 더 한다.
  현재 위치에서 갈 수 있는 값과 누적한 값 중 큰 값을 현재 위치에 기록한다.

  문제를 다 풀어 놓고선
  최댓값 갱신을 해주지 않아서 틀렸습니다를 받았다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int dfs(int y, int x) {
        if (memo[y][x] == 0) {
            memo[y][x] = 1;
        } else {
            return memo[y][x];
        }

        for (int k=0; k<4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                if (graph[y][x] < graph[ny][nx]) {
                    int d = 1; // 다음 칸으로 이동 가능하니 1에서 시작
                    d += dfs(ny, nx); // 다음 칸에서 이동 가능한 칸들을 모두 더 함
                    memo[y][x] = Math.max(memo[y][x], d); // 최댓값 갱신
                }
            }
        }

        return memo[y][x];
    }

    static int N;
    static int[][] memo, graph;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        memo = new int[N][N]; // 이동할 수 있는 칸 수를 기록

        StringTokenizer st;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }

        System.out.println(ans);

    }
}
