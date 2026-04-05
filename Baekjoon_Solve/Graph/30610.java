// A-maze-ing Lakes (30610번)
import java.io.*;
import java.util.*;

public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int N, M;
    static String[] graph;
    static boolean[][] visited;
    static ArrayList<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[N];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i].charAt(j) == '1') {
                    results.add(bfs(i, j));
                }
            }
        }

        Collections.sort(results);
        System.out.println(results.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.size(); i++) {
            sb.append(results.get(i));
            sb.append(" ");
        }
        System.out.println(sb);
    }

    static private int bfs(int r, int c) {
        int size = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || graph[ny].charAt(nx) == '0') continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx});
                size += 1;
            }
        }
        return size;
    }

}

