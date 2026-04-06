import sys
from collections import deque

input = sys.stdin.readline

# Invasion of the Milkweed (5993번)
dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, 1, 1, 1, 0, -1, -1, -1]
X, Y, Mx, My = map(int, input().rstrip().split())
dots = 0
graph = [list(input().rstrip()) for _ in range(Y)]
visited = [[False] * X for _ in range(Y)]
Mx -= 1
My = Y - My

for i in range(Y):
    for j in range(X):
        if graph[i][j] == ".":
            dots += 1

queue = deque([(My, Mx)])
graph[My][Mx] = "M"
visited[My][Mx] = True
ans = 0
while queue:
    size = len(queue)
    for _ in range(size):
        y, x = queue.popleft()
        for k in range(8):
            ny, nx = y + dy[k], x + dx[k]
            if 0 <= ny < Y and 0 <= nx < X and graph[ny][nx] == "." and not visited[ny][nx]:
                visited[ny][nx] = True
                graph[ny][nx] = "M"
                queue.append((ny, nx))
    ans += 1

print(ans - 1)
