// 학부 연구생 민상 (21922번)
/*
  문제: https://www.acmicpc.net/problem/21922
  시뮬레이션
  BFS방식으로 시뮬레이션을 구현하였다.
  처음에 4번이나 틀렸습니다를 받았는데, 방문배열에 체크할 때, (ny, nx)에 대한 방문을 체크해야했는데, (y, x)를 체크하고 있었다.
  내 풀이는 2400ms대여서 빠른 풀이를 봤는데, 로직에서 차이가 없는데 속도가 3배 이상 차이가 나는 이유를 모르겠다.
  혹시나 싶어서 방향을 바꾸는 로직을 수학적으로 %연산을 이용하게 바꿨고, if구문을 switch 구문으로 바꿨는데도 거의 속도 개선이 없다.
  구현 문제라서 그냥 문제에서 주어진 대로 구현하면 된다.
*/
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int y;
        int x;
        int w;
        Pair(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }

    static int bfs() {
        int cnt = 0;
        int[][] count = new int[N][M];
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int y = pair.y;
            int x = pair.x;
            int w = pair.w;
            count[y][x] = 1;
            int ny = y + dy[w];
            int nx = x + dx[w];
            if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx][w]) {
                visited[ny][nx][w] = true;
                switch (graph[ny][nx]) {
                    case 0:
                        queue.add(new Pair(ny, nx, w));
                        break;
                    case 1:
                        if (w % 2 == 1) {
                            queue.add(new Pair(ny, nx, (w + 2) % 4)); // 1 -> 3, 3 -> 1
                        } else {
                            queue.add(new Pair(ny, nx, w));
                        }
                        break;
                    case 2:
                        if (w % 2 == 0) {
                            queue.add(new Pair(ny, nx, (w + 2) % 4)); // 2 -> 0, 0 -> 2
                        } else  {
                            queue.add(new Pair(ny, nx, w));
                        }
                        break;
                    case 3:
                        queue.add(new Pair(ny, nx, (5 - w) % 4)); // 0 -> 1, 1 -> 0, 2 -> 3, 3 -> 2
                        break;
                    case 4:
                        queue.add(new Pair(ny, nx, 3 - w)); // 0 -> 3, 1 -> 2, 2 -> 1, 3 -> 0
                        break;
                }
            }
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
//                 System.out.print(count[i][j] + " ");
                if (count[i][j] == 1) {
                    cnt += 1;
                }
            }
//             System.out.println();
        }
        return cnt;
    }

    static int N, M;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<Pair> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M][4];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 9) {
                    for (int k=0; k<4; k++) {
                        queue.add(new Pair(i, j, k));
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        System.out.println(bfs());
        br.close();
    }
}
