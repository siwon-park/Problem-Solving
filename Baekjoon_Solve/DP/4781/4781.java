// 사탕 가게 (4781번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static Pair[] pairs;
	static int[] dp = new int[10001];
	
	static void init(int n) {
		Arrays.fill(dp, 0);
		pairs = new Pair[n + 1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 사탕 종류의 수
			String tmp = st.nextToken();
			
			if (n == 0 && tmp.equals("0.00")) {
				break;
			}
			
			String[] splitTmp = tmp.split("\\.");
			m = Integer.parseInt(splitTmp[0]) * 100 + Integer.parseInt(splitTmp[1]); // 돈의 양의 100배
			
			init(n);
			for (int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				splitTmp = st.nextToken().split("\\.");
				int p = Integer.parseInt(splitTmp[0]) * 100 + Integer.parseInt(splitTmp[1]); // 가격의 100배
				pairs[i] = new Pair(c, p);
			}
			
			for (int i = 1; i < n + 1; i++) {
				Pair pair = pairs[i];
				for (int j = 1; j < m + 1; j++) {
					if (j - pair.p >= 0) {
						dp[j] = Math.max(dp[j - pair.p] + pair.c, dp[j]);
					} else {
						dp[j] = dp[j];
					}
				}
			}

			bw.write(dp[m] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int c, p;
	Pair(){};
	Pair(int c, int p) {
		this.c = c;
		this.p = p;
	}
}