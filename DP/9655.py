# 돌 게임(9655번)
#################################################################
    # 문제: https://www.acmicpc.net/problem/9655
    # DP
    # 돌을 1개 또는 3개 가져갈 수 있으므로, dp[i-1] == "CY"이면 dp[i] = "SK"이고, dp[i-3] == "CY"이면 dp[i] = "SK"이다. (반대의 경우도 성립)
    # 돌을 1 ~ 3개 가져가는 것이 아님을 유의
#################################################################
import sys
input = sys.stdin.readline

N = int(input())
dp = [0] * 1001
dp[1] = dp[3] = "SK"
for i in range(1, N+1):
    if dp[i-1] == "SK":
        dp[i] = "CY"
    elif dp[i-1] == "CY":
        dp[i] = "SK"
    if i - 3 >= 0 and dp[i-3] == "CY":
        dp[i] = "SK"
    elif i - 3 >= 0 and dp[i-3] == "SK":
        dp[i] = "CY"
print(dp[N])
