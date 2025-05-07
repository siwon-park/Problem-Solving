import java.io.*;
import java.util.*;

// 누가 이름 안 적고 나갔어 (33578번)
public class Main {

    static final int INF = Integer.MAX_VALUE;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int N, M;
    static String[] graph;
    static int[][][] visited;

    static void bfs(int r, int c, int idx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, 0});
        visited[r][c][idx] = 0;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int y = pair[0];
            int x = pair[1];
            int d = pair[2];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || graph[ny].charAt(nx) == '#') continue;
                if (visited[ny][nx][idx] == -1) {
                    visited[ny][nx][idx] = d + 1;
                    queue.add(new int[] {ny, nx, d + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int sr = 0;
        int sc = 0;
        int jr = 0;
        int jc = 0;
        graph = new String[N];
        visited = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            graph[i] = line;
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'J') {
                    jr = i;
                    jc = j;
                } else if (line.charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }
                Arrays.fill(visited[i][j], -1);
            }
        }

        // 진우의 이동
        bfs(jr, jc, 0);

        // 승찬이의 이동
        bfs(sr, sc, 1);
        int ans = INF;
        if (visited[sr][sc][0] == -1) {
            System.out.println(-1);
        } else {
            ans = visited[sr][sc][0] * 2; // 2초에 1칸 움직이니 2배 해줌
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i].charAt(j) == 'T') { // 현재 위치가 선생이면 여기서 부터 1초에 1칸씩 이동한 것임
                        int t1 = visited[i][j][0];
                        int t2 = visited[i][j][1];
                        if (t1 == -1 || t2 == -1) continue;
                        ans = Math.min(ans, t1 * 2 + t2);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
