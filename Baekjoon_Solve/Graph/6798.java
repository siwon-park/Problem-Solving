// Knight Hop (6798번)
import java.io.*;
import java.util.*;

public class Main {

    static final int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};
    static final int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken()) - 1;
        int sc = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        int tr = Integer.parseInt(st.nextToken()) - 1;
        int tc = Integer.parseInt(st.nextToken()) - 1;
        System.out.println(bfs(sr, sc, tr, tc));
    }

    private static int bfs(int sr, int sc, int tr, int tc) {
        boolean[][] visited = new boolean[8][8];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc, 0});
        visited[sr][sc] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int cnt = cur[2];
            if (y == tr && x == tc) return cnt;
            for (int k = 0; k < 8; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= 8 || nx < 0 || nx >= 8 || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx, cnt + 1});
            }
        }
        return ans;
    }
}
