import java.io.*;
import java.util.*;

class Solution {
    
    static boolean isPrime(long num) {
        long sqrt = Math.round(Math.sqrt(num));
        for (int i = 2; i <= sqrt + 1; i++) {
            if (i < num && num % i == 0) return false;
        }
        return true;
    }
    
    // n을 k진수로 변경함
    static ArrayList<Long> kthNumChanger(int n, int k) {
        int num = n;
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            int r = num % k;
            num /= k;
            stack.push(r);
        }
        
        ArrayList<Long> arrayList = new ArrayList<>();
        long cur = 0;
        while (!stack.isEmpty()) {
            int m = stack.pop();
            if (m == 0) {
                if (cur != 0) arrayList.add(cur);
                cur = 0;
            } else {
                cur *= 10;
                cur += m;
            }
        }
        
        if (cur != 0) {
            arrayList.add(cur);
        }
        
        return arrayList;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        // eratos();
        ArrayList<Long> arrayList = kthNumChanger(n, k);
        for (Long num : arrayList) {
            // System.out.println(num);
            if (isPrime(num) && num != 1) {
                // System.out.println("true");
                answer += 1;
            }
        }
        return answer;
    }
    
}
