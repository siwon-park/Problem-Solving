# 최고의 팀 만들기 (1633번)
import sys
input = sys.stdin.readline

lst = []
while True:
    try:
        W, B = map(int, input().rstrip().split())
        lst.append((W, B))
    except:
        break

n = len(lst)
dp = [[[0 for _ in range(16)] for _ in range(16)] for _ in range(n + 1)]

for i in range(n):
    for j in range(16):
        for k in range(16):
            if j + 1 <= 15:
                dp[i + 1][j + 1][k] = max(dp[i + 1][j + 1][k], dp[i][j][k] + lst[i][0])
            if k + 1 <= 15:
                dp[i + 1][j][k + 1] = max(dp[i + 1][j][k + 1], dp[i][j][k] + lst[i][1])
            dp[i + 1][j][k] = max(dp[i + 1][j][k], dp[i][j][k])

print(dp[n][15][15])