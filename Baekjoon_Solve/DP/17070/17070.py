# 파이프 옮기기 1 (17070번)
import sys
input = sys.stdin.readline

N = int(input().rstrip()) # 집의 크기

dp = [[[0, 0, 0] for _ in range(N)] for _ in range(N)] # 가로, 세로, 대각선
dp[0][1][0] = 1 # 초기에 가로 방향으로 (1, 2) 차지하고 있음

graph = []
for i in range(N):
    graph.append(list(map(int, input().rstrip().split())))

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            continue
        # 가로 방향 -> 가로, 대각으로 갈 수 있음
        if j + 1 < N and graph[i][j + 1] != 1:
            dp[i][j + 1][0] += dp[i][j][0]
            dp[i][j + 1][0] += dp[i][j][2]
        # 세로 방향 -> 세로, 대각으로 갈 수 있음
        if i + 1 < N and graph[i + 1][j] != 1:
            dp[i + 1][j][1] += dp[i][j][1]
            dp[i + 1][j][1] += dp[i][j][2]
        # 대각선 방향 -> 가로, 세로, 대각으로 갈 수 있음
        if i + 1 < N and j + 1 < N:
            if graph[i + 1][j] != 1 and graph[i][j + 1] != 1 and graph[i + 1][j + 1] != 1:
                dp[i + 1][j + 1][2] += dp[i][j][0]
                dp[i + 1][j + 1][2] += dp[i][j][1]
                dp[i + 1][j + 1][2] += dp[i][j][2]

print(sum(dp[N - 1][N - 1]))