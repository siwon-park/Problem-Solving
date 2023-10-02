# 탈출 (3055번)
import sys
from collections import deque
input = sys.stdin.readline
R, C = map(int, input().split())
board = []
sonic, beaver_home, water = [] ,[], set()
for i in range(R):
    board.append(list(input().rstrip()))
    for j in range(C):
        if board[i][j] == "S":
            sonic.append((i, j, 0))
        elif board[i][j] == "D":
            beaver_home.append((i, j))
        elif board[i][j] == "*":
            water.add((i, j))
dydx=[(-1, 0), (0, 1), (1, 0), (0, -1)]


def water_spread(water):
    next_water = set()
    while water:
        y, x = water.pop()
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < R and 0 <= nx < C:
                if board[ny][nx] == "." or board[ny][nx] == "S":
                    next_water.add((ny, nx))
    return next_water


def escape(board, sonic, water):
    visited = [[False] * C for i in range(R)]
    while water or sonic:
        n_water = water_spread(water)
        n_sonic = []
        for sy, sx, sm in sonic:
            visited[sy][sx] = True
            for dy, dx in dydx:
                nsy, nsx = sy + dy, sx + dx
                if 0 <= nsy < R and 0 <= nsx < C:
                    if not visited[nsy][nsx]:
                        if board[nsy][nsx] == ".":
                            if (nsy, nsx) not in n_water:
                                n_sonic.append((nsy, nsx, sm + 1))
                                visited[nsy][nsx] = True
                        elif board[nsy][nsx] == "D":
                            return sm + 1
            board[sy][sx] = "."
        for wy, wx in n_water:
            board[wy][wx] = "*"
        water = n_water
        sonic = n_sonic
    return "KAKTUS"

print(escape(board, sonic, water))