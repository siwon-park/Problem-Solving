import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
r, c, d = map(int, input().split())
dydx = {0 : (-1, 0), 1 : (0, 1), 2 : (1, 0), 3 :(0, -1)}
board = []
for i in range(N):
    board.append(list(map(int, input().split())))
cleaned = [[False]*M for i in range(N)]
def rotate(cur_dir):
    if cur_dir == 0:
        return 3
    elif cur_dir == 1:
        return 0
    elif cur_dir == 2:
        return 1
    else:
        return 2
q = deque([(r, c, d)])
cleaned[r][c] = True
clean = 1
while q:
    cur_y, cur_x, cur_dir = q.popleft()
    og_dir = cur_dir
    for _ in range(4):
        turned = False
        temp_dir = rotate(cur_dir % 4)
        dy, dx = dydx[temp_dir]
        ny, nx = cur_y + dy, cur_x + dx
        if board[ny][nx] == 0:
            if not cleaned[ny][nx]:
                turned = True
                q.append((ny, nx, temp_dir))
                cleaned[ny][nx] = True
                clean += 1
                break
            else:
                cur_dir = temp_dir
        else:
            cur_dir = temp_dir
    cur_dir = og_dir
    if not turned:
        if board[cur_y + dydx[(cur_dir + 2) % 4][0]][cur_x + dydx[(cur_dir + 2) % 4][1]] == 0:
            q.append((cur_y + dydx[(cur_dir + 2) % 4][0], cur_x+dydx[(cur_dir + 2) % 4][1], cur_dir))
            if not cleaned[cur_y + dydx[(cur_dir + 2) % 4][0]][cur_x + dydx[(cur_dir + 2) % 4][1]]:
                cleaned[cur_y + dydx[(cur_dir + 2) % 4][0]][cur_x + dydx[(cur_dir + 2) % 4][1]] = True
                clean += 1
        else:
            break
print(clean)