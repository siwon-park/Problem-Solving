// Journey of A Knight (7107번)
import java.io.*;
import java.util.*;

public class Main {

    static final int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};
    static final int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int R, C;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken()) - 1;
        int j = R - Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];
        int ans = bfs(j, i);
        System.out.println(ans == -1 ? "NEVAR" : ans);
    }

    private static int bfs(int tr, int tc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {R - 1, 0, 0});
        visited[R - 1][0] = true;
        int ans = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int cnt = cur[2];
            if (y == tr && x == tc) return cnt;
            for (int k = 0; k < 8; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx, cnt + 1});
            }
        }
        return ans;
    }
}
