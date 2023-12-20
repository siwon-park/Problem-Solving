# 크리보드 (11058번)
import sys
input = sys.stdin.readline

dp = [0] * 101  # i번째까지 눌렀을 때의 최댓값
N = int(input().rstrip())
dp[1], dp[2], dp[3] = 1, 2, 3

for i in range(4, N + 1):
    dp[i] = max(i, dp[i - 1] + 1)  # i번 누름, i - 1번 눌렀을 때의 최댓값 + 1
    for j in range(4, i + 1):
        dp[i] = max(dp[i], dp[j - 4] * 2 + dp[j - 4] * (i - j + 1))

print(dp[N])
