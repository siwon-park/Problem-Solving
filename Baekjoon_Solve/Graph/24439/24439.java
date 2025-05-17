import java.io.*;
import java.util.*;

// 바리스타의 힘 (24439번)
public class Main {

    static final int INF = Integer.MAX_VALUE;
    static final int[] dyx = {-1, 1};
    
    static int N, M;
    static int[][] graph;
    static int[][][] visited;

    static int bfs() {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[] {0, 0, 0}); // y, x, z
        visited[0][0][0] = 0;
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int y = cur[0];
            int x = cur[1];
            int z = cur[2];
            if (z != 1) { // 1이 아니니 좌우로 이동함
                for (int dx : dyx) {
                    int nx = x + dx;
                    if (!check(y, nx)) continue;
                    if (graph[y][nx] == 1 && z != 2) continue; // 다음 칸이 벽인데 2가 아니면 좌우로 힘을 쓰지 않은 상태이니 통과 X
                    if (visited[y][x][z] + 1 < visited[y][nx][z]) {
                        visited[y][nx][z] = visited[y][x][z] + 1;
                        deque.addLast(new int[] {y, nx, z});
                    }
                }
            }
            if (z != 2) { // 2가 아니니 상하로 이동함
                for (int dy : dyx) {
                    int ny = y + dy;
                    if (!check(ny, x)) continue;
                    if (graph[ny][x] == 1 && z != 1) continue; // 다음 칸이 벽인데 1이 아니면 상하로 힘을 쓰지 않은 상태이니 통과 X
                    if (visited[y][x][z] + 1 < visited[ny][x][z]) {
                        visited[ny][x][z] = visited[y][x][z] + 1;
                        deque.addLast(new int[] {ny, x, z});
                    }
                }
            }

            if (z == 0) { // 상하(1), 좌우(2)로 힘을 사용해본다 -> 덱의 맨 앞으로 삽입
                for (int k = 1; k <= 2; k++) {
                    if (visited[y][x][z] < visited[y][x][k]) {
                        visited[y][x][k] = visited[y][x][z];
                        deque.addFirst(new int[] {y, x, k});
                    }
                }
            } else if (z < 3) { // 상하(1), 좌우(2)로 힘 사용 후 자유롭게 이동(3)
                if (visited[y][x][z] < visited[y][x][3]) {
                    visited[y][x][3] = visited[y][x][z];
                    deque.addFirst(new int[] {y, x, 3});
                }
            }
        }

        int ret = INF;
        for (int i = 0; i < 4; i++) ret = Math.min(ret, visited[N - 1][M - 1][i]);
        return (ret == INF) ? -1 : ret;
    }

    static boolean check(int y, int x) {
        return y >=0 && y < N && x >=0 && x < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new int[N][M][4]; // 0: 일반, 1: 상하, 2: 좌우, 3: 바리스타의 힘 사용 이후
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
                for (int k = 0; k < 4; k++) {
                    visited[i][j][k] = INF;
                }
            }
        }

        System.out.println(bfs());

    }
}
