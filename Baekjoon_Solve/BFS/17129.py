# 윌리암슨수액빨이딱다구리가 정보섬에 올라온 이유(17129번)
################################################################################
    # 문제: https://www.acmicpc.net/problem/17129
    # BFS
    # 평이한 최단거리를 구하는 BFS문제이다.
    # 처음에 그냥 board[i][j] == 2이면 큐를 만들고 break 또는 return하게 구성했으나, 자꾸 인덱스 에러가 떠서 왜 그런가하고 봤더니
    # 코드 구조상 2가 나오면 바로 반복을 종료하니까 board를 완전히 다 입력받지 않은 상태이기 때문에 인덱스 에러가 날 수 밖에 없었다.
    # 이 문제는 Python3로는 풀 수 없어서 Pypy3로 풀었고, 혹시 flag를 활용한 for문 break로 더 빨리 풀 수 있지 않을까 생각해서 시도해봤는데
    # 8ms밖에 개선을 하지 못하였다.
################################################################################
import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
board = []
visited = [[0]*m for _ in range(m)]
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

flag = False
for i in range(n):
    board.append(list(map(int, input().rstrip())))
    if not flag:
        for j in range(m):
            if board[i][j] == 2:
                q = deque([(0, i, j)])
                visited[i][j] = -1
                break

def bfs(q):
    while q:
        d, y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < n and 0 <= nx < m:
                if visited[ny][nx] == 0 and board[ny][nx] != 1:
                    visited[ny][nx] = d + 1
                    q.append((d + 1, ny, nx))
                    if board[ny][nx] != 0:
                        return d + 1
    return -1

ret = bfs(q)
if ret == -1:
    print("NIE")
else:
    print("TAK")
    print(ret)
