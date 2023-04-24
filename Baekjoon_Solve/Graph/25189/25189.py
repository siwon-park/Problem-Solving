import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split()) # N x M 격자판
rf, cf, rh, ch = map(lambda x: int(x) - 1, input().split())
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
graph = []
for i in range(N):
    graph.append(list(map(int, input().split())))

visited = [[[False, False] for _ in range(M)] for _ in range(N)]
visited_row = [False] * N # 해당 행에서 결식함
visited_col = [False] * M # 해당 열에서 결식함


def bfs():
    q = deque([(rf, cf, 0, 0)]) # 위치(r, c), 점프 횟수, 결식 유무
    visited[rf][cf][0] = True
    while q:
        y, x, jump, k = q.popleft()
        if (y, x) == (rh, ch):
            return jump
        if k == 0:
            if not visited_row[y]:
                visited_row[y] = True
                for nx in range(M):
                    if not visited[y][nx][1]:
                        visited[y][nx][1] = True
                        q.append((y, nx, jump + 1, 1))
            if not visited_col[x]:
                visited_col[x] = True
                for ny in range(N):
                    if not visited[ny][x][1]:
                        visited[ny][x][1] = True
                        q.append((ny, x, jump + 1, 1))
        # 현재 칸에 쓰인 숫자만큼 점프 가능
        for d in range(4):
            ny = y + dydx[d][0] * graph[y][x]
            nx = x + dydx[d][1] * graph[y][x]
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx][k]:
                # 점프 횟수를 1회 증가시켜 점프함
                visited[ny][nx][k] = True
                q.append((ny, nx, jump + 1, k))

    return -1


print(bfs())