# 현명한 나이트(18404번)
######################################################################
    # 문제: https://www.acmicpc.net/problem/18404
    # BFS
    # 평범한 BFS 문제, 입력 받은 적의 좌표까지의 최단 거리를 출력하면 된다.
    # 문제를 제대로 안 읽고 바로 들어가서 처음에 입력 부분을 구성하는데 시간을 조금 낭비했다.
######################################################################
import sys
from collections import deque
input = sys.stdin.readline

dydx = [(-2, -1), (-1, -2), (-2, 1), (-1, 2), (2, -1), (1, -2), (2, 1), (1, 2)] 

N, M = map(int, input().split())
board = [[0]*N for _ in range(N)]
y, x = map(lambda x: int(x) - 1, input().split())
board[y][x] = -1

q = deque([(0, y, x)])

lst = []
for _ in range(M):
    i, j = map(lambda x: int(x) - 1, input().split())
    lst.append((i, j))

def bfs():
    while q:
        d, y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < N:
                if not board[ny][nx]:
                    board[ny][nx] = d + 1
                    q.append((d + 1, ny, nx))

bfs()

for i, j in lst:
    print(board[i][j], end = " ")
