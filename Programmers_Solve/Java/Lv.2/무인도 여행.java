// Lv2. 무인도 여행
/*
  BFS, 정렬
  기초적인 BFS문제라서 따로 풀이는 
*/
import java.io.*;
import java.util.*;

class Solution {
    
    static class Pair {
        int y;
        int x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static int bfs(String[] maps, int y, int x) {
        int ret = Integer.parseInt(maps[y].charAt(x) + "");
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(y, x));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int k=0; k<4; k++) {
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (!visited[ny][nx] && maps[ny].charAt(nx) != 'X') {
                        queue.add(new Pair(ny, nx));
                        visited[ny][nx] = true;
                        ret += Integer.parseInt(maps[ny].charAt(nx) + "");
                    }
                }
            }
        }
        return ret;
    }
    
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    static int N, M;
    static boolean[][] visited;
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        visited = new boolean[N][M];
        
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    int ret = bfs(maps, i, j);
                    temp.add(ret);
                }
            }
        }
        
        int K = temp.size();
        int[] answer;
        if (K == 0) {
            answer = new int[K + 1];
            answer[0] = -1;
        } else {
            answer = new int[K];
            for (int i=0; i<K; i++) {
                answer[i] = temp.get(i);
            }
            Arrays.sort(answer);
        }
        
        return answer;
    }
}
