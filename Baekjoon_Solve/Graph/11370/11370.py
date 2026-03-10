import sys
from collections import deque

input = sys.stdin.readline

# Spawn of Ungoliant (11370번)
dydx = [(-1, 0), (1, 0), (0, -1), (0, 1)]
while True:
    w, h = map(int, input().rstrip().split())
    if w == 0 and h == 0:
        break
    graph = [list(input().rstrip()) for _ in range(h)]
    queue = deque([])
    for i in range(h):
        for j in range(w):
            if graph[i][j] == "S":
                queue.append((i, j))
    while queue:
        y, x = queue.popleft()
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < h and 0 <= nx < w and graph[ny][nx] == "T":
                graph[ny][nx] = "S"
                queue.append((ny, nx))

    for i in range(h):
        print("".join(graph[i]))

