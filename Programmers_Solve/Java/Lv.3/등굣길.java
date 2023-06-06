class Solution {

	static final int MOD = 1_000_000_007;
	
	public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];
        // 웅덩이 역시 (열, 행) 순서로 주어지므로 주의
        for (int i = 0; i < puddles.length; i++) dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        
        dp[0][0] = 1; // 집의 위치에서 집의 위치로 갈 수 있는 경우의 수는 1
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (dp[i][j] == -1 || (i == 0 && j == 0)) continue; // 웅덩이와 출발지는 무시
        		int up = 0;
        		int left = 0;
        		if (i - 1 >= 0 && dp[i - 1][j] != -1) up = dp[i - 1][j];
        		if (j - 1 >= 0 && dp[i][j - 1] != -1) left = dp[i][j - 1];
        		dp[i][j] = (up + left) % MOD;
        	}
        }
        
        answer = dp[n - 1][m - 1];
        return answer;
    }
}