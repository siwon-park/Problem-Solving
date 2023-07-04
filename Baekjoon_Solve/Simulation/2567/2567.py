# 색종이 - 2 (2567번)
import sys
from collections import deque
input = sys.stdin.readline

N = int(input().rstrip())
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
visited = [[0 for _ in range(102)] for _ in range(102)]

q = deque([])
_set = set()
for _ in range(N):
    a, b = map(int, input().rstrip().split())
    for i in range(a, a + 10):
        for j in range(b, b + 10):
            _set.add((i, j))
            visited[i][j] = -1

for _t in _set:
    q.append(_t)

while q:
    y, x = q.popleft()
    for k in range(4):
        ny = y + dydx[k][0]
        nx = x + dydx[k][1]
        if 0 <= ny < 102 and 0 <= nx < 102 and visited[ny][nx] != -1:
            visited[ny][nx] += 1

cnt = 0
for i in range(102):
    for j in range(102):
        if visited[i][j] != -1:
            cnt += visited[i][j]

print(cnt)