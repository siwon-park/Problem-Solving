# Icy Perimeter(17025번)
################################################################################
    # 문제: https://www.acmicpc.net/problem/17025
    # BFS
    # 문제가 이해가 잘 안 됐고, 어떻게 풀까 고민했었는데 생각보다는 단순했다.
    # "#"인 곳에서 시작해서 BFS 탐색을 하면서 "#"의 개수를 세고, 그 주변의 "."의 개수를 센 다음
    # 가장 큰 "#"의 크기와 그 때의 지름을 출력하면 된다.
    # 단, 문제 조건에 만약 "#"의 크기가 같다면 지름이 작은 것을 출력해야한다.
    # 그래프의 크기를 상하좌우 한칸씩 늘리는 게 포인트이다.
################################################################################
import sys
from collections import deque
input = sys.stdin.readline

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def bfs(r, c):
    a, p = 1, 0
    q = deque([(r, c)])
    while q:
        y, x = q.popleft()
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N + 2 and 0 <= nx < N + 2 and not visited[ny][nx]:
                if graph[ny][nx] == ".":
                    p += 1
                elif graph[ny][nx] == "#":
                    visited[ny][nx] = True
                    a += 1
                    q.append((ny, nx))

    return a, p

N = int(input())
graph = [["." for _ in range(N + 2)] for _ in range(N + 2)]
visited = [[False for _ in range(N + 2)] for _ in range(N + 2)]

for i in range(1, N + 1):
    graph[i] = ["."] + list(input().rstrip()) + ["."]

max_area, max_peri = 0, 0

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if graph[i][j] == "#" and not visited[i][j]:
            visited[i][j] = True
            cur_area, cur_peri = bfs(i, j)
            if max_area < cur_area:
                max_area = cur_area
                max_peri = cur_peri
            elif max_area == cur_area:
                max_peri = min(max_peri, cur_peri)

print(max_area, max_peri)
