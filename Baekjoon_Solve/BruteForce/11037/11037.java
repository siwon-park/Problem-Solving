// 중복 없는 수 (11037번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = Integer.MAX_VALUE;
	static int N, M, ans;
	static boolean[] used = new boolean[10];
	
	static void backtrack(int k, int cur) {
		if (cur > ans) return; // 현재 만들어진 최소 숫자보다 크면 return -> 컷팅
		if (k >= M) { // 자리수가 M개 이상일 때
			if (cur > N) { // 처음 숫자 N보다 크면
				ans = Math.min(ans,  cur);
			}
			if (k > M || k == 9) { // 자리수가 M + 1이거나 9이면 탐색 종료
				return;				
			}
		}
		
		for (int i = 1; i < 10; i++) {
			if (!used[i]) { // i를 사용하지 않았으면 사용함
				used[i] = true;
				backtrack(k + 1, cur * 10 + i);
				used[i] = false;
			}
		}
	}
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line;
        while ((line = br.readLine()) != null) {
        	N = Integer.parseInt(line);
        	M = line.length();
        	ans = MAX;
        	backtrack(0, 0);
        	if (ans == MAX) {
        		ans = 0;
        	}
        	bw.write(ans + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }
}