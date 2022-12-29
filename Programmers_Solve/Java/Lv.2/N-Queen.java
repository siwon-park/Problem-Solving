// N-Queen
/*
  문제: https://school.programmers.co.kr/learn/courses/30/lessons/12952?language=java
  백트랙킹
  비효율적으로 문제를 풀고 있었다.
  어차피 N-Queen에서 각 행은 함수의 인자로 컨트롤할 수 있고,
  각 열은 하나밖에 두지 못하니까 방문 배열을 통해서 체크하는 것이 더 빠르다.
  또한 굳이 2차원의 배열을 선언할 필요도 없이 1차원으로도 해결이 가능하다.
  대각선 체크 역시 마찬가지로 1차원의 배열 선에서 해결이 가능하다.
  num == board[row - col] - col || num == board[row - col] + col
  board에는 넣은 열의 번호를 넣는다. 그러면 col을 1부터 row까지 돌면서 board[row - col]에 있는 값에 +-col을 했을 때
  지금 넣으려는 열의 위치인 num과 같다면, 넣지 못한다.
  지금까지 절댓값을 통해서만 체크하는 방법만 알고 있었는데, 새로운 방법을 알게 되었다.
*/

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
    
    static boolean check(int r, int c) {
        for (Pair pair : stack) {
            int y = pair.y;
            int x = pair.x;
            if (x == c) {
                return false;
            }
            else if (Math.abs(r - y) == Math.abs(c - x)) {
                return false;
            }
        }
        return true;
    }
    
    static void dfs(int row) {
        if (row == N) {
            answer += 1;
            return;
        }
        
        for (int i=0; i<N; i++) {
            if (check(row, i)) {
                stack.push(new Pair(row, i));
                graph[row][i] = true;
                dfs(row + 1);
                stack.pop();
                graph[row][i] = false;
            }
        }
    }
    
    static int answer, N;
    static Stack<Pair> stack = new Stack<>();
    static boolean[][] graph;
    
    public int solution(int n) {
        graph = new boolean[n][n];
        N = n;
        dfs(0);
        
        return answer;
    }
}
