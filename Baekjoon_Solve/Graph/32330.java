// Harvest Waterloo (32330번)
import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = Integer.MAX_VALUE;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int N, M;
    static String[] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new String[N];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
        }

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];
        visited[A][B] = true;
        queue.add(new int[] {A, B});
        int ans = 0;
        if (graph[A].charAt(B) == 'S') {
            ans += 1;
        } else if (graph[A].charAt(B) == 'M') {
            ans += 5;
        } else if (graph[A].charAt(B) == 'L') {
            ans += 10;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || graph[ny].charAt(nx) == '*' || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                if (graph[ny].charAt(nx) == 'S') {
                    queue.add(new int[]{ny, nx});
                    ans += 1;
                } else if (graph[ny].charAt(nx) == 'M') {
                    queue.add(new int[]{ny, nx});
                    ans += 5;
                } else if (graph[ny].charAt(nx) == 'L') {
                    queue.add(new int[]{ny, nx});
                    ans += 10;
                }
            }
        }
        System.out.println(ans);
    }
}

