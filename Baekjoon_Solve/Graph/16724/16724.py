import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]

dydx_dict = {"D": (1, 0), "L": (0, -1), "R": (0, 1), "U": (-1, 0)}

def dfs(y, x, area):
    global cnt
    visited[y][x] = area
    dy, dx = dydx_dict[board[y][x]]
    ny, nx = y + dy, x + dx
    if 0 <= ny < N and 0 <= nx < M:
        if not visited[ny][nx]:
            dfs(ny, nx, area)
        elif visited[ny][nx] == area:
            cnt += 1

visited = [[False]*M for _ in range(N)]

cnt = 0
area = 1
for r in range(N):
    for c in range(M):
        if not visited[r][c]:
            dfs(r, c, area)
            area += 1

print(cnt)