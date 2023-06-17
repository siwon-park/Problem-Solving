# 걷다보니 신천역 삼 (Small) (14650번)
import sys
input = sys.stdin.readline

# 각 인덱스는 3으로 나눴을 때의 나머지가 인덱스인 숫자의 개수
dp = [[0, 0, 0] for _ in range(10)]
dp[1] = [0, 1, 1]

for i in range(2, 10):
    dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]
    dp[i][1] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]
    dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]

N = int(input().rstrip())

print(dp[N][0])
