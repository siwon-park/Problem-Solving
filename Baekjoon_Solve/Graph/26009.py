# 험난한 등굣길 (26009번)
#########################################################################################
    # 문제: https://www.acmicpc.net/problem/26009
    # BFS
    # 교통 정체가 일어나고 있는 지점을 기준으로 반경 D만큼을 방문하지 못하도록 하여 BFS 탐색을 하면 되는 문제이다.
    # 처음에는 어차피 집합형에서 in을 통해 요소를 확인하는 행동은 O(1)이 걸리니까 반경 안에 있는 모든 점을 다 담았는데
    # 시간 초과가 나서 다시 대각선에 있는 좌표들만 집합형에 담고 in을 통해 확인했다. 그런데도 시간초과가 났다.
    # 그래서 방문 배열에 좌표를 찍는 방식으로 문제를 접근하였다.
    # 찍어야할 좌표가 범위를 벗어나는지 아닌지 확인하고 visited 체크를 했다.
    # 오히려 시간초과가 안 나고 훨씬 더 빠르게 풀 수 있었다.
#########################################################################################
import sys
from collections import deque
input = sys.stdin.readline

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

N, M = map(int, input().split())
K = int(input())
lst = []
for _ in range(K):
    R, C, D = map(int, input().split())
    lst.append((R, C, D))


def check(lst):
    visited = [[0 for _ in range(M)] for _ in range(N)]
    visited[0][0] = 1
    for R, C, d in lst:
        r = R - 1
        c = C - 1
        visited[r][c] = 1
        for i in range(d):
            r1, c1 = r - d + i, c - i
            r2, c2 = r + d - i, c + i
            r3, c3 = r + i, c - d + i
            r4, c4 = r - i, c + d - i
            if 0 <= r1 < N and 0 <= c1 < M:
                visited[r1][c1] = 1
            if 0 <= r2 < N and 0 <= c2 < M:
                visited[r2][c2] = 1
            if 0 <= r3 < N and 0 <= c3 < M:
                visited[r3][c3] = 1
            if 0 <= r4 < N and 0 <= c4 < M:
                visited[r4][c4] = 1
    return visited


def bfs():
    q = deque([(0, 0, 0)])  # 거리, y, x
    while q:
        d, y, x = q.popleft()
        if (y, x) == (N - 1, M - 1):
            return d
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx]:
                visited[ny][nx] = 1
                q.append((d + 1, ny, nx))
    return 0


visited = check(lst)

ret = bfs()
if ret:
    print("YES")
    print(ret)
else:
    print("NO")
