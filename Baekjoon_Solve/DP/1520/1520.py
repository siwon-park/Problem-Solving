import sys
sys.setrecursionlimit(10000)

input = sys.stdin.readline
M, N = map(int, input().split())
board = []
for _ in range(M):
    board.append(list(map(int,input().split())))

dp = [[-1] * N for i in range(M)]
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]


def dfs(y, x):
    if y == M - 1 and x == N - 1:
        return 1
    if dp[y][x] != -1:
        return dp[y][x]
    result = 0
    for dy, dx in dydx:
        ny, nx = y + dy, x + dx
        if 0 <= ny < M and 0 <= nx < N:
            if board[ny][nx] < board[y][x]:
                result += dfs(ny, nx)
    dp[y][x] = result
    return result


dfs(0, 0)
print(dp[0][0])
