# 2의 멱수의 합 (2410번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
MOD = int(1e9)
dp = [0 for _ in range(N + 1)]
dp[1] = 1  # 1을 만드는 경우

for i in range(2, N + 1):
    if i % 2:
        dp[i] = dp[i - 1]
    else:
        dp[i] = dp[i - 1] + dp[i // 2]
    dp[i] %= MOD

print(dp[N])

