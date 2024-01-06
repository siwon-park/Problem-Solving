# 도로의 개수 (1577번)
import sys
input = sys.stdin.readline

dp = [[0 for _ in range(105)] for _ in range(105)]
N, M = map(int, input().rstrip().split())
K = int(input().rstrip())
road_set = set()
for _ in range(K):
    a, b, c, d = map(int, input().rstrip().split())
    road_set.add((a, b, c, d))
    road_set.add((c, d, a, b))

dp[0][0] = 1  # 출발지는 1
for r in range(N + 1):
    for c in range(M + 1):
        if (r, c, r + 1, c) not in road_set:
            dp[r + 1][c] += dp[r][c]
        if (r, c, r, c + 1) not in road_set:
            dp[r][c + 1] += dp[r][c]

print(dp[N][M])
