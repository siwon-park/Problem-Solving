import java.util.*;

class Solution {
    
    static boolean flag = false;
    static int cnt = 0;
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        
        for(int n : queue1) {
            sum1 += (long) n;
            q1.offer((long)n);
        }
        for(int n : queue2) {
            sum2 += (long) n;
            q2.offer((long)n);
        }
        
        if ((sum1 + sum2) % 2 != 0) return -1;
        long half = (sum1 + sum2) / 2;
        int count = 0;
        while (!q1.isEmpty()) {
        	if (sum1 == half) return count;
        	if (count > (q1.size() + q2.size()) * 2) return -1;
        	if (sum1 < half) {
            	long cur = q2.poll();
            	q1.add(cur);
            	sum1 += cur;
        	} else if (sum1 > half) {
            	long cur = q1.poll();
            	q2.add(cur);
            	sum1 -= cur;
        	}
        	count += 1;
        }
        if (sum1 != half) return -1;
        answer = count;
        return answer;
    }
}
