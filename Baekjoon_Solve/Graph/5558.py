# Cheese(5558번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/5558
    # BFS
    # 3차원의 방문 배열을 선언하여 k 값에 따라 3차원 계층을 이동하는 방식을 적용하여 BFS 탐색을 적용하였다.
    # Python3로는 시간초과가 나서 Pypy3로 통과할 수 있었다.
    # 그리고 효율적인 풀이를 보니, 3차원의 그래프를 선언할 필요 없이 1, N까지 동안에 작은 범위를 BFS로 탐색하는 방법으로 해결할 수 있었다.
    # 즉, 그래프의 목표 위치에 새겨진 숫자를 k라고 할 때, 특정 지점에서 출발해서 k가 되면 탐색을 종료하고 N을 1개 더 증가시켜서 다음 탐색을 시작한다.
    # 단, 여기서 중요한 것은 방문 배열을 절대 초기화하면 안 된다는 것이다. 방문 배열을 초기화시켜버리면 이런식으로 탐색하는 보람이 없기 때문이다.
######################################################################################
import sys
from collections import deque
input = sys.stdin.readline

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

H, W, N = map(int, input().split())
visited = [[[0 for _ in range(N + 1)] for _ in range(W)] for _ in range(H)]

q = deque()

graph = []
sy, sx = 0, 0
for h in range(H):
    lst = list(input().rstrip())
    for w in range(W):
        if lst[w] == "S":
            q.append((0, 0, h, w))
            visited[h][w][0] = 1
            sy, sx = h, w
        elif lst[w] != "." and lst[w] != "X":
            lst[w] = int(lst[w])
    graph.append(lst)

def bfs(q):
    graph[sy][sx] = "."
    max_k = 0
    while q:
        k, cnt, y, x = q.popleft()
        if k < max_k:
            continue
        if k == N:
            return cnt
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < H and 0 <= nx < W:
                if not visited[ny][nx][k] and graph[ny][nx] != "X":
                    visited[ny][nx][k] = visited[y][x][k] + 1
                    if graph[ny][nx] != "." and graph[ny][nx] == k + 1:
                        q.append((k + 1, cnt + 1, ny, nx))
                        max_k = k + 1
                    else:
                        q.append((k, cnt + 1, ny, nx))

print(bfs(q))
