# 벽 부수고 이동하기 2(14442번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/14442
    # BFS
    # 다 풀고 효율성을 위해 개선을 시도했으나 크게 나아지는 부분은 없었다. (6504ms -> 5812ms)(목표 시간은 3000ms대였음)
    # 벽 뚫고 지나가기의 업그레이드 버전이며,
    # 최대 K개까지 뚫고 지나갈 수 있으므로 K+1개의 리스트를 1차원 요소로 가지는 3차원의 배열을 선언해서 해결하면 된다.
###############################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M, K = map(int, input().split())
board = [list(map(int, input().rstrip())) for _ in range(N)]
visited = [[[0] * (K + 1) for j in range(M)] for i in range(N)]

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def bfs():
    q = deque([(0, 0, 0)]) # 벽뚫은 횟수, y좌표, x좌표
    visited[0][0] = [1] * (K + 1)
    while q:
        k, y, x = q.popleft()
        if y == N-1 and x == M-1:
            return visited[y][x][k]
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx][k]:
                if not board[ny][nx]:
                    visited[ny][nx][k] = visited[y][x][k] + 1
                    q.append((k, ny, nx))
                elif k < K and not visited[ny][nx][k+1]:
                    visited[ny][nx][k+1] = visited[y][x][k] + 1
                    q.append((k+1, ny, nx))
    return -1

print(bfs())
