import sys
from collections import deque

input = sys.stdin.readline

# Robots on a grid (5011번)
mod = 2**31 - 1
n = int(input().rstrip())
dp = [[0 for _ in range(n + 1)]]
for _ in range(n):
    line = input().rstrip()
    lst = [0]
    for c in line:
        if c == '.':
            lst.append(0)
        else:
            lst.append(-1)
    dp.append(lst)


dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
def bfs(w: int) -> bool:
    global dy, dx, dp, n
    visited = [[False for _ in range(n + 1)] for _ in range(n + 1)]
    queue = deque([(1, 1)])
    visited[1][1] = True
    while queue:
        y, x = queue.popleft()
        for k in range(w):
            ny = y + dy[k]
            nx = x + dx[k]
            if 1 <= ny <= n and 1 <= nx <= n and dp[ny][nx] != -1 and not visited[ny][nx]:
                visited[ny][nx] = True
                queue.append((ny, nx))
    return visited[n][n]

right_down = bfs(2)
all_the_way = bfs(4)

if right_down:
    dp[1][1] = 1
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if dp[i][j] == -1:
                continue
            dp[i][j] += (dp[i - 1][j] if dp[i - 1][j] != -1 else 0) + (dp[i][j - 1] if dp[i][j - 1] != -1 else 0)
            dp[i][j] %= mod
    print(dp[n][n] % mod)
elif not right_down and all_the_way:
    print("THE GAME IS A LIE")
elif not all_the_way:
    print("INCONCEIVABLE")

