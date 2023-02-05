import java.util.*;
import java.io.*;

class Solution {
    
    static int decode(int cur, HashSet set, int idx) { // 복호화 함수
        while (idx > 0) {
            cur += 1;
            // 반복문을 도는 중에도 cur 값을 체크해야 함.
            // 그렇지 않으면 완성된 cur이 skip에 있는 문자열인 경우도 존재하게 됨.
            if (cur > 'z') {
                cur = 97;
            }
            if (set.contains(cur)) {
                continue;
            }
            idx --;
        }
        return (cur > 'z') ? (cur - 'z') + 96 : cur;
    }
    
    public String solution(String s, String skip, int index) {
        String answer = "";

        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<skip.length(); i++) {
            set.add(skip.charAt(i) - 0);
        }
        
        for (int i=0; i<s.length(); i++) {
            int ret = decode(s.charAt(i) - 0, set, index);
            answer += (char) ret;
        }
        
        return answer;
    }
}
