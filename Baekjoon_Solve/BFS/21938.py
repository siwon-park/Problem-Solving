# 영상처리(21938번)
################################################################################
    # 문제: https://www.acmicpc.net/problem/21938
    # BFS
    # 영역을 찾는 것과 유사한 평범한 BFS문제이지만, 그래프를 탐색하기 위해서 사전에 입력받은 그래프를 새롭게 만드는 작업이 필요하다.
    # 입력 받은 그래프를 만들고나면 255인 값에 대해서 BFS를 실시하면 된다.
################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = [[] for _ in range(N)]

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
visited = [[False]*M for _ in range(N)]

def bfs(q):
    while q:
        y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < M:
                if board[ny][nx] == 255 and not visited[ny][nx]:
                    visited[ny][nx] = True
                    q.append((ny, nx))

for i in range(N):
    lst = list(map(int, input().split()))
    for j in range(M):
        board[i].append((lst[3*j], lst[3*j+1], lst[3*j+2]))

T = int(input())

for i in range(N):
    for j in range(M):
        if sum(board[i][j])/3 >= T:
            board[i][j] = 255
        else:
            board[i][j] = 0

cnt = 0
for i in range(N):
    for j in range(M):
        if board[i][j] == 255 and not visited[i][j]:
            visited[i][j] = True
            cnt += 1
            q = deque([(i, j)])
            bfs(q)

print(cnt)
            
