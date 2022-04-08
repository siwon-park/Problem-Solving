# 쉬운 최단거리(14940번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/14940
    # BFS
    # 최단 거리 테이블의 초깃값은 전부 -1로 두고 board를 입력 받으면서 board[i][j]가 0이면 distance[i][j]도 0으로 설정했다.
    # 그리고 BFS를 돌려서 최단 거리를 기록하면 된다.
##########################################################################
import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
q = deque()
board = []
distance = [[-1]*m for _ in range(n)]
for i in range(n):
    board.append(list(map(int, input().split())))
    for j in range(m):
        if board[i][j] == 2:
            q.append((0, i, j))
        elif board[i][j] == 0:
            distance[i][j] = 0

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def bfs():
    while q:
        d, y, x = q.popleft()
        distance[y][x] = d
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < n and 0 <= nx < m:
                if board[ny][nx] and distance[ny][nx] == -1:
                    distance[ny][nx] = d+1
                    q.append((d+1, ny, nx))
    return distance

dist = bfs()

for lst in dist:
    print(*lst)
