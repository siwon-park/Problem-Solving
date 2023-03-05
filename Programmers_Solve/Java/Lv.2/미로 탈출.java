import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Pair {
        int y;
        int x;
        int d;
        int w;
        Pair(int y, int x, int d, int w) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.w = w;
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public int solution(String[] maps) {
        int answer = 0;
        int N = maps.length; // maps의 행
        int M = maps[0].length(); // maps의 열
        int[][][] visited = new int[N][M][2]; // 3차원의 방문 배열 생성
        int MAX = Integer.MAX_VALUE;
        int ty = 0;
        int tx = 0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 2; k++) visited[i][j][k] = MAX;
                if (maps[i].charAt(j) == 'S') {
                    queue.add(new Pair(i, j, 0, 0));
                    visited[i][j][0] = 0;
                }
                else if (maps[i].charAt(j) == 'E') {
                    ty = i;
                    tx = j;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (maps[ny].charAt(nx) != 'X') {
                        if (pair.d + 1 < visited[ny][nx][pair.w]) {
                            int w = maps[ny].charAt(nx) == 'L' ? 1 : pair.w;
                            visited[ny][nx][w] = pair.d + 1;
                            queue.add(new Pair(ny, nx, pair.d + 1, w));
                        }
                    }
                }
            }
        }
        return visited[ty][tx][1] == MAX ? -1 : visited[ty][tx][1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] maps1 = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] maps2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};

        int ans1 = solution.solution(maps1);
        System.out.println(ans1);

        int ans2 = solution.solution(maps2);
        System.out.println(ans2);
    }
}