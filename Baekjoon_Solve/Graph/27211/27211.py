import sys
from collections import deque
input = sys.stdin.readline


def bfs(r: int, c: int):
    q = deque([(r, c)])
    visited[r][c] = True
    while q:
        y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = (y + dy + N) % N, (x + dx + M) % M
            if graph[ny][nx] == 0 and not visited[ny][nx]:
                visited[ny][nx] = True
                q.append((ny, nx))
    return


dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
N, M = map(int, input().rstrip().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().rstrip().split())))
visited = [[False for _ in range(M)] for _ in range(N)]

cnt = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0 and not visited[i][j]:
            bfs(i, j)
            cnt += 1

print(cnt)