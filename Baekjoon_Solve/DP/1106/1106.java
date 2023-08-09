// 호텔 (1106번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); // 늘려야 하는 고객 수
		int N = Integer.parseInt(st.nextToken()); // 방문 가능한 도시 수
		
		// 배수만큼 증가시켜 선택할 수 있으므로, C에 도달하기 전까지 N개의 도시 내에서 계속 선택해도 되므로 1차원의 DP로 선언
		int[] dp = new int[C + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		Pair[] pairs = new Pair[N + 1];
		int person, cost;
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			cost = Integer.parseInt(st.nextToken()); // 투자 비용
			person = Integer.parseInt(st.nextToken()); // 인원수 증가량
			pairs[i] = new Pair(person, cost);
			// C가 person보다 작을 수도 있기 때문에 Math.min(C, person)의 인덱스를 갱신시켜줘야 함
			dp[Math.min(C, person)] = Math.min(dp[Math.min(C, person)], cost);
		}
		
		for (int c = 1; c < C + 1; c++) {
			for (int n = 1; n < N + 1; n++) {
				Pair pair = pairs[n];
				dp[c] = Math.min(dp[Math.max(c - pair.p, 0)] + pair.c, dp[c]);			
			}
		}
		
		bw.write(dp[C] + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}


class Pair {
	int p;
	int c;
	
	Pair(int p, int c) {
		this.p = p;
		this.c = c;
	}
}