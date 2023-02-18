# 로봇(1726번)
#########################################################
    # 문제: https://www.acmicpc.net/problem/1726
    # BFS, 그래프 이론
    # 문제를 제대로 안 읽어서 디버깅에 많은 시간을 썼다.
    # 우선 동1, 서2, 남3, 북4라는 것을 기억해야하고, 방향 전환은 360도 할 수 있는게 아니라 왼, 오 90도로만 가능하다.
    # 또한 좌표에서 세로는 M, 가로는 N이며, (0,0)부터 시작하지 않고, (1,1)부터 시작한다.
#########################################################
import sys
from collections import deque
input = sys.stdin.readline

dydx = [(0, 1),  (0, -1), (1, 0), (-1, 0)] # 동1, 서2, 남3, 북4

M, N = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(M)]
sy, sx, sw = map(int, input().split())
ty, tx, tw = map(int, input().split())

INF = sys.maxsize
visited = [[[INF, INF, INF, INF] for j in range(N)] for _ in range(M)]

q = deque([(0, sy-1, sx-1, sw-1)])
visited[sy-1][sx-1][sw-1] = 0
while q:
    ord_cnt, y, x, w = q.popleft()
    if (y, x, w) == (ty-1, tx-1, tw-1):
        print(ord_cnt)
        break
    # 방향만 전환함
    if w == 0 or w == 1:
        if ord_cnt + 1 < visited[y][x][2]:
            q.append((ord_cnt+1, y, x, 2))
            visited[y][x][2] = ord_cnt + 1
        if ord_cnt + 1 < visited[y][x][3]:
            q.append((ord_cnt+1, y, x, 3))
            visited[y][x][3] = ord_cnt + 1
    elif w == 2 or w == 3:
        if ord_cnt + 1 < visited[y][x][0]:
            q.append((ord_cnt+1, y, x, 0))
            visited[y][x][0] = ord_cnt + 1
        if ord_cnt + 1 < visited[y][x][1]:
            q.append((ord_cnt+1, y, x, 1))
            visited[y][x][1] = ord_cnt + 1

    # k만큼 이동함(방향 전환 없이)
    dy, dx = dydx[w]
    for k in range(1, 4):
        ny, nx = y+dy*k, x+dx*k
        if 0 <= ny < M and 0 <= nx < N:
            if board[ny][nx] == 1:
                break
            if board[ny][nx] == 0 and ord_cnt + 1 < visited[ny][nx][w]:
                visited[ny][nx][w] = ord_cnt + 1
                q.append((ord_cnt+1, ny, nx, w))
