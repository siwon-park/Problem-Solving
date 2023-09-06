# 피보나치 (9711번)
import sys
input = sys.stdin.readline

dp = [-1] * 10001
dp[0], dp[1] = 0, 1
for i in range(2, 10001):
    dp[i] = dp[i - 1] + dp[i - 2]

T = int(input().rstrip())
for tc in range(1, T + 1):
    P, Q = map(int, input().rstrip().split())
    print(f'Case #{tc}: {dp[P] % Q}')
