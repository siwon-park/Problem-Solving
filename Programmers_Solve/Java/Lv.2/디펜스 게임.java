/*
  문제: https://school.programmers.co.kr/learn/courses/30/lessons/142085
  우선순위 큐의 size를 k로 유지하면서 size가 k보다 커질 경우
  우선순위 큐에서 요소를 뽑아서 n에서 차감시켜준다.
  n이 0보다 작으면 answer를 return한다.
  만약 for구문을 빠져나오면 게임을 끝까지 돈 것이므로 enemy 배열의 크기를 return한다.
*/

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer e : enemy) {
            pq.add(e);
            if (pq.size() > k) {
                n -= pq.poll();
            }
            if (n < 0) {
                return answer;
            }
            answer += 1;
        }
        return enemy.length;
    }
}
