import sys
from collections import deque
input = sys.stdin.readline


def bfs(r: int, c: int) -> None:
    q = deque([(r, c)])
    while q:
        y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < N:
                if not visited[ny][nx] and graph[ny][nx] == "*":
                    visited[ny][nx] = True
                    q.append((ny, nx))


dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
N = int(input().rstrip())
graph = []
for _ in range(N):
    graph.append(list(input().rstrip()))
visited = [[False for _ in range(N)] for _ in range(N)]
sector = 0

for i in range(N):
    for j in range(N):
        if not visited[i][j] and graph[i][j] == "*":
            visited[i][j] = True
            bfs(i, j)
            sector += 1

print(sector)
