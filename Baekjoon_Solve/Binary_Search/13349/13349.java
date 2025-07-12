import java.io.*;
import java.util.*;

// Millionaire Madness (13349번)
public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int N, M, diff; // 길이, 너비, 높이 차이
    static int[][] graph;

    static int parametricSearch() {
        int s = 0;
        int e = diff;
        int ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean flag = bfs(mid);
            if (flag) {
                ans = mid; // 최대 높이 차이 mid로 도달 가능
                e = mid - 1; // 더 작은 높이 차이로 이동 가능한지 확인
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    private static boolean bfs(int mid) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int h = graph[y][x]; // 현재 높이
            if (y == N - 1 && x == M - 1) return true;
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
                int nh = graph[ny][nx]; // 다음 높이
                if (h >= nh) {
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx});
                } else if (nh - h <= mid) { // 높이 차이가 mid 이하인 경우에만 이동 가능
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx});
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
        graph = new int[N][M];
        int _min = Integer.MAX_VALUE;
        int _max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                _min = Math.min(_min, graph[i][j]);
                _max = Math.max(_max, graph[i][j]);
            }
        }
        diff = _max - _min;
        int result = parametricSearch();
        System.out.println(result);
    }
}

