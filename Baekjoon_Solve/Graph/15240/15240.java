import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int y;
        int x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs(int r, int c, int f) {
        boolean[][] visited = new boolean[R][C];
        visited[r][c] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r, c));
        filledGraph[r][c] = f;
        int org = graph[r][c]; // 본래 색
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (0 <= ny && ny < R && 0 <= nx && nx < C && !visited[ny][nx]) {
                    if (filledGraph[ny][nx] == org) {
                        filledGraph[ny][nx] = f;
                        visited[ny][nx] = true;
                        queue.add(new Pair(ny, nx));
                    }
                }
            }
        }
    }

    static int R, C;
    static int Y, X, K; // (Y, X)에 K를 채워라
    static int[][] graph, filledGraph; // 색칠 전 그래프, 색칠 후 그래프
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new int[R][C];
        filledGraph = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = Integer.parseInt(line.charAt(j) + "");
                filledGraph[i][j] = graph[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(Y, X, K);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(filledGraph[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}