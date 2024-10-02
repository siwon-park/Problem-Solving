// 석유 시추
// 유형: BFS
import java.io.*;
import java.util.*;

class Solution {
    
    static final int[] dy = new int[] {-1, 0, 1, 0};
    static final int[] dx = new int[] {0, 1, 0, -1};
    
    static int N, M;
    static int[] oils;
    static boolean[][] visited;
    
    static void bfs(int r, int c, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visited[r][c] = true;
        HashSet<Integer> cols = new HashSet<>();
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int y = pair[0];
            int x = pair[1];
            cnt += 1;
            cols.add(x);
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                // System.out.println("ny, nx: " + ny + " " + nx);
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
                if (land[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx}); 
                }
            }
        }
        
        for (Integer col : cols) {
            oils[col] += cnt;
        }
        
        
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        N = n;
        M = m;
        visited = new boolean[n][m];
        oils = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    // System.out.println(i + " " + j);
                    bfs(i, j, land);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, oils[i]);
        }
        
        return answer;
    }
}
