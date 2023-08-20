// 2000문제 푼 임스 (25822번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		double C = Double.parseDouble(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int S = 1; // 사용할 수 있는 스트릭 프리즈의 수 -> 안댁스로 사용할 예정이니 +1씩 더함
		if (C >= 1.98) S = 3;
		else if (C >= 0.99) S = 2;
		
		
		int[][] dp = new int[N + 1][S];

		int max = 0;
		int len = 0;
		for (int i = 1; i < N + 1; i++) {
			int solved = arr[i]; // 푼 문제 수
			max = Math.max(max, solved);
			if (solved > 0) { // 현재 일에 푼 문제 수가 0보다 크면 최댓값은 현재 푼 문제 수이고, 최대 스트릭은 1임
				dp[i][0] = 1;
				for (int j = 0; j < S; j++) dp[i][j] = dp[i - 1][j] + 1; // 길이 갱신
			} else if (solved == 0) {
				dp[i][0] = 0; // 스트릭을 쓰지 않는 경우
				if (S >= 2) dp[i][1] = dp[i - 1][0] + 1; // 사용 가능 스트릭이 1이상
				if (S >= 3) dp[i][2] = dp[i - 1][1] + 1; // 사용 가능 스트릭이 2이상
			}
			
			for (int j = 0; j < S; j++) {
				if (len < dp[i][j]) len = dp[i][j];
			}
		}
		
		bw.write(len + "\n");
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}