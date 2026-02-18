import sys
from collections import deque

input = sys.stdin.readline

# Red and Black (4993번)
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def bfs(y:int, x: int) -> int:
    global board, w, h
    ans = 1
    visited = [[False] * w for _ in range(h)]
    visited[y][x] = True
    queue = deque([(y, x)])
    while queue:
        cur_y, cur_x = queue.popleft()
        for dy, dx in dydx:
            ny, nx = cur_y + dy, cur_x + dx
            if 0 <= ny < h and 0 <= nx < w and not visited[ny][nx] and board[ny][nx] != '#':
                visited[ny][nx] = True
                ans += 1
                queue.append((ny, nx))
    return ans

while True:
    w, h = map(int, input().rstrip().split())
    if w == 0 and h == 0:
        break
    board = []
    sy, sx = 0, 0
    for i in range(h):
        lst = list(input().rstrip())
        for j in range(w):
            if lst[j] == '@':
                sy, sx = i, j
        board.append(lst)
    print(bfs(sy, sx))

