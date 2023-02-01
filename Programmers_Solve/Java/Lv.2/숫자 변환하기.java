// 숫자 변환하기
/*
  문제: https://school.programmers.co.kr/learn/courses/30/lessons/154538
  BFS
  BFS 탐색으로 x를 y로 변환할 수 있는 최소 변환횟수를 찾으면 된다.
*/
import java.util.*;
import java.io.*;

class Solution {
    
    static class Pair {
        int cnt;
        int cur;
        Pair(int cnt, int cur) {
            this.cnt = cnt;
            this.cur = cur;
        }
    }
    
    static int bfs(int cur, int target, int n) {
        if (cur == target) {
            return 0;
        }
        visited[cur] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, cur));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.cur == target) {
                return pair.cnt;
            }
            if (pair.cur + n <= target && !visited[pair.cur + n]) {
                visited[pair.cur + n] = true;
                queue.add(new Pair(pair.cnt + 1, pair.cur + n));
            }
            if (pair.cur * 2 <= target && !visited[pair.cur * 2]) {
                visited[pair.cur * 2] = true;
                queue.add(new Pair(pair.cnt + 1, pair.cur * 2));
            }
            if (pair.cur * 3 <= target && !visited[pair.cur * 3]) {
                visited[pair.cur * 3] = true;
                queue.add(new Pair(pair.cnt + 1, pair.cur * 3));
            }
        }
        
        return -1;
    }
    
    static boolean[] visited;
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        visited = new boolean[y + 1];
        answer = bfs(x, y, n);
        return answer;
    }
}
