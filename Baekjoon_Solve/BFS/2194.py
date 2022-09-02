# 유닛 이동시키기(2194번)
#########################################################################################
    # 문제: https://www.acmicpc.net/problem/2194
    # BFS
    # 유닛의 좌측 최상단의 좌표만 BFS로 탐색하되, 매번 해당 유닛의 크기만큼으로 격자판에서 이동할 수 있는지 check하였다.
    # 좌측 상단의 위치에서 유닛의 크기만큼이 범위를 벗어나거나, 유닛의 크기 안에 장애물의 좌표가 있으면 이동할 수 없기에 큐에 삽입하지 않았다
    # 시간 복잡도를 계산했을 때, 그리 효율적인 풀이는 아니었다. 왜냐하면 거의 완전 탐색 수준으로 다 탐색하기 때문이다.
    # 다른 효율적인 풀이를 보니까 zip, all 등을 사용해서 무엇인가 최적화를 해주고 있었다.
    # 생각해봤는데, 될지 안 될지 모르겠지만 장애물 좌표를 기준으로 AxB만큼 했을 때 방문하지 못하는 곳을 미리 계산해서 최적화를 할 수 없을까라는 생각이 든다(안 될 것 같기도?)
#########################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N, M, A, B, K = map(int, input().split())
obs = set()
for _ in range(K):
    obs.add(tuple(map(lambda x: int(x) - 1, input().split())))

sy, sx = map(lambda x: int(x) - 1, input().split())
ey, ex = map(lambda x: int(x) - 1, input().split())

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

# 유닛이 올바른 곳으로 이동했는지 체크하는 함수
def check(r, c):
    for dr in range(A):
        for dc in range(B):
            nr, nc = r + dr, c + dc
            if nr < 0 or nr >= N or nc < 0 or nc >= M or (nr, nc) in obs: # 유닛이 범위를 벗어나거나 장애물이 있으면 False
                return False
    return True

# BFS
def bfs():
    visited = [[False] * M for _ in range(N)]
    q = deque([(0, sy, sx)])
    visited[sy][sx] = True
    while q:
        d, y, x = q.popleft()
        if (y, x) == (ey, ex):
            return d
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx] and (ny, nx) not in obs:
                if check(ny, nx):
                    visited[ny][nx] = True
                    q.append((d + 1, ny, nx))

    return -1

print(bfs())
