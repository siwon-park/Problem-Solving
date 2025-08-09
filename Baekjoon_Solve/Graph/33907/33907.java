import java.io.*;
import java.util.*;

// 투명 스프레이 (33907번)
public class Main {

    static final int[] dy = {0, -1, 0, 1};
    static final int[] dx = {-1, 0, 1, 0};
    static int N, M, K;
    static int[][] F;

    static int parametricSearch(int max) {
        int s = 0;
        int e = max;
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            boolean flag = bfs(mid);
            if (flag) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    static boolean bfs(int x) {
        boolean[][] visited = new boolean[N][M];
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[] {0, 0, 0});
        visited[0][0] = true;
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int r = cur[0];
            int c = cur[1];
            int k = cur[2];
            if (r == N - 1 && c == M - 1) return true;
            for (int d = 0; d < 4; d++) {
                int nr = r + dy[d];
                int nc = c + dx[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
                if (F[nr][nc] > x && k + 1 <= K) {
                    visited[nr][nc] = true;
                    deque.addLast(new int[] {nr, nc, k + 1});
                } else if (F[nr][nc] <= x) {
                    visited[nr][nc] = true;
                    deque.addFirst(new int[] {nr, nc, k});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        F = new int[N][M];
        int _max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                F[i][j] = Integer.parseInt(st.nextToken());
                _max = Math.max(_max, F[i][j]);
            }
        }

        int ans = parametricSearch(_max);
        System.out.println(ans);
    }
}
