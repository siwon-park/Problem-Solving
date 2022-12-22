import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙 적용(직접 구현한 class의 경우 정렬 조건을 Override해줘야함)
        for (int work : works) {
            maxHeap.add(work);
        }

        while (n > 0) {
            int maxNum = maxHeap.poll();
            int num = Math.max(maxNum - 1, 0); // (maxNum - 1 <= 0) ? 0 : maxNum - 1;
            maxHeap.add(num);
            n--;
        }

        while (!maxHeap.isEmpty()) {
            answer += (long) Math.pow(maxHeap.poll(), 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] works1 = {4, 3, 3};
        System.out.println(sol.solution(4, works1));
    }

}
