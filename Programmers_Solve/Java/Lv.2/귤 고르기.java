// 귤 고르기(Lv.2)
//////////////////////////////////////////////////////////////////////////////
  // 문제: https://school.programmers.co.kr/learn/courses/30/lessons/138476
  // 그리디
  // 각 등급의 등장 개수를 카운트한 다음, 해당 카운트 개수를 담은 배열을 정렬하고나서
  // 그리디하게 선택하면 등급의 최소 개수가 된다.
//////////////////////////////////////////////////////////////////////////////
import java.util.*;

class Solution {
    static Map<Integer, Integer> count = new HashMap<>();

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int N = tangerine.length;
        for (int i=0; i<N; i++) {
            int tang = tangerine[i];
            if (count.get(tang) == null) {
                count.put(tang, 1);
            } else {
                int curValue = count.get(tang);
                count.put(tang, curValue + 1);
            }
        }
        
        List<Integer> valueList = new ArrayList<>(count.values());
        valueList.sort(Comparator.reverseOrder());
        int M = valueList.size();
        int sum = 0;
        for (int i=0; i<M; i++) {
            int cnt = valueList.get(i);
            sum += cnt;
            if (sum >= k) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}
