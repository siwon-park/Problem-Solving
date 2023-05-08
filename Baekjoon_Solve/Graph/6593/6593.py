import sys
from collections import deque
input = sys.stdin.readline

dydxdz = [(-1, 0, 0), (0, 1, 0), (1, 0, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1)] # 델타(dy, dx, dz)


def bfs(q: deque, graph: list, visited: list) -> int:
    global tr, tc, tl, R, C, L
    while q:
        d, y, x, z = q.popleft()
        if (y, x, z) == (tr, tc, tl):
            return d
        for dy, dx, dz in dydxdz:
            ny, nx, nz = y + dy, x + dx, z + dz
            if 0 <= ny < R and 0 <= nx < C and 0 <= nz < L:
                if graph[nz][ny][nx] != "#" and not visited[nz][ny][nx]:
                    visited[nz][ny][nx] = True
                    q.append((d + 1, ny, nx, nz))
    return -1


while True:
    L, R, C = map(int, input().rstrip().split()) # 층, 행, 열
    if (L, R, C) == (0, 0, 0):
        break
    graph = [[] for _ in range(L)]
    visited = [[[False for _ in range(C)] for _ in range(R)] for _ in range(L)]
    q = deque()

    tr, tc, tl = 0, 0, 0
    for l in range(L):
        for r in range(R):
            graph[l].append(list(input().rstrip()))
            for c in range(C):
                if graph[l][r][c] == "S":
                    q.append((0, r, c, l)) # 이동 거리, y좌표, x좌표, z축
                    visited[l][r][c] = True
                elif graph[l][r][c] == "E":
                    tr, tc, tl = r, c, l
        input().rstrip() # 개행문자 입력

    x = bfs(q, graph, visited)
    if x == -1:
        print("Trapped!")
    else:
        print(f"Escaped in {x} minute(s).")