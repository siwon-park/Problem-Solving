# 거울 설치(2151번)
######################################################################################
    # 문제: https://www.acmicpc.net/problem/2151
    # BFS, 다익스트라
    # 3차원의 방문 배열을 선언하고, 어느 방향에서 왔느냐에 따라 방문 배열의 최솟값을 갱신하는 형태로 BFS를 통해 해결하였다.
    # 문제에서 주어진 내용을 잘 이해하고 논리대로 구현하면 되는 문제이다.
    # 거울(!)의 위치에 왔을 때, 무조건 거울을 설치하는 것이 아니라 거울을 설치할 수도 있다.
    # 따라서 그냥 그대로 쭉 가도 되고, 만약 거울을 설치했다면 직전의 방향에 따라 그 다음에 갈 방향이 2갈래로 나뉜다.
    # 거울을 설치했을 경우 남쪽이나 북쪽에서 왔다면, 서쪽이나 동쪽으로, 반대로 서쪽이나 동쪽에서 왔다면 남쪽이나 북쪽으로 갈 수 있다.
######################################################################################
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = []
doors = []
for i in range(N):
    lst = list(input().rstrip())
    for j in range(N):
        if lst[j] == "#":
            doors.append((i, j))
    graph.append(lst)

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

# BFS함수 # 어느 방향에서 왔는가에 따라 다음에 갈 방향이 달라짐
def BFS():
    INF = int(1e9)
    visited = [[[INF for _ in range(4)] for _ in range(N)] for _ in range(N)]
    q = deque()
    y, x = doors[0]
    for k in range(4):
        dy, dx = dydx[k]
        ny, nx = y + dy, x + dx
        if 0 <= ny < N and 0 <= nx < N and graph[ny][nx] != "*":
            q.append((0, k, y, x))
            visited[y][x][k] = 0

    while q:
        cnt, k, y, x = q.popleft() # 거울의 수, 온 방향, y좌표, x좌표 # print("cnt:", cnt, "k:", k, "y:", y, "x:", x)
        dy, dx = dydx[k]
        ny, nx = y + dy, x + dx
        if 0 <= ny < N and 0 <= nx < N:
            if (graph[ny][nx] == "." or graph[ny][nx] == "#") and cnt < visited[ny][nx][k]: # 벽이거나, 문이면 그냥 감
                visited[ny][nx][k] = cnt
                q.append((cnt, k, ny, nx))
            elif graph[ny][nx] == "!" and cnt + 1 < visited[ny][nx][k]: # 거울이면
                if k == 0 or k == 2: # 남쪽이나 북쪽에서 옴 => 서쪽이나 동쪽으로 이동 가능
                    visited[ny][nx][k] = cnt + 1
                    q.append((cnt + 1, 1, ny, nx))
                    q.append((cnt + 1, 3, ny, nx))
                    q.append((cnt, k, ny, nx)) # 거울을 설치하지 않고 가는 경우
                elif k == 1 or k == 3: # 서쪽이나 동쪽에서 옴 => 북쪽이나 남쪽으로 이동 가능
                    visited[ny][nx][k] = cnt + 1
                    q.append((cnt + 1, 0, ny, nx))
                    q.append((cnt + 1, 2, ny, nx))
                    q.append((cnt, k, ny, nx)) # 거울을 설치하지 않고 가는 경우

    ey, ex = doors[1]
    return min(visited[ey][ex])

print(BFS())
